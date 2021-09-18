package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/addcar")
public class addcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		model obj = new model();
		String carname = req.getParameter("carname");
		String company = req.getParameter("cname");
		String carnumber = ses.getAttribute("carnumberforupload").toString();
		String mileage = req.getParameter("mileage");
		String amt = req.getParameter("amount");
		String enginetype = req.getParameter("ctype");
		String gear = req.getParameter("gear_not");
		
		if(carnumber.equals(null))
		{
			 out.println("<script type=\"text/javascript\">");
		      out.println("alert('Enter the carnumber to add the car');");
		      out.println("location='AddNewCar.jsp';");
		      out.println("</script>");
		}else {
		
			try {
				if(obj.checkcarnumber(carnumber))
				{
					 obj.addcardetails(carname, company, carnumber, mileage, amt, enginetype, gear);
					 ses.removeAttribute("carnumberforupload");
					 out.println("<script type=\"text/javascript\">");
				      out.println("alert('Succesfully added new car');");
				      out.println("location='AddNewCar.jsp';");
				      out.println("</script>");
				}else {
					out.println("<script type=\"text/javascript\">");
				      out.println("alert('upload image first  to add the car');");
				      out.println("location='AddNewCar.jsp';");
				      out.println("</script>");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	
	}

}
