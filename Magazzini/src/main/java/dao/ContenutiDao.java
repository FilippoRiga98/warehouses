package main.java.dao;

import java.util.ArrayList;


import main.java.dto.ContenutiDto;

public interface ContenutiDao {

	public void saveContent(ContenutiDto content);
	public ArrayList<ContenutiDto> getWarehouseAvailableContent(String nameWarehouse);
	public ContenutiDto getContentByIdProdotto(int idProdotto);
	public void changeState(long idContenuto);
}
