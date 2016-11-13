package com.askus.service;

import java.util.List;

import com.askus.model.Person;

public interface PersonService {
	public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
    public List<Person> searchPerson(String name);

}
