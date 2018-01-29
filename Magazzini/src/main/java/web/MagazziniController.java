package main.java.web;

import java.text.DecimalFormat;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.pojo.User;
import main.java.service.BolleService;
import main.java.service.ContenutiService;
import main.java.service.MagazziniService;
import main.java.service.ProdottiService;

@Controller
public class MagazziniController {

	@Resource(name = "magazziniServiceImpl")
	private MagazziniService service;
	@Resource(name = "prodottiServiceImpl")
	private ProdottiService productService;
	@Resource(name = "contenutiServiceImpl")
	private ContenutiService contentService;
	@Resource(name = "bolleServiceImpl")
	private BolleService billService;
	
	
	Random rnd = new Random();
	
	@RequestMapping("/")
	public String homePage()
	{
		//Si cancella il contenuto dei magazzini e delle bolle
		service.truncateTable("bolle");
		service.deleteTable("contenuti");
		contentService.initializeWarehouses();
		return "redirect:/login";
	}	
	
	@RequestMapping("/login")
	public ModelAndView showLoginForm() 
	{
		ModelAndView mav = new ModelAndView("login");
		User user = new User();
		mav.addObject("user", user);
		return mav;
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
		boolean stop = contentService.areEmpty(); //Controlla se � possibile evadere ordini
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
