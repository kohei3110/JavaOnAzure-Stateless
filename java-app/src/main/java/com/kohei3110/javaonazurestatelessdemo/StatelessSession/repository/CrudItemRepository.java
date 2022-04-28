package com.kohei3110.javaonazurestatelessdemo.StatelessSession.repository;

import com.kohei3110.javaonazurestatelessdemo.StatelessSession.model.Todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudItemRepository extends CrudRepository<Todo, String> {
    
}
