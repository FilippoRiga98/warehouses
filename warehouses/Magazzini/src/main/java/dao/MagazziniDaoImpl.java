package main.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MagazziniDaoImpl implements MagazziniDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
	      this.jdbcTemplate = jdbcTemplate;
	}
	
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
}
