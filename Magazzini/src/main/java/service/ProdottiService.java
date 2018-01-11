<<<<<<< HEAD:Magazzini/src/main/java/service/ProdottiService.java
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
=======
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
>>>>>>> 20ce457a0de1880cd897abcb11eb421c97be2d00:warehouses/Magazzini/src/main/java/service/ProdottiService.java
