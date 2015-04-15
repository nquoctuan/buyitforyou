package com.icephoenix.ulticustomize.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icephoenix.ulticustomize.model.Person;
import com.icephoenix.ulticustomize.repositories.PersonQueryRepository;
import com.icephoenix.ulticustomize.repositories.PersonRepository;

/**
 * @author Quan
 * Service for Person entity
 *
 */
@Service("userDetailsService")
public class PersonService implements UserDetailsService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonQueryRepository personQueryRepository;
	
	/**
	 * Return all persons
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson(Pageable pageable) {
		return IteratorUtils.toList(personQueryRepository.findAll(pageable).iterator());
	}
	
	/**
	 * Return person by username
	 * @param uname
	 * @return person entity with given 
	 */
	public Person findByUsername(String uname) {
		return personQueryRepository.findByUsername(uname);
	}
	
	/**
	 * Create new person
	 * @param p
	 * @return new person
	 */
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	/**
	 * Delete a person
	 * @param p
	 */
	public void deletePerson(Person p) {
		personRepository.delete(p);
	}
	
	/**
	 * delete person by ID
	 * @param id
	 */
	public void deletePersonById(String id) {
		personRepository.delete(id);
	}
	
	/**
	 * @param p
	 * @return saved person
	 */
	public Person savePerson(Person p) {
		return personRepository.save(p);
	}
	
	/**
	 * Check whether a person with input username existed
	 * @param username
	 * @return true if existing
	 */
	public boolean exist(String username) {
		return personQueryRepository.countByUsername(username) > 0;
	}
	
	/**
	 * Implements method for custom UserDetailsService in Spring Security
	 * @param uName
	 * @return user detail object for Spring Security
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String uName)
			throws UsernameNotFoundException {
		Person connectedPerson = findByUsername(uName);
		
		if(connectedPerson == null) {
			throw new UsernameNotFoundException(uName);
		}
		
		int pRole = connectedPerson.getRole();
		String strRole = "ROLE_GUEST";
		
		if(pRole == 1)
			strRole = "ROLE_USER";
		else if (pRole == 10)
			strRole = "ROLE_ADMIN";
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(strRole);
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(authority);
		
		User internalUser = new User(connectedPerson.getUsername(), 
									 connectedPerson.getPassword(), authList);
		
		return internalUser;
	}
}
