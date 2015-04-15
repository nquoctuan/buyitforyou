package com.icephoenix.ulticustomize.service;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephoenix.ulticustomize.model.TshirtGang;
import com.icephoenix.ulticustomize.repositories.TshirtGangRepository;

@Service
public class TshirtGangService {

	@Autowired
	TshirtGangRepository tshirtGangRepository;
	
	public TshirtGang createTshirtGang(TshirtGang tg) {
		return tshirtGangRepository.save(tg);
	}
	
	public void deleteTshirtGang(TshirtGang tg) {
		tshirtGangRepository.delete(tg);
	}
	
	public List<TshirtGang> getAllTshirtGang(){
		return IteratorUtils.toList(tshirtGangRepository.findAll().iterator());
	}
	
	public TshirtGang getTshirtGangById(String id){
		return tshirtGangRepository.findOne(id);
	}
}
