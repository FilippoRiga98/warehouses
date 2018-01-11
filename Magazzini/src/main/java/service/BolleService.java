package main.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import main.java.pojo.Bolle;

@Service
public interface BolleService {

	public void saveBill(Bolle bolla);
	public ArrayList<Bolle> getAllBills();
	public void orderProducts(int numOrdini);
	public int countOrdersByState(boolean stato);
	public int countOrder();
}
