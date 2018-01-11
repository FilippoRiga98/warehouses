package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.dto.ProdottiDto;

public interface ParameterizedRowMapper<T> {

	public ProdottiDto mapRow(ResultSet rs, int row, String num) throws SQLException;
}
