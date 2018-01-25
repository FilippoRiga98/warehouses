package main.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import main.java.dao.ContenutiDao;
import main.java.dto.ContenutiDto;

public class ContenutiDaoImpl implements ContenutiDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveContent(ContenutiDto contenuto)
	{
			String sql = "INSERT INTO contenuti VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{contenuto.getIdContenuto(), contenuto.getIdProdotto(), contenuto.getWarehouse(), contenuto.getStato()});	
	}

	@Override
	public ArrayList<ContenutiDto> getWarehouseAvailableContent(String nameWarehouse) {
		
		return (ArrayList<ContenutiDto>) jdbcTemplate.query("SELECT * FROM contenuti INNER JOIN warehouses ON "
				+ "warehouses.nomeWarehouse = contenuti.nomeWarehouse "
				+ "WHERE contenuti.nomeWarehouse = '" + nameWarehouse + "' "
						+ "AND stato = true",new RowMapper<ContenutiDto>(){  
	        public ContenutiDto mapRow(ResultSet rs, int row) throws SQLException {  
	            ContenutiDto content = new ContenutiDto();  
	            content.setIdContenuto(rs.getInt("idContenuto"));
	            content.setIdProdotto(rs.getInt("idProdotto"));
	            content.setWarehouse(rs.getString("nomeWarehouse"));
	            content.setStato(rs.getBoolean("stato"));
	            return content;  
	        }  
	    });  
	}

	@Override
	public ContenutiDto getContentByIdProdotto(int idProdotto) {
		
			String sql = "SELECT idContenuto, stato FROM contenuti WHERE idProdotto = ? "
					+ "ORDER BY stato DESC, nomeWarehouse ASC, idContenuto ASC LIMIT 1";
			return jdbcTemplate.queryForObject(sql, new Object[]{idProdotto},new BeanPropertyRowMapper<ContenutiDto>(ContenutiDto.class));  
	}

	@Override
	public void changeState(long idContenuto) {
		
		String sql = "UPDATE contenuti SET stato = 0 WHERE idContenuto=" + idContenuto;
		jdbcTemplate.update(sql);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
      this.jdbcTemplate = jdbcTemplate;
	}

}
