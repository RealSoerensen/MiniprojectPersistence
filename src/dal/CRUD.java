package dal;

import java.util.List;

public interface CRUD {
    boolean create(Object obj);
    Object get(long id);
    List<Object> getAll();
    boolean update(Object obj);
    boolean delete(long id);
}
