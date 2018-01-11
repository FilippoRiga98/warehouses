package main.java.dao;

import java.util.ArrayList;

import main.java.dto.BolleDto;

import org.springframework.stereotype.Repository;

@Repository
public interface BolleDao {

	public void saveBill(BolleDto bill);
	public ArrayList<BolleDto> getAllBills();
	public int countOrdersByState(boolean stato);
	public int countOrder();
}
