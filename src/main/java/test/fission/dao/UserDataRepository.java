package test.fission.dao;

import java.util.List;

public interface UserDataRepository<T> {

    void add(T entity);
    void updateAll(List<T> entities);
    List<T> getAll();
}
