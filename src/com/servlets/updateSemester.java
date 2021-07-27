package com.servlets;

import java.io.File;
import java.io.IOException;
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

import com.dao.StudentDAO;

@WebServlet("/updateSemester")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class updateSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "G:\\FileUploadDemo";
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int added=0;
		if(ServletFileUpload.isMultipartContent(request)){
			
            try {
          
            	
        		 Part filePart = request.getPart("file_upload");
        		 String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            	String fname = null;
               String fsize = null;
               String ftype = null;
               // List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
               
               for( Part filepart : request.getParts())
               {
            	   fsize = new Long(filepart.getSize()).toString();
            	   ftype = filepart.getContentType();
            	   filepart.write((UPLOAD_DIRECTORY + File.separator + fileName));
               }
               System.out.println(UPLOAD_DIRECTORY + File.separator + fileName);
              
                 StudentDAO dao=new StudentDAO();
                added=dao.updateStudent( UPLOAD_DIRECTORY + File.separator + fileName);
        		
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
        	 response.sendRedirect("registerSemester.jsp");
	}

}
