package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.askus.model.Ip;
import com.askus.model.Person;

@Repository
public class IpDAOImpl implements IpDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	 
    private SessionFactory sessionFactory;
	public void addIpAddress(Ip ip) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(ip);
        logger.info("Ip saved successfully, Ip Details="+ip);
		
	}

	public List<Ip> getIpByAddress(String ip,int post_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Ip> ipList = session.createQuery("from Ip where ipaddress='"+ip+"' AND post_id="+post_id).list();
        for(Ip iplist : ipList){
            logger.info("Ip List::"+iplist);
        }
        return ipList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
