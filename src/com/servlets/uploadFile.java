package com.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ResultImplDAO;

/**
 * Servlet implementation class uploadFile
 */
@WebServlet("/uploadFile")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private final String UPLOAD_DIRECTORY = "G:\\FileUploadDemo";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multifiles= sf.parseRequest(request);
			for(FileItem item:multifiles)
			{
				item.write(new File("G:\\FileUploadDemo\\" +item.getName()));
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Part filePart = request.getPart("file_upload");
	    String fileName = filePart.getSubmittedFileName();
	    System.out.println(fileName);
	    for (Part part : request.getParts()) {
	      part.write("G:\\FileUploadDemo\\" + fileName);
	    }
	    response.getWriter().print("The file uploaded sucessfully.");
	  }*/
		
		//
		 if(ServletFileUpload.isMultipartContent(request)){
	            try {
	            	String semester=request.getParameter("semester");
	        		String exam_type=request.getParameter("exam_type");
	        		String course_id=request.getParameter("course_id");
	            	String fname = null;
		               String fsize = null;
		               String ftype = null;
	                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	                //List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).request.getParameter("file_upload");
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                        fname = new File(item.getName()).getName();
	                        fsize = new Long(item.getSize()).toString();
	                        ftype = item.getContentType();
	                        System.out.println(fname);
	   
	                        item.write( new File(UPLOAD_DIRECTORY + File.separator + fname));
	                       
	    	        		System.out.println(UPLOAD_DIRECTORY + File.separator + fname);
	                    }
	                }
	                
	                ResultImplDAO result=new ResultImplDAO();
	               result.updateResult(semester, exam_type, course_id, UPLOAD_DIRECTORY + File.separator + fname);
	                request.setAttribute("message", "File Uploaded Successfully");
	                request.setAttribute("name", fname);
	                request.setAttribute("size", fsize);
	                request.setAttribute("type", ftype);
	               
	            } catch (Exception ex) {
	                request.setAttribute("message", "File Upload Failed due to " + ex);
	             }          
	          
	         }else{
	             request.setAttribute("message","Sorry this Servlet only handles file upload request");
	         }
		 
		 //ResultImplDAO result=new ResultImplDAO();
 		//int added=result.updateResult(semester,exam_type,course_id,"G:\\FileUploadDemo\\"+fname);
 		
 			request.getRequestDispatcher("/result.jsp").forward(request, response);
		 
 		
	}
}


