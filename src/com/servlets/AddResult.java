package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ResultImplDAO;

/**
 * Servlet implementation class AddResult
 */
@WebServlet("/AddResult")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "G:\\FileUploadDemo";
   
    public AddResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int added=0;
		if(ServletFileUpload.isMultipartContent(request)){
			
            try {
            	String semester=request.getParameter("semester");
        		String exam_type=request.getParameter("exam_type");
        		String course_id=request.getParameter("course_id");
        		 Part filePart = request.getPart("file_upload");
        		 String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        		 //InputStream fileContent = filePart.getInputStream();
        		//String file_path="";
        		System.out.println("in if block");
            	String fname = null;
               String fsize = null;
               String ftype = null;
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
               /* for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        fname = new File(item.getName()).getName();
                        fsize = new Long(item.getSize()).toString();
                        ftype = item.getContentType();
   
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + fname));
                       
    	        		System.out.println(UPLOAD_DIRECTORY + File.separator + fname);
                    }
                }*/
               for( Part filepart : request.getParts())
               {
            	   fsize = new Long(filepart.getSize()).toString();
            	   ftype = filepart.getContentType();
            	   filepart.write((UPLOAD_DIRECTORY + File.separator + fileName));
               }
               System.out.println(UPLOAD_DIRECTORY + File.separator + fileName);
              
                ResultImplDAO result=new ResultImplDAO();
                added=result.updateResult(semester, exam_type, course_id, UPLOAD_DIRECTORY + File.separator + fileName);
        		
               request.setAttribute("message", "File Uploaded Successfully");
                request.setAttribute("name", fileName);
                request.setAttribute("size", fsize);
                request.setAttribute("type", ftype);
               
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
             }          
          
         }else{
             request.setAttribute("message","Sorry this Servlet only handles file upload request");
         }
                
               
         if(added>0)
        	 request.getRequestDispatcher("/result.jsp").forward(request, response);
         else
        	 response.sendRedirect("addResult.jsp");
		
               
		   
		
	
		
	}

}
