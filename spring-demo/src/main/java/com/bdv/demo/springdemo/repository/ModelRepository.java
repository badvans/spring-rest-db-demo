package com.bdv.demo.springdemo.repository;

import com.bdv.demo.springdemo.model.ModelEntity;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<ModelEntity, Long> {
}
