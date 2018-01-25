package main.java.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import main.java.dao.MagazziniDao;


public class MagazziniDaoImpl implements MagazziniDao {


	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void deleteTable(String table) {
		
		String sql = "DELETE FROM " + table;
		jdbcTemplate.update(sql);
	}

	@Override
	public void truncateTable(String table) {
		
		String sql = "TRUNCATE TABLE " + table;
		jdbcTemplate.update(sql);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
      this.jdbcTemplate = jdbcTemplate;
	}
}
