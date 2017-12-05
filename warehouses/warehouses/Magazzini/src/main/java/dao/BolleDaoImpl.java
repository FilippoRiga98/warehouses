package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.dao.ProdottiDaoImpl.ProdottoMapper;
import main.java.dto.BolleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BolleDaoImpl implements BolleDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void saveBill(BolleDto bill) {
		
		String sql;
		sql = "INSERT INTO bolle VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{bill.getIdBolla(), bill.getStato(), bill.getIdContenuto1(), bill.getIdContenuto2(), bill.getPosition()});
		
	}

	@Override
	public ArrayList<BolleDto> getAllBills() {
		
		return (ArrayList<BolleDto>) jdbcTemplate.query("SELECT b.idBolla, b.stato, "
				+ "p1.idProdotto AS idProdotto1, p1.marcaProdotto AS marcaProdotto1, "
				+ "p1.modelloProdotto AS modelloProdotto1, p1.tipoProdotto AS tipoProdotto1, "
				+ "c1.nomeWarehouse AS Magazzino1, "
				+ "p2.idProdotto AS idProdotto2, p2.marcaProdotto AS marcaProdotto2, "
				+ "p2.modelloProdotto AS modelloProdotto2, p2.tipoProdotto AS tipoProdotto2, "
				+ "c2.nomeWarehouse AS Magazzino2 "
				+ "FROM bolle AS b "
				+ "LEFT JOIN contenuti AS c1 ON b.idContenuto1 = c1.idContenuto "
				+ "LEFT JOIN contenuti AS c2 ON b.idContenuto2 = c2.idContenuto "
				+ "LEFT JOIN prodotti AS p1 ON c1.idProdotto = p1.idProdotto "
				+ "LEFT JOIN prodotti AS p2 ON c2.idProdotto = p2.idProdotto "
				+ "ORDER BY b.position",new RowMapper<BolleDto>(){  
	        public BolleDto mapRow(ResultSet rs, int row) throws SQLException {  
	            BolleDto bill = new BolleDto();  
	            bill.setIdBolla(rs.getInt("idBolla"));
	            bill.setStato(rs.getBoolean("stato"));
	            bill.setProdotto1(new ProdottoMapper().mapRow(rs, row, "1"));
	            bill.setMagazzino1(rs.getString("Magazzino1"));
	            bill.setProdotto2(new ProdottoMapper().mapRow(rs, row, "2"));
	            bill.setMagazzino2(rs.getString("Magazzino2"));
	            return bill;  
	        }  
		});
	}

	@Override
	public int countOrdersByState(boolean stato) {
		
		String sql = "SELECT DISTINCT COUNT(idBolla) FROM bolle "
				+ "WHERE stato = ?";
		return (int) jdbcTemplate.queryForObject(sql,new Object[]{stato}, int.class);
	}

	@Override
	public int countOrder() {
		
		String sql = "SELECT DISTINCT COUNT(idBolla) FROM bolle";
		return (int) jdbcTemplate.queryForObject(sql, int.class);
	}
}
