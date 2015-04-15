package com.icephoenix.ulticustomize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShirtColorController {

	@RequestMapping(value ="/admin/shirtcolormgmt.htm", method = RequestMethod.GET)
	public String ShirtColorMgmt(Model model) {
		return "/admin/shirtColorMgmt";
	}
}
