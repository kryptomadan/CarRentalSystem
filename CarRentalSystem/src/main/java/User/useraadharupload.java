package User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.model;


@WebServlet("/useraadharupload")
public class useraadharupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String aadharnumber;
    public String path;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		model obj = new model();
		try 
		{
			ServletFileUpload sp = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multi = sp.parseRequest(req);
			for(FileItem item:multi) {		
				if (item.isFormField()) {
				    
					aadharnumber = item.getString();
					ses.setAttribute("useraadharnumber", aadharnumber);
				    
				}
				else{
				path = "userimages/"+ item.getName();
				
				if(obj.checkuseraadhar(aadharnumber))
				{
					
					out.println("<script type=\"text/javascript\">");
				      out.println("alert('with the same Aadhar number other User exists');");
				      out.println("location='NewUser.jsp';");
				      out.println("</script>");
				}else {
					gothere();
					item.write(new File("C:/Users/krypto kevin/eclipse-workspace/6th sem project/CarRentalSystem/src/main/webapp/userimages/" + item.getName()));
				}
				
				
				System.out.println("success");}
			}
			
			System.out.println("going");	
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('Aadhar is Uploaded Now fill the form');");
		      out.println("location='NewUser.jsp';");
		      out.println("</script>");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void gothere() throws SQLException
	{
		int cusid = (int)(Math.random()*(2000-1500+1)+1500);
		String cusidstr = String.valueOf(cusid);
		model obj = new model();
		obj.useraadharupload("CUS"+cusidstr, aadharnumber, path);
		
		
	}
	
}
