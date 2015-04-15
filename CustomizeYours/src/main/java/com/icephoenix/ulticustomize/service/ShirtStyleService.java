package com.icephoenix.ulticustomize.service;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephoenix.ulticustomize.model.ShirtStyle;
import com.icephoenix.ulticustomize.repositories.ShirtStyleRepository;

@Service
public class ShirtStyleService {

	@Autowired
	ShirtStyleRepository shirtStyleRepository;

	public ShirtStyle createShirtStyle(ShirtStyle ss) {
		return shirtStyleRepository.save(ss);
	}

	public void deleteShirtStyle(ShirtStyle ss) {
		shirtStyleRepository.delete(ss);
	}

	public List<ShirtStyle> getAllShirtStyle() {
		return IteratorUtils.toList(shirtStyleRepository.findAll().iterator());
	}

	public ShirtStyle getShirtStyleById(String id) {
		return shirtStyleRepository.findOne(id);
	}
}
