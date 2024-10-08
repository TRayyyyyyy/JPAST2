package JpaST2.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import JpaST2.entity.Category;
import JpaST2.entity.Video;
import JpaST2.service.CategoryService;
import JpaST2.service.ICategoryService;
import JpaST2.service.IVideoService;
import JpaST2.service.VideoService;
import JpaST2.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert", "/admin/video/edit", "/admin/video/update", "/admin/video/delete", "/admin/video/search"})

public class VideoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IVideoService videoService = new VideoService(); 
	ICategoryService categoryService = new CategoryService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (url.contains("videos")) {
			List<Video> lst = videoService.findAll();
			req.setAttribute("listvideo", lst);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		}

		else if (url.contains("add")) {
			List<Category> categories = categoryService.findAll();
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
		}
		
		else if(url.contains("edit")) {
			List<Category> categories = categoryService.findAll();
			req.setAttribute("categories", categories);
            int id = Integer.parseInt(req.getParameter("id"));
            Video videoModel = videoService.findByID(id);
            req.setAttribute("video", videoModel);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp); 
        }
		
		else if(url.contains("delete")) {
			String id = req.getParameter("id");
			videoService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
			
		}
			
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        if (url.contains("update")) {
        	String id = req.getParameter("VideoId");
	        String status = req.getParameter("Active");
	        String desp = req.getParameter("Description");
	        String title = req.getParameter("Title");
	       
	        int statuss = Integer.parseInt(status);
	        
	        Video video = new Video();
	        video.setVideoid(id);
	        video.setDescription(desp);
	        video.setTitle(title);
	        video.setViews(0);
	        video.setActive(statuss);
	        
	        int categoryid = Integer.parseInt(req.getParameter("categoryid")); 
    
	        Category category = categoryService.findByID(categoryid);       
	        video.setCategory(category);
	        
	        // luu hinh cu
	        
	        Video videold = videoService.findByID(Integer.parseInt(id));
	       
	        String fileold = videold.getPoster();
	        
	        // xu ly image
	        String fname = "";
	        String uploadPath = Constant.UPLOAD_DIRECTORY;
	        File uploadDir = new File(uploadPath);
	        if(!uploadDir.exists()) {
	        	uploadDir.mkdir();
	        }
	        
	        try {
	        	Part part = req.getPart("Poster");
	        	if(part.getSize()>0) {
	        		String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	        		// đổi tên file
	        		int index = filename.lastIndexOf(".");
	        		String ext =  filename.substring(index+1);
	        		fname = System.currentTimeMillis() + "." + ext;
	        		// upload file
	        		part.write(uploadPath + "/" + fname);
	        		//ghi ten vao data
	        		video.setPoster(fname);
	        	}
	        	else {
	        		video.setPoster(fileold);
	        	}
	        	
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        
	        videoService.update(video);
	        resp.sendRedirect(req.getContextPath() + "/admin/videos");
	    }
        
        else if(url.contains("insert")) {
	        String id = req.getParameter("VideoId");
	        String status = req.getParameter("Active");
	        String desp = req.getParameter("Description");
	        String title = req.getParameter("Title");
	       
	        int statuss = Integer.parseInt(status);
	        
	        Video video = new Video();
	        video.setVideoid(id);
	        video.setDescription(desp);
	        video.setTitle(title);
	        video.setViews(0);
	        video.setActive(statuss);
	        
	        int categoryId = Integer.parseInt(req.getParameter("categoryid")); 
    
	        Category category = categoryService.findByID(categoryId);       
	        video.setCategory(category);
	  
	        String fname = "";
	        String uploadPath = Constant.UPLOAD_DIRECTORY;
	        File uploadDir = new File(uploadPath);
	        if(!uploadDir.exists()) {
	        	uploadDir.mkdir();
	        }
	        
	        try {
	        	Part part = req.getPart("Poster");
	        	if(part.getSize()>0) {
	        		String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	        		// đổi tên file
	        		int index = filename.lastIndexOf(".");
	        		String ext =  filename.substring(index+1);
	        		fname = System.currentTimeMillis() + "." + ext;
	        		// upload file
	        		part.write(uploadPath + "/" + fname);
	        		//ghi ten vao data
	        		video.setPoster(fname);
	        	}
	        	else {
	        		video.setPoster("avartar.png");
	        	}
	        	
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        
	        videoService.insert(video);
	        resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
	}
}
