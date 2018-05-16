package dao.interfaces;

import java.util.List;

import dao.models.Television;

public interface TelevisionCRUD {

	void add(Television television);
	void remove(long id);
	void update(Television television);
	List<Television> getAll();
	Television getById(long id);
}
