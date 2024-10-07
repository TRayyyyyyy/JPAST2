package JpaST2.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static final String IMAGES = "images";
	public static final String QUERY_CATEGORY_FIND_ALL = "Category.findAll";
	public static final String CATEGORYNAME = "categoryname";
	public static final String VIDEOS = "videos";
	public static final String CATEGORYID = "categoryid";
	public static final String STATUS = "status";

	
	/**
	 * @see JpaST2.entity.Category#images
	 **/
	public static volatile SingularAttribute<Category, String> images;
	
	/**
	 * @see JpaST2.entity.Category#categoryname
	 **/
	public static volatile SingularAttribute<Category, String> categoryname;
	
	/**
	 * @see JpaST2.entity.Category#videos
	 **/
	public static volatile ListAttribute<Category, Video> videos;
	
	/**
	 * @see JpaST2.entity.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see JpaST2.entity.Category#categoryid
	 **/
	public static volatile SingularAttribute<Category, Integer> categoryid;
	
	/**
	 * @see JpaST2.entity.Category#status
	 **/
	public static volatile SingularAttribute<Category, Integer> status;

}

