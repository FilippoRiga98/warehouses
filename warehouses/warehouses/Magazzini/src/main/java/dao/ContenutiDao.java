package main.java.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import main.java.dto.ContenutiDto;

@Repository
public interface ContenutiDao {

	public void saveContent(ContenutiDto content);
	public ArrayList<ContenutiDto> getWarehouseAvailableContent(String nameWarehouse);
	public ContenutiDto getContentByIdProdotto(int idProdotto);
	public void changeState(long idContenuto);
}
