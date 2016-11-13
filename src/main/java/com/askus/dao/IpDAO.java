package com.askus.dao;

import java.util.List;

import com.askus.model.Ip;

public interface IpDAO {
	public void addIpAddress(Ip ip);
	public List<Ip> getIpByAddress(String ip,int post_id);
	
}
