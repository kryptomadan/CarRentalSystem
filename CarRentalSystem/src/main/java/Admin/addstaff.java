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

@WebServlet("/addstaff")
public class addstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String phnum = req.getParameter("phnum");
		String email = req.getParameter("emailid");
		String usrname = req.getParameter("uname");
		String pass = req.getParameter("pwd");
		HttpSession ses = req.getSession();
		String aadharnumber = ses.getAttribute("staffaadharnumber").toString();
		model obj = new model();
		if(aadharnumber==null)
		{
			 out.println("<script type=\"text/javascript\">");
		      out.println("alert('Enter the aadharnumber and upload aadhar to fill other details');");
		      out.println("location='AddStaff.jsp';");
		      out.println("</script>");
		}
		else 
		{
		try {
			if(obj.checkstaffaddharconfirm(aadharnumber))
			{
				obj.addstaff(fname, lname, phnum, email, usrname, pass, aadharnumber);
				ses.removeAttribute("staffaadharnumber");
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('Succesfully added new staff');");
			      out.println("location='AddStaff.jsp';");
			      out.println("</script>");
			}else {
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('upload Aadhar first  to add the staff');");
			      out.println("location='AddStaff.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		
	}

}
