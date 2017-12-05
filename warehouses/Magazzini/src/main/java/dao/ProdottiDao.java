package main.java.dao;

import java.util.ArrayList;


import main.java.dto.ProdottiDto;
import main.java.dto.TipoProdottiDto;

public interface ProdottiDao {

	public ArrayList<TipoProdottiDto> getAllTypes();
	public void saveProduct(ProdottiDto prodotto);
	public ArrayList<ProdottiDto> getAllProducts();
	public ArrayList<ProdottiDto> getAllProductsByType(String type);
}
