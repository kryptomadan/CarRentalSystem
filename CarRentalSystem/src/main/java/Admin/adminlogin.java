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


@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		model obj = new model();
		String usrname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		try {
			if(obj.adminlogin(usrname, pass)) 
			{
				ses.setAttribute("activeadmin", usrname);
				res.sendRedirect("AdminHomePage.jsp");
			}else {
				 
				 out.println("<script type=\"text/javascript\">");
			      out.println("alert('Invalid Credentials');");
			      out.println("location='AdminHomePage.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
