package com.application.worksheetshare.service.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class GenericService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
