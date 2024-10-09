package JpaST2.dao.imp;

import java.util.List;

import JpaST2.entity.Video;

public interface IVideoDao {

	int count();

	List<Video> findByvideoTitle(String videotitle);

	List<Video> findAll();

	Video findByID(int videoid);

	void delete(int videoid);

	void update(Video video);

	void insert(Video video);

}
