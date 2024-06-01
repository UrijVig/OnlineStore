package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository;

import java.util.List;
import java.util.Optional;

public interface AbstractDBRepository<T> {
    public T save(T t);

    public List<T> findAll();
    public Optional<T> findById(Long id);
    public Optional<T> findByName(String name);
    public void deleteById(Long id);
}
