package com.askus.service;

import java.util.List;

import com.askus.dao.PersonDAO;
import com.askus.model.Person;
import org.springframework.transaction.annotation.Transactional;

public class PersonServiceImpl implements PersonService{

	private PersonDAO PersonDAO;
	@Transactional
	public void addPerson(Person p) {
		PersonDAO.addPerson(p);
		
	}
	@Transactional
	public void updatePerson(Person p) {
		PersonDAO.updatePerson(p);
		
	}
	@Transactional
	public List<Person> listPersons() {
		return this.PersonDAO.listPersons();
	}
	@Transactional
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return this.PersonDAO.getPersonById(id);
	}
	@Transactional
	public void removePerson(int id) {
		// TODO Auto-generated method stub
		PersonDAO.removePerson(id);
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.PersonDAO = personDAO;
	}
	@Transactional
	public List<Person> searchPerson(String name) {
		// TODO Auto-generated method stub
		return this.PersonDAO.searchPerson(name);
	}
	

}
