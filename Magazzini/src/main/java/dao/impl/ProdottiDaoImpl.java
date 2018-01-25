package main.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.dao.ParameterizedRowMapper;
import main.java.dao.ProdottiDao;
import main.java.dto.ProdottiDto;
import main.java.dto.TipoProdottiDto;


public class ProdottiDaoImpl implements ProdottiDao{


	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ArrayList<TipoProdottiDto> getAllTypes() {
		
		return (ArrayList<TipoProdottiDto>) jdbcTemplate.query("SELECT * FROM tipo_prodotti",
				new RowMapper<TipoProdottiDto>(){  
	        public TipoProdottiDto mapRow(ResultSet rs, int row) throws SQLException {  
	            TipoProdottiDto type = new TipoProdottiDto();  
	            type.setTipoProdotto(rs.getString("tipoProdotto"));
	            return type;  
	        }  
	    });  
	}

	@Override
	public void saveProduct(ProdottiDto prodotto) {
		
		String sql = "INSERT INTO prodotti VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{prodotto.getIdProdotto(), prodotto.getMarcaProdotto(), prodotto.getModelloProdotto(), prodotto.getTipoProdotto()});
	}

	@Override
	public ArrayList<ProdottiDto> getAllProducts() {
		
		return (ArrayList<ProdottiDto>) jdbcTemplate.query("SELECT * FROM prodotti "
				+ "ORDER BY tipoProdotto, marcaProdotto, modelloProdotto"
				,new RowMapper<ProdottiDto>(){  
	        public ProdottiDto mapRow(ResultSet rs, int row) throws SQLException {  
	            ProdottiDto product = new ProdottiDto();  
	            product.setIdProdotto(rs.getInt("idProdotto"));
	            product.setMarcaProdotto(rs.getString("marcaProdotto"));
	            product.setModelloProdotto(rs.getString("modelloProdotto"));
	            product.setTipoProdotto(rs.getString("tipoProdotto"));
	            return product;  
	        }  
	    });  
	}
	
	@Override
	public ArrayList<ProdottiDto> getAllProductsByType(String type){
		
		return (ArrayList<ProdottiDto>) jdbcTemplate.query("SELECT * FROM prodotti INNER JOIN tipo_prodotti "
				+ "ON prodotti.tipoProdotto = tipo_prodotti.tipoProdotto "
				+ "WHERE prodotti.tipoProdotto = '" + type + "'",new RowMapper<ProdottiDto>(){  
	        public ProdottiDto mapRow(ResultSet rs, int row) throws SQLException {  
	            ProdottiDto product = new ProdottiDto();  
	            product.setIdProdotto(rs.getInt("idProdotto"));
	            product.setMarcaProdotto(rs.getString("marcaProdotto"));
	            product.setModelloProdotto(rs.getString("modelloProdotto"));
	            product.setTipoProdotto(rs.getString("tipoProdotto"));
	            return product;  
	        }  
	    });  
	}
	
	 public static class ProdottoMapper implements ParameterizedRowMapper<ProdottiDto> {
	        @Override
	        public ProdottiDto mapRow(ResultSet rs, int row, String num) throws SQLException {
	            ProdottiDto product = new ProdottiDto();
	            product.setIdProdotto(rs.getInt("idProdotto" + num));
	            product.setMarcaProdotto(rs.getString("marcaProdotto" + num));
	            product.setModelloProdotto(rs.getString("modelloProdotto" + num));
	            product.setTipoProdotto(rs.getString("tipoProdotto" + num));
	            return product;
	        }
	    }
	 
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
	      this.jdbcTemplate = jdbcTemplate;
	}

}
