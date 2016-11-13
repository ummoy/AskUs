package com.askus.service;

import java.util.List;

import com.askus.model.Ip;

public interface IpService {
	public void addIpAddress(Ip ip);
	public List<Ip> getIpByAddress(String ip,int post_id);
}
