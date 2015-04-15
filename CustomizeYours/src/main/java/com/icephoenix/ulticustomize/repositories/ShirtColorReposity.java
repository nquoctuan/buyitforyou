package com.icephoenix.ulticustomize.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icephoenix.ulticustomize.model.ShirtColor;

@Repository
public interface ShirtColorReposity extends CrudRepository<ShirtColor, String> {

}
