package main.java.service;

import java.util.ArrayList;

import main.java.pojo.Prodotti;
import main.java.pojo.TipoProdotti;

import org.springframework.stereotype.Service;

@Service
public interface ProdottiService {

	public ArrayList<TipoProdotti> getAllTypes(); 
	public String saveProduct(Prodotti prodotto);
	public ArrayList<Prodotti> getAllProducts();
	public ArrayList<Prodotti> getAllProductsByType(String type);
}
