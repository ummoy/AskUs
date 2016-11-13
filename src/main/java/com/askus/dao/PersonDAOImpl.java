package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.askus.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
@Repository
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
		
	}

	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
		
	}

	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
	}

	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        
        logger.info("Person deleted successfully, person details="+p);
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Person> searchPerson(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		//String hql="from Person";
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person where name like '%"+name+"%'").list();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
	}
	

}
