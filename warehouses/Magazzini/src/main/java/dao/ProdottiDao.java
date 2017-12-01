package main.java.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import main.java.dto.ProdottiDto;
import main.java.dto.TipoProdottiDto;

@Repository
public interface ProdottiDao {

	public ArrayList<TipoProdottiDto> getAllTypes();
	public void saveProduct(ProdottiDto prodotto);
	public ArrayList<ProdottiDto> getAllProducts();
	public ArrayList<ProdottiDto> getAllProductsByType(String type);
}
