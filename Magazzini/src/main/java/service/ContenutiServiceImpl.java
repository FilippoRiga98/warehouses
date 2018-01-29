package main.java.service;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.dao.ContenutiDao;
import main.java.dto.ContenutiDto;
import main.java.pojo.Contenuti;
import main.java.pojo.Prodotti;

@Service
public class ContenutiServiceImpl implements ContenutiService {

	@Resource(name = "contenutiDao")
	private ContenutiDao contentDao;
	@Resource(name = "prodottiServiceImpl")
	private ProdottiService productService;

	
	Random rnd = new Random();
	
	@Override
	public void saveContent(Contenuti contenuto)
	{
		ContenutiDto content = new ContenutiDto(contenuto);
		contentDao.saveContent(content);
	}

	@Override
	public ArrayList<Contenuti> getWarehouseAvailableContent(String nameWarehouse) {
		
		ArrayList<Contenuti> contentList = new ArrayList<Contenuti>(); 
		ArrayList<ContenutiDto> dataContentList = contentDao.getWarehouseAvailableContent(nameWarehouse);
		for(ContenutiDto listObject : dataContentList)
		{
			Contenuti content = new Contenuti();
			content.setIdContenuto(listObject.getIdContenuto());
			content.setIdProdotto(listObject.getIdProdotto());
			content.setStato(listObject.getStato());
			content.setWarehouse(listObject.getWarehouse());
			contentList.add(content);
		}
		return contentList;
	}

	@Override
	public void initializeWarehouses() {
		
		
		 //Inizializzazione del numero di prodotti di ogni tipo che verranno inseriti nel warehouseA
		 int numTelevisori = 10;
		 int numLavatrici = 5;
		 int numSmartphone = 50;
		 int numFrigoriferi = 5;
		 //Read dal DATABASE dei prodotti di ogni tipo
		 ArrayList<Prodotti> televisori = productService.getAllProductsByType("Televisore");
		 ArrayList<Prodotti> lavatrici = productService.getAllProductsByType("Lavatrice");
		 ArrayList<Prodotti> smartphone = productService.getAllProductsByType("Smartphone");
		 ArrayList<Prodotti> frigoriferi = productService.getAllProductsByType("Frigorifero");
		 ArrayList<Prodotti> productList = productService.getAllProducts();
		 //SAVE nel database di tutti i prodotti che non vengono collegati a nessun warehouse per gestire i prodotti non trovati
		 for(int i = 0; i < productList.size(); i++)
		 {
			 Contenuti tmp = new Contenuti();
			 tmp.setIdProdotto(productList.get(i).getIdProdotto());	
			 tmp.setStato(false);
			 saveContent(tmp);
		 }
		 //Ciclo di inzializzazione del warehouseA
		 for(int i = 0; i < numTelevisori + numLavatrici + numSmartphone + numFrigoriferi ; i++)
		 {
			 rnd = new Random();
			 Contenuti tmp = new Contenuti();
			 /**Tramite un indice casuale < = alla grandezza delle liste per tipo di prodotto viene settato l'id
			  * di "tmp che andr� poi inserito in warehouseA e infine salvato su DATABASE"*/
			 if(i < numTelevisori) 
			 {
				 tmp.setIdProdotto(televisori.get(rnd.nextInt(televisori.size())).getIdProdotto());	
			 }
			 else if(i < numTelevisori + numLavatrici)
			 {
				 tmp.setIdProdotto(lavatrici.get(rnd.nextInt(lavatrici.size())).getIdProdotto());
			 }
			 else if(i < numTelevisori + numLavatrici + numSmartphone)
			 {
				 tmp.setIdProdotto(smartphone.get(rnd.nextInt(smartphone.size())).getIdProdotto());
			 }
			 else if(i < numTelevisori + numLavatrici + numSmartphone + numFrigoriferi)
			 {
				 tmp.setIdProdotto(frigoriferi.get(rnd.nextInt(frigoriferi.size())).getIdProdotto());
			 }			
			 tmp.setWarehouse("warehouseA");
			 tmp.setStato(true);
			
			 saveContent(tmp);
		 }

	}

	@Override
	public boolean areEmpty() {
		
		ArrayList<Contenuti> warehouseA = getWarehouseAvailableContent("warehouseA");
		ArrayList<Contenuti> warehouseB = getWarehouseAvailableContent("warehouseB");
		//Controllo della possibilit� di evadere ancora ordini
		boolean stop = false;
		if((warehouseA.size() + warehouseB.size()) < 2)
		{
			stop = true;
		}
		
		return stop;
	}

	@Override
	public Contenuti getContentByIdProdotto(int idProdotto) {
		
		Contenuti content = new Contenuti();
		ContenutiDto contentDto = contentDao.getContentByIdProdotto(idProdotto);
		content.setIdContenuto(contentDto.getIdContenuto());
		content.setIdProdotto(contentDto.getIdProdotto());
		content.setStato(contentDto.getStato());
		content.setWarehouse(contentDto.getWarehouse());
		return content;
	}

	@Override
	public void changeState(long idContenuto) {
		
		contentDao.changeState(idContenuto);
	}

}
