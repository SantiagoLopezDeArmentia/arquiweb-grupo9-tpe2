package repositories;


import java.util.List;

public interface Repository<T> {

    void add(T t);
    void update(T t);
    void delete(T t);
    T find(Long id);
    List<T> findAll();

}
