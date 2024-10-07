package JpaST2.service;

import java.util.List;

import JpaST2.entity.Category;

public interface ICategoryService {
	int count();

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findByID(int cateid);

	void delete(int cateid);

	void update(Category category);

	void insert(Category category);
}
