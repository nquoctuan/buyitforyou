package com.icephoenix.ulticustomize.service;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephoenix.ulticustomize.model.ShirtColor;
import com.icephoenix.ulticustomize.repositories.ShirtColorReposity;

@Service
public class ShirtColorService {

	@Autowired
	ShirtColorReposity shirtColorRepository;
	
	public ShirtColor createShirtColor(ShirtColor sc){
		return shirtColorRepository.save(sc);
	}
	
	public void deleteShirtColor(ShirtColor sc){
		shirtColorRepository.delete(sc);
	}
	
	public List<ShirtColor> getAllShirtColor(){
		return IteratorUtils.toList(shirtColorRepository.findAll().iterator());
	}

	public ShirtColor getShirtColorById(String id) {
		return shirtColorRepository.findOne(id);
	}
}
