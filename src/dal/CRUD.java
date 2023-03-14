package dal;

import java.util.List;

public interface CRUD {
    boolean create(Object obj);
    Object get(int id);
    List<Object> getAll();
    boolean update(Object obj);
    boolean delete(int id);
}
