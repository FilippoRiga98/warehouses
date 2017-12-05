package main.java.service;

import java.util.ArrayList;

import main.java.pojo.Prodotti;
import main.java.pojo.TipoProdotti;


public interface ProdottiService {

	public ArrayList<TipoProdotti> getAllTypes(); 
	public void saveProduct(Prodotti prodotto);
	public ArrayList<Prodotti> getAllProducts();
	public ArrayList<Prodotti> getAllProductsByType(String type);
}
