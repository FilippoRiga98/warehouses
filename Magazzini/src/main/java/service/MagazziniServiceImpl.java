package main.java.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.dao.MagazziniDao;

@Service
public class MagazziniServiceImpl implements MagazziniService {

	@Resource(name = "magazziniDao")
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
