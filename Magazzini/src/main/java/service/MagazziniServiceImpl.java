package main.java.service;

import main.java.dao.MagazziniDao;

import org.springframework.beans.factory.annotation.Autowired;

public class MagazziniServiceImpl implements MagazziniService {

	@Autowired
	private MagazziniDao dao;
	
	@Override
	public void deleteTable(String table)
	{
		dao.deleteTable(table);
	}

	@Override
	public void truncateTable(String table) {
		
		dao.truncateTable(table);
	}
}
