package main.java.pojo;

import java.io.Serializable;

public class TipoProdotti implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tipoProdotto;
			
	public TipoProdotti() {}
	
	public String getTipoProdotto()
	{
		return tipoProdotto;
	}
	
	public void setTipoProdotto(String tipoProdotto)
	{
		this.tipoProdotto = tipoProdotto;
	}
}
