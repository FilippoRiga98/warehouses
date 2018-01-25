package main.java.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import main.java.dao.BolleDao;
import main.java.dto.BolleDto;
import main.java.pojo.Bolle;
import main.java.pojo.Contenuti;
import main.java.pojo.Prodotti;

@Service
public class BolleServiceImpl implements BolleService{

	@Autowired
	private BolleDao billDao;
	@Autowired
	private ProdottiService productService;
	@Autowired
	private ContenutiService contentService;
	
	Random rnd = new Random();
	
	@Override
	public void saveBill(Bolle bolla) {
		
		BolleDto bill = new BolleDto(bolla);
		billDao.saveBill(bill);
	}

	@Override
	public ArrayList<Bolle> getAllBills() {
		
		ArrayList<Bolle> billList = new ArrayList<Bolle>(); 
		ArrayList<BolleDto> dataBillList = billDao.getAllBills();
		for(BolleDto listObject : dataBillList)
		{
			Bolle bill = new Bolle();
			bill.setIdBolla(listObject.getIdBolla());
			bill.setIdContenuto1(listObject.getIdContenuto1());
			bill.setIdContenuto2(listObject.getIdContenuto2());
			bill.setMagazzino1(listObject.getMagazzino1());
			bill.setMagazzino2(listObject.getMagazzino2());
			
			Prodotti product = new Prodotti();
			product.setIdProdotto(listObject.getProdotto1().getIdProdotto());
			product.setMarcaProdotto(listObject.getProdotto1().getMarcaProdotto());
			product.setModelloProdotto(listObject.getProdotto1().getModelloProdotto());
			product.setTipoProdotto(listObject.getProdotto1().getTipoProdotto());
			bill.setProdotto1(product);
			
			product = new Prodotti();
			product.setIdProdotto(listObject.getProdotto2().getIdProdotto());
			product.setMarcaProdotto(listObject.getProdotto2().getMarcaProdotto());
			product.setModelloProdotto(listObject.getProdotto2().getModelloProdotto());
			product.setTipoProdotto(listObject.getProdotto2().getTipoProdotto());
			bill.setProdotto2(product);
			
			bill.setStato(listObject.getStato());
			bill.setPosition(listObject.getPosition());
			
			billList.add(bill);
		}
		return billList;
	}

	@Override
	public void orderProducts(int numOrdini) {
			
		ArrayList<Prodotti> productList = productService.getAllProducts();
		//Controllo del numero di ordini: ogni 10 vengono inseriti nuovi prodotti all'interno di warehouseA e warehouseB
		if((numOrdini + 1) % 10 == 0)
		{
			//Read da database dei contenuti sia di warehouseA che warehouseB e di tutti i prodotti disponibili
			
			ArrayList<Contenuti> warehouseA = contentService.getWarehouseAvailableContent("warehouseA");	
			ArrayList<Contenuti> warehouseB = contentService.getWarehouseAvailableContent("warehouseB");
			
			int wA = 0;
			int wB = 0;
			
			while(warehouseA.size() < 100 && wA < 5)
			 {
				 rnd = new Random();
				 Contenuti tmp = new Contenuti();
				 
				 tmp.setIdProdotto(productList.get(rnd.nextInt(productList.size())).getIdProdotto());	
				 tmp.setWarehouse("warehouseA");
				 tmp.setStato(true);
				 warehouseA.add(tmp);
				 contentService.saveContent(tmp);
				 wA++;
			 }
			while(warehouseB.size() < 50 && wB < 10)
			 {
				 rnd = new Random();
				 Contenuti tmp = new Contenuti();
				 
				 tmp.setIdProdotto(productList.get(rnd.nextInt(productList.size())).getIdProdotto());	
				 tmp.setWarehouse("warehouseB");
				 tmp.setStato(true);
				 warehouseB.add(tmp);
				 contentService.saveContent(tmp);
				 wB++;
			 }
		}
		
		Prodotti p = new Prodotti();
		Bolle bill = new Bolle();
		boolean find1 = false;
		boolean find2 = false;
		
		//Scelta randomica dei prodotti disponibili da ordinare
		rnd = new Random();
		p.setIdProdotto(productList.get(rnd.nextInt(productList.size())).getIdProdotto());
		
		Contenuti tmp = contentService.getContentByIdProdotto(p.getIdProdotto());
		bill.setIdContenuto1(tmp.getIdContenuto());
		if(tmp.getStato())
		{
			contentService.changeState(bill.getIdContenuto1());
			find1 = true;
		}
		//Scelta randomica dei prodotti disponibili da ordinare
		rnd = new Random();
		p.setIdProdotto(productList.get(rnd.nextInt(productList.size())).getIdProdotto());
		tmp = contentService.getContentByIdProdotto(p.getIdProdotto());
		bill.setIdContenuto2(tmp.getIdContenuto());
		if(tmp.getStato())
		{
			contentService.changeState(bill.getIdContenuto2());
			find2 = true;
		}
		
		/**Creazione dell'id delle bolle che deve essere a 8 cifre, se un id � gi� presente all'interno della
		 * table bolle nel DATABASE parte l'eccezione che, grazie al ciclo do-while ricrea l'id della Bolla*/
		boolean idSet = false;
		do{
			try{
				
				bill.setIdBolla(rnd.nextInt(99999999));
				idSet = true;
				/**Se tutti e due i prodotti sono stati trovati vengono salvati gli id corrispondenti ai prodotti nei magazzini
				 * altrimenti a seconda dei prodotti non disponibili l'id viene salvato come NULL*/
				if((find1 == true) && (find2 == true))
				{	
					bill.setStato(true);
				}	
				else
				{
					bill.setStato(false);
				}
				
				saveBill(bill);
				
			}catch(DataIntegrityViolationException ex){
				
				idSet = false;
			}
			
		}while(!idSet);	
	}

	@Override
	public int countOrdersByState(boolean stato) {
		
		return billDao.countOrdersByState(stato);
	}

	@Override
	public int countOrder() {
		
		return billDao.countOrder();
	}

}
