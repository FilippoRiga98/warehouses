package main.java.web;

import java.text.DecimalFormat;
import java.util.Random;

import main.java.pojo.Prodotti;
import main.java.service.BolleService;
import main.java.service.ContenutiService;
import main.java.service.MagazziniService;
import main.java.service.ProdottiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MagazziniController {

	@Autowired
	private MagazziniService service;
	@Autowired
	private ProdottiService productService;
	@Autowired
	private ContenutiService contentService;
	@Autowired
	private BolleService billService;
	
	
	Random rnd = new Random();
	
	@RequestMapping("/")
	public String homePage()
	{
		//Si cancella il contenuto dei magazzini e delle bolle
		service.truncateTable("bolle");
		service.deleteTable("contenuti");
		contentService.initializeWarehouses();
		return "redirect:/home";
	}	
	
	@RequestMapping("/home")
    public ModelAndView showHome()
    {
		ModelAndView mav = new ModelAndView("home");
		//Read da DATABASE di tutti i prodotti che verranno stampati a schermo grazie ad home.jsp
        mav.addObject("productList", productService.getAllProducts());
        boolean stop = contentService.areEmpty();
        mav.addObject("stop", stop);
        return mav;
    }
	
	/*@RequestMapping("/addproduct")
	public ModelAndView showProductForm()
	{
		ModelAndView mav = new ModelAndView("addproduct");
		//Read da DATABASE dei tipi di prodotti che popoleranno il select in addproduct.jsp
		mav.addObject("typeList", productService.getAllTypes());
		Prodotti prodotto = new Prodotti();
		mav.addObject("product", prodotto);
		return mav;
	}*/
	
	/*@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Prodotti prodotto)
	{
		//Save su DATABASE del prodotto inserito
		productService.saveProduct(prodotto);
		return "redirect:/home";
	}*/
	
	@RequestMapping("/order")
	public String orderProducts()
	{ 
		billService.orderProducts(billService.countOrder());
		return "redirect:/viewbill";
	}
	
	@RequestMapping("/viewbill")
	public ModelAndView showBills()
	{
		ModelAndView mav = new ModelAndView("viewbill");
		boolean stop = contentService.areEmpty(); //Controlla se è possibile evadere ordini
		DecimalFormat df = new DecimalFormat("#.#");
		double numOrdiniConSuccesso = billService.countOrdersByState(true);
		double numOrdiniSenzaSuccesso = billService.countOrdersByState(false);
		int numOrdini = billService.countOrder();
		
		mav.addObject("stop", stop);
		mav.addObject("billList", billService.getAllBills()); //Aggiunge al model tutte le bolle stampate
		mav.addObject("numOrdini", numOrdini);
		mav.addObject("numOrdiniConSuccesso", df.format(((numOrdiniConSuccesso / numOrdini) * 100)));
		mav.addObject("numOrdiniSenzaSuccesso", df.format(((numOrdiniSenzaSuccesso / numOrdini) * 100)));
		return mav;
	}		
	
}
