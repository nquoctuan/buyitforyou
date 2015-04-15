package com.icephoenix.ulticustomize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephoenix.ulticustomize.model.Person;
import com.icephoenix.ulticustomize.service.PersonService;

/**
 * @author Quan
 * Controller Which will serve as rest query for Person
 */
@Controller
public class PersonQueryController {
	
	@Autowired
	PersonService personService;
	
	/**
	 * REST api which returns list of people
	 * @param page
	 * @param rows
	 * @return list of person
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/getPersonList.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> GetAllUser(@RequestParam(defaultValue = "1", required = false) int page, 
			@RequestParam(defaultValue = "10", required = false) int rows) {
		return personService.getAllPerson(new PageRequest(page - 1, rows));
	}
	
	/**
	 * Query person by username
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/api/personByUsername.htm", method = RequestMethod.GET)
	@ResponseBody
	public Person GetPersonByUserName(@RequestParam String userName) {
		return personService.findByUsername(userName);
	}
	
	/**
	 * Checking whether a username exists in DB
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/api/checkUserExist.htm", method = RequestMethod.GET)
	@ResponseBody
	public boolean IsExist(@RequestParam String userName) {
		return personService.exist(userName);
	}
}
