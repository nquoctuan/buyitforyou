package com.icephoenix.ulticustomize.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icephoenix.ulticustomize.model.Person;
import com.icephoenix.ulticustomize.service.PersonService;

/**
 * @author Quan
 * Controller for authentication process
 */
@Controller
public class AuthController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value ="/login.htm", method = RequestMethod.GET)
	public String LoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value ="/signup.htm", method = RequestMethod.GET)
	public String SingupPage(Model model) {
		return "users/signup";
	}
	
	@RequestMapping(value = "/createUser.htm", method = RequestMethod.POST)
	public String CreateUser(@ModelAttribute Person person, Model model) {
		
		if(!personService.exist(person.getUsername())) {
			Person p = personService.createPerson(person);
			model.addAttribute("createdPerson", p);
			return "home";
		}
		else {
			model.addAttribute("error", "User already exists");
			return "users/signup";
		}		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/updateUser.htm", method = RequestMethod.POST)
	public Person UpdateUser(@RequestParam String username, @RequestParam String email, @RequestParam int role) {
		if(username != null && username != "") {
			Person inputPerson = personService.findByUsername(username);
			if(inputPerson != null) {
				inputPerson.setRole(role);
				inputPerson.setEmail(email);
				return personService.savePerson(inputPerson);
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/admin/dashboard.htm", method = RequestMethod.GET)
	public String UserDashboard(Model model) {
		return "/users/userManagement";
	}
}
