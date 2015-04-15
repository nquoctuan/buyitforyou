package com.icephoenix.ulticustomize.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icephoenix.ulticustomize.model.Person;

/**
 * @author Quan
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}