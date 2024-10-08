package JpaST2.service;

import java.util.List;

import JpaST2.dao.imp.CategoryDao;
import JpaST2.dao.imp.ICategoryDao;
import JpaST2.entity.Category;

public class CategoryService implements ICategoryService{
	
	ICategoryDao catDao = new CategoryDao();
	
	@Override
	public int count() {
		return catDao.count();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		return catDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		List<Category> lst = catDao.findAll();
		for (Category category : lst) {
			System.out.println(category.getImages());
		}
		return catDao.findAll();
	}

	@Override
	public Category findByID(int cateid) {
		// TODO Auto-generated method stub
		return catDao.findByID(cateid);
	}

	@Override
	public void delete(int cateid) {
		catDao.delete(cateid);
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		catDao.update(category);
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		catDao.insert(category);
	}
	

}
