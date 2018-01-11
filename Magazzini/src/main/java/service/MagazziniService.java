package main.java.service;

import org.springframework.stereotype.Service;

@Service
public interface MagazziniService {

	public void deleteTable(String table);
	public void truncateTable(String table);
}
