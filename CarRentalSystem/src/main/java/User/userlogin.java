package User;

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


@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String usrname = req.getParameter("uname");
		String pass = req.getParameter("pwd");
		HttpSession ses = req.getSession();
		model obj = new model();
		
		try {
			if(obj.userlogin(usrname, pass))
			{
				ses.setAttribute("activeuser", usrname);
				ses.setAttribute("activeuserid", obj.activeuserid);
				res.sendRedirect("CustomerHomePage.jsp");
			}else {
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('Invalidcredentials');");
			      out.println("location='CustomerLogin.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
