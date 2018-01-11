package main.java.dto;

import java.io.Serializable;

public class TipoProdottiDto implements Serializable{

	private String tipoProdotto;
			
	public TipoProdottiDto(){}
	
	public String getTipoProdotto()
	{
		return tipoProdotto;
	}
	
	public void setTipoProdotto(String tipoProdotto)
	{
		this.tipoProdotto = tipoProdotto;
	}
}
