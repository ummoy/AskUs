package com.askus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.askus.dao.IpDAO;
import com.askus.model.Ip;

public class IpServiceImpl implements IpService {

	private IpDAO ipDAO;
	@Transactional
	public void addIpAddress(Ip ip) {
		this.ipDAO.addIpAddress(ip);
		
	}
	@Transactional
	public List<Ip> getIpByAddress(String ip,int post_id) {
		// TODO Auto-generated method stub
		return this.ipDAO.getIpByAddress(ip,post_id);
	}

	public void setIpDAO(IpDAO ipDAO) {
		this.ipDAO = ipDAO;
	}

}
