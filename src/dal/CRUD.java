package dal;

import java.util.List;

public interface CRUD {
    <T> boolean create(T obj);
    <T> T get(Class<T> type, long id);
    <T> List<T> getAll(Class<T> type);
    <T> boolean update(T type);
    <T> boolean delete(Class<T> type, long id);
}
