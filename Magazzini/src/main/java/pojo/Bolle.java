package main.java.pojo;

public class Bolle {

	private int idBolla;
	private boolean stato;
	private long idContenuto1;
	private long idContenuto2;
	private int position;
	//Business logic
	private Prodotti prodotto1;
	private Prodotti prodotto2;
	private String magazzino1;
	private String magazzino2;
	
	public void setIdBolla(int idBolla)
	{
		this.idBolla = idBolla;
	}
	public int getIdBolla()
	{
		return idBolla;
	}
	
	public void setIdContenuto1(long idContenuto1)
	{
		this.idContenuto1 = idContenuto1;
	}
	public long getIdContenuto1()
	{
		return idContenuto1;
	}
	
	public void setIdContenuto2(long idContenuto2)
	{
		this.idContenuto2 = idContenuto2;
	}
	public long getIdContenuto2()
	{
		return idContenuto2;
	}
	
	public void setStato(boolean stato)
	{
		this.stato = stato;
	}
	public boolean getStato()
	{
		return stato;
	}
	
	//Business logic
	public void setProdotto1(Prodotti prodotto1)
	{
		this.prodotto1 = prodotto1;
	}
	public Prodotti getProdotto1()
	{
		return prodotto1;
	}
	
	public void setProdotto2(Prodotti prodotto2)
	{
		this.prodotto2 = prodotto2;
	}
	public Prodotti getProdotto2()
	{
		return prodotto2;
	}
	
	public void setMagazzino1(String magazzino1)
	{
		this.magazzino1 = magazzino1;
	}
	public String getMagazzino1()
	{
		return magazzino1;
	}
	
	public void setMagazzino2(String magazzino2)
	{
		this.magazzino2 = magazzino2;
	}
	public String getMagazzino2()
	{
		return magazzino2;
	}
	
	public int getPosition()
	{
		return position;
	}
	public void setPosition(int position)
	{
		this.position = position;
	}
}
