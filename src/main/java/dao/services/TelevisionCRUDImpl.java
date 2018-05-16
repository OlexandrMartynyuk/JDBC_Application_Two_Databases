
package dao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.interfaces.TelevisionCRUD;
import dao.models.Customer;
import dao.models.Television;

public class TelevisionCRUDImpl implements TelevisionCRUD {

	@Autowired
	@Qualifier("TelevisionTemplate")
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY_INSERT = "INSERT INTO Television VALUES (null,?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE Television SET vendor = ?, size = ?, resolution = ?, smarttv = ? WHERE id = ?";
	private static final String QUERY_SELECT_ALL = "SELECT * FROM Television";
	private static final String QUERY_SELECT_BY_ID = "SELECT * FROM Television WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM Television WHERE id = ?";

	@Override
	public void add(Television television) {
		jdbcTemplate.update(QUERY_INSERT, television.getVendor(),television.getSize(),television.getResolution(),television.getSmartTv());
	}

	@Override
	public void remove(long id) {
		jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
	}

	@Override
	public void update(Television television) {
		jdbcTemplate.update(QUERY_UPDATE, television.getVendor(), television.getSize(), television.getResolution(), television.getSmartTv(), television.getId());
	}

	@Override
	public List<Television> getAll() {
		List<Television> televisions = jdbcTemplate.query(QUERY_SELECT_ALL, new TelevisionMapper());
		return televisions;
	}

	@Override
	public Television getById(long id) {
		Television television = (Television) jdbcTemplate.queryForObject(QUERY_SELECT_BY_ID, new Object[] { id },
				new TelevisionMapper());
		return television;
	}

	
}
