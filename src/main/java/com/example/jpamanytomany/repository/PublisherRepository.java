package com.example.jpamanytomany.repository;

import com.example.jpamanytomany.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer>{
}
