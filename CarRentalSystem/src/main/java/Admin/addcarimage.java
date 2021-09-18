package Admin;

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


@WebServlet("/addcarimage")
public class addcarimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String carnum;  
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
				    
					carnum = item.getString();
					ses.setAttribute("carnumberforupload", carnum);
				    
				}
				else{
				path = "carimages/"+ item.getName();
				
				if(obj.checkcarnumberimage(carnum))
				{
					
					out.println("<script type=\"text/javascript\">");
				      out.println("alert('with the same car number other car exist');");
				      out.println("location='AddNewCar.jsp';");
				      out.println("</script>");
				}else {
					gothere();
					item.write(new File("C:/Users/krypto kevin/eclipse-workspace/6th sem project/CarRentalSystem/src/main/webapp/carimages/" + item.getName()));
				}
				
				
				System.out.println("success");}
			}
			
				
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('Image is added you can add the car now');");
		      out.println("location='AddNewCar.jsp';");
		      out.println("</script>");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void gothere() throws SQLException
	{
		model obj = new model();
		
		obj.uploadcarimage(carnum, path);
	}

}
