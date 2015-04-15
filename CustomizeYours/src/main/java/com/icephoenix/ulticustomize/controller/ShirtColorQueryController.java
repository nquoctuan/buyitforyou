package com.icephoenix.ulticustomize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephoenix.ulticustomize.model.ShirtColor;
import com.icephoenix.ulticustomize.service.ShirtColorService;

@Controller
public class ShirtColorQueryController {

	@Autowired
	ShirtColorService shirtColorService;
	
	@RequestMapping(value = "/api/getShirtColorList.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<ShirtColor> GetAllShirtColor(){
		return shirtColorService.getAllShirtColor();
	}
	
	@RequestMapping(value = "/api/shirtColor.htm", method = RequestMethod.GET)
	@ResponseBody
	public ShirtColor GetShirtColorById(String id){
		return shirtColorService.getShirtColorById(id);
	}
}
