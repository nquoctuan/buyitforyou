package com.icephoenix.ulticustomize.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.icephoenix.ulticustomize.model.Person;

/**
 * @author Quan
 * Repository which serves as querying dispatcher for Person entity
 */
@Repository
public interface PersonQueryRepository extends
		PagingAndSortingRepository<Person, String> {
	Person findByUsername(String username);
	Long countByUsername(String username);
}
