package dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.models.Television;


public class TelevisionMapper implements RowMapper  {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Television television = new Television();
		television.setId(rs.getLong("id"));
		television.setVendor(rs.getString("vendor"));
		television.setSize(rs.getInt("size"));
		television.setResolution(rs.getString("resolution"));
		television.setSmartTv(rs.getBoolean("smarttv"));
		return television;
	}
}
