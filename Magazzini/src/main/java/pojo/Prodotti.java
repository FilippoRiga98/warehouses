package main.java.pojo;

import java.io.Serializable;

public class Prodotti implements Serializable {

	
	private int idProdotto;
	private String marcaProdotto;
	private String modelloProdotto;
	private String tipoProdotto;
	
	public Prodotti() {}
	
	public void setIdProdotto(int idProdotto)
	{
		this.idProdotto = idProdotto;
	}
	public int getIdProdotto()
	{
		return idProdotto;
	}
	
	public void setMarcaProdotto(String marcaProdotto)
	{
		this.marcaProdotto = marcaProdotto;
	}
	public String getMarcaProdotto()
	{
		return marcaProdotto;
	}
	
	public void setModelloProdotto(String modelloProdotto)
	{
		this.modelloProdotto = modelloProdotto;
	}
	public String getModelloProdotto()
	{
		return modelloProdotto;
	}
	
	public void setTipoProdotto(String tipoProdotto)
	{
		this.tipoProdotto = tipoProdotto;
	}
	public String getTipoProdotto()
	{
		return tipoProdotto;
	}
}
