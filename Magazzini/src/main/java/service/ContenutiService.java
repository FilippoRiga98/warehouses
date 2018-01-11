package main.java.service;

import java.util.ArrayList;

import main.java.pojo.Contenuti;


public interface ContenutiService {

	public void saveContent(Contenuti contenuto);
	public ArrayList<Contenuti> getWarehouseAvailableContent(String nameWarehouse);
	public Contenuti getContentByIdProdotto(int idProdotto);
	public void initializeWarehouses();
	public boolean areEmpty();
	public void changeState(long idContenuto);
}
