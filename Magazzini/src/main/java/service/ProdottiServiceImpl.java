package main.java.service;

import java.util.ArrayList;

import main.java.dao.ProdottiDao;
import main.java.dto.ProdottiDto;
import main.java.dto.TipoProdottiDto;
import main.java.pojo.Prodotti;
import main.java.pojo.TipoProdotti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProdottiServiceImpl implements ProdottiService {

	@Autowired
	private ProdottiDao productDao;
	
	@Override
	public ArrayList<TipoProdotti> getAllTypes() {
			
		ArrayList<TipoProdotti> productTypeList = new ArrayList<TipoProdotti>(); 
		ArrayList<TipoProdottiDto> dataProductTypeList = productDao.getAllTypes();
		for(TipoProdottiDto listObject : dataProductTypeList)
		{
			TipoProdotti productType = new TipoProdotti();
			productType.setTipoProdotto(listObject.getTipoProdotto());
			productTypeList.add(productType);
		}
		return productTypeList;
	}
	
	@Override
	public String saveProduct(Prodotti prodotto) {
		
		try {
			
   		ProdottiDto product = new ProdottiDto(prodotto);
   		productDao.saveProduct(product);
   		return "true";
   		
		}catch(Exception e) {
			
			return "false";
			
		}
	}
	
	@Override
	public ArrayList<Prodotti> getAllProducts() {
		
		ArrayList<Prodotti> productList = new ArrayList<Prodotti>(); 
		ArrayList<ProdottiDto> dataProductList = productDao.getAllProducts();
		for(ProdottiDto listObject : dataProductList)
		{
			Prodotti product = new Prodotti();
			product.setIdProdotto(listObject.getIdProdotto());
			product.setMarcaProdotto(listObject.getMarcaProdotto());
			product.setModelloProdotto(listObject.getModelloProdotto());
			product.setTipoProdotto(listObject.getTipoProdotto());
			productList.add(product);
		}
		return productList;
	}
	
	@Override
	public ArrayList<Prodotti> getAllProductsByType(String type)
	{
		ArrayList<Prodotti> productList = new ArrayList<Prodotti>(); 
		ArrayList<ProdottiDto> dataProductList = productDao.getAllProductsByType(type);
		for(ProdottiDto listObject : dataProductList)
		{
			Prodotti product = new Prodotti();
			product.setIdProdotto(listObject.getIdProdotto());
			product.setMarcaProdotto(listObject.getMarcaProdotto());
			product.setModelloProdotto(listObject.getModelloProdotto());
			product.setTipoProdotto(listObject.getTipoProdotto());
			productList.add(product);
		}
		return productList;
	}
}
