package JpaST2.service;

import java.util.List;

import JpaST2.dao.imp.IVideoDao;
import JpaST2.dao.imp.VideoDao;
import JpaST2.entity.Video;

public class VideoService implements IVideoService{

	IVideoDao viService = new VideoDao();
	@Override
	public int count() {
		
		return viService.count();
	}

	@Override
	public List<Video> findByvideoTitle(String videotitle) {
		
		return viService.findByvideoTitle(videotitle);
	}

	@Override
	public List<Video> findAll() {
		
		return viService.findAll();
	}

	@Override
	public Video findByID(int videoid) {
		
		return viService.findByID(videoid);
	}

	@Override
	public void delete(int videoid) {
		viService.delete(videoid);
		
	}

	@Override
	public void update(Video video) {
		viService.update(video);
		
	}

	@Override
	public void insert(Video video) {
		viService.insert(video);
		
	}

}
