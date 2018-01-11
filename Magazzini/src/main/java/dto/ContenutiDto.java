package main.java.dto;

import main.java.pojo.Contenuti;

public class ContenutiDto {

	private long idContenuto;
	private int idProdotto;
	private String warehouse;
	private boolean stato;
	
	public ContenutiDto(){}
	
	public ContenutiDto(Contenuti content)
	{
		this.idContenuto = content.getIdContenuto();
		this.idProdotto = content.getIdProdotto();
		this.warehouse = content.getWarehouse();
		this.stato = content.getStato();
	}
	
	public void setIdContenuto(long idContenuto)
	{
		this.idContenuto = idContenuto;
	}
	public long getIdContenuto()
	{
		return idContenuto;
	}
	
	
	public void setIdProdotto(int idProdotto)
	{
		this.idProdotto = idProdotto;
	}
	public int getIdProdotto()
	{
		return idProdotto;
	}
	
	public void setWarehouse(String warehouse)
	{
		this.warehouse = warehouse;
	}
	public String getWarehouse()
	{
		return warehouse;
	}
	
	public void setStato(boolean stato)
	{
		this.stato = stato;
	}
	public boolean getStato()
	{
		return stato;
	}
}
