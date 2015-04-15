package com.icephoenix.ulticustomize.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icephoenix.ulticustomize.model.ShirtStyle;

@Repository
public interface ShirtStyleRepository extends CrudRepository<ShirtStyle, String> {

}
