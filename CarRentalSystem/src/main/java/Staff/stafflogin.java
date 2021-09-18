package Staff;

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


@WebServlet("/stafflogin")
public class stafflogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String usrname = req.getParameter("uname");
		String pass = req.getParameter("pwd");
		model obj = new model();
		HttpSession ses = req.getSession();
		
		try {
			if(obj.stafflogin(usrname, pass))
			{
				ses.setAttribute("activestaff", usrname);
				ses.setAttribute("activestaffid", obj.activestaffid);
				res.sendRedirect("StaffHomePage.jsp");
				
				
			}
			else {
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('Invalid Credentials');");
			      out.println("location='Staff_Login.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
