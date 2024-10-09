package JpaST2.dao.imp;

import java.util.List;

import JpaST2.configs.JPAConfig;
import JpaST2.entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class VideoDao implements IVideoDao {
	@Override
	public void insert(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();
			enma.persist(video);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}

	@Override
	public void update(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();
			enma.merge(video);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

		} finally {

			enma.close();

		}
	}

	@Override
	public void delete(int videoid) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			Video video = enma.find(Video.class, videoid);
			if (video != null) {
				enma.remove(video);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} 
		
		finally {
			enma.close();
		}
	}

	@Override
	public Video findByID(int videoid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Video video = enma.find(Video.class, videoid);
		return video;
	}

	@Override
	public List<Video> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
		return query.getResultList();
	}

	@Override
	public List<Video> findByvideoTitle(String videotitle) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT v FROM Video v WHERE v.videotitle like :videotitle";
		TypedQuery<Video> query = enma.createQuery(jpql, Video.class);
		query.setParameter("catename", "%" + videotitle + "%");
		return query.getResultList();
	}
	
	@Override
	public int count() {
		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT count(v) FROM Video v";
		 Query query = enma.createQuery(jpql);
		 return ((Long)query.getSingleResult()).intValue();
	}

}
