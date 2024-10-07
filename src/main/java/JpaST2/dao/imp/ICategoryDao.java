package JpaST2.dao.imp;

import java.util.List;

import JpaST2.entity.Category;

public interface ICategoryDao {

	int count();

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findByID(int cateid);

	void update(Category category);

	void insert(Category category);

	void delete(int cateid);


}
