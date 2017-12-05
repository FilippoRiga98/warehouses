package main.java.dto;

import main.java.pojo.Prodotti;

public class ProdottiDto {

	private int idProdotto;
	private String marcaProdotto;
	private String modelloProdotto;
	private String tipoProdotto;
	
	public ProdottiDto(){}
	
	public ProdottiDto(Prodotti product)
	{
		this.idProdotto = product.getIdProdotto();
		this.marcaProdotto = product.getMarcaProdotto();
		this.modelloProdotto = product.getModelloProdotto();
		this.tipoProdotto = product.getTipoProdotto();
	}
	
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
