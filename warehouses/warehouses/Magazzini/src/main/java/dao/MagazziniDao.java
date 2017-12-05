package main.java.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface MagazziniDao {

	public void deleteTable(String table);
	public void truncateTable(String table);
}
