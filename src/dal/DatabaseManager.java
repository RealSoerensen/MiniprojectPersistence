package dal;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager implements CRUD {
    DBConnection dbConnection;
    Connection con;

    public DatabaseManager() throws SQLException {
        dbConnection = DBConnection.getInstance();
        con = DBConnection.getConnection();
    }

    @Override
    public <T> boolean create(T obj) {
        boolean result = false;
        String[] columnNames;
        String[] values;

        DatabaseUtils.TableInfo tableInfo = DatabaseUtils.getTableInfo(obj.getClass());
        String tableName = tableInfo.tableName;
        String[] fieldNames = tableInfo.fieldNames;
        Class<?>[] fieldTypes = tableInfo.fieldTypes;

        columnNames = Arrays.copyOfRange(fieldNames, 1, fieldNames.length);
        values = new String[columnNames.length];

        for (int i = 0; i < columnNames.length; i++) {
            values[i] = "?";
        }

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, String.join(", ", columnNames), String.join(", ", values));

        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int index = 1;
            for (int i = 1; i < fieldNames.length; i++) {
                String fieldName = fieldNames[i];
                Class<?> fieldType = fieldTypes[i];
                String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                Method getter = obj.getClass().getMethod(getterName);
                Object value = getter.invoke(obj);
                if (fieldType == double.class) {
                    stmt.setDouble(index++, (Double) value);
                } else if (fieldType == long.class) {
                    stmt.setLong(index++, (Long) value);
                } else if (fieldType == int.class) {
                    stmt.setInt(index++, (Integer) value);
                } else if (fieldType == String.class) {
                    stmt.setString(index++, (String) value);
                } else if (fieldType == Timestamp.class) {
                    stmt.setTimestamp(index++, (Timestamp) value);
                } else {
                    throw new IllegalArgumentException("Unsupported field type: " + fieldType.getName());
                }
            }
            stmt.executeUpdate();
            result = true;
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public <T> T get(Class<T> type, long id) {
        T result = null;

        DatabaseUtils.TableInfo tableInfo = DatabaseUtils.getTableInfo(type);
        String tableName = tableInfo.tableName;
        String[] fieldNames = tableInfo.fieldNames;

        String sql = String.format("SELECT %s FROM %s WHERE %s = ?", String.join(", ", fieldNames), tableName, fieldNames[0]);

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = type.getDeclaredConstructor().newInstance();

                }
            }
        } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public <T> List<T> getAll(Class<T> type) {
        List<T> result = new ArrayList<>();

        DatabaseUtils.TableInfo tableInfo = DatabaseUtils.getTableInfo(type);
        String tableName = tableInfo.tableName;
        String[] fieldNames = tableInfo.fieldNames;
        Class<?>[] fieldTypes = tableInfo.fieldTypes;

        String sql = String.format("SELECT %s FROM %s", String.join(", ", fieldNames), tableName);

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    T obj = type.getDeclaredConstructor().newInstance();
                    for(int i = 0; i < fieldNames.length; i++) {
                        String fieldName = fieldNames[i];
                        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                        Method setter = type.getMethod(setterName, fieldTypes[i]);
                        if (fieldName.contains("Id")) {
                            long value = rs.getLong(fieldName);
                            setter.invoke(obj, value);
                        } else if (fieldName.contains("Price")) {
                            double value = rs.getDouble(fieldName);
                            setter.invoke(obj, value);
                        } else if (fieldName.contains("Date") || fieldName.contains("date")) {
                            Timestamp value = rs.getTimestamp(fieldName);
                            setter.invoke(obj, value);
                        } else {
                            try {
                                String value = rs.getString(fieldName);
                                setter.invoke(obj, value);
                            } catch (IllegalArgumentException e) {
                                int value = rs.getInt(fieldName);
                                setter.invoke(obj, value);
                            }
                        }
                    }
                    result.add(obj);
                }
            }
        } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public <T> boolean update(T obj) {
        boolean result = false;

        // Determine the table name, field names, and primary key field name for the object type
        DatabaseUtils.TableInfo tableInfo = DatabaseUtils.getTableInfo(obj.getClass());
        String tableName = tableInfo.tableName;
        String[] fieldNames = tableInfo.fieldNames;
        Class<?>[] fieldTypes = tableInfo.fieldTypes;
        String primaryKeyFieldName = fieldNames[0];

        // Construct the SQL statement for updating the object in the database
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");
        for (String fieldName : fieldNames) {
            if (!fieldName.equals(primaryKeyFieldName)) {
                sb.append(fieldName).append(" = ?, ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" WHERE ").append(primaryKeyFieldName).append(" = ?");
        String sql = sb.toString();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Set the parameter values for the prepared statement
            int index = 1;
            for (int i = 0; i < fieldNames.length; i++) {
                String fieldName = fieldNames[i];
                if (!fieldName.equals(primaryKeyFieldName)) {
                    Method getter = obj.getClass().getMethod("get" + capitalize(fieldName));
                    Object value = getter.invoke(obj);
                    if (value != null) {
                        if (fieldTypes[i] == Timestamp.class) {
                            stmt.setTimestamp(index++, (Timestamp) value);
                        } else {
                            stmt.setObject(index++, value);
                        }
                    } else {
                        stmt.setNull(index++, Types.NULL);
                    }
                }
            }
            Method getter = obj.getClass().getMethod("get" + capitalize(primaryKeyFieldName));
            Object primaryKeyValue = getter.invoke(obj);
            stmt.setObject(index, primaryKeyValue);

            // Execute the prepared statement and set the result to true if the update was successful
            int updateCount = stmt.executeUpdate();
            if (updateCount > 0) {
                result = true;
            }
        } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Helper method to capitalize the first letter of a string
    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }


    @Override
    public <T> boolean delete(Class<T> type, long id) {
        boolean result = false;
        DatabaseUtils.TableInfo tableInfo = DatabaseUtils.getTableInfo(type);
        String tableName = tableInfo.tableName;
        String[] fieldNames = tableInfo.fieldNames;

        String sql = String.format("DELETE FROM %s WHERE %s = ?", tableName, fieldNames[0]);

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setObject(1, id);
                int rowsAffected = stmt.executeUpdate();
                result = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
