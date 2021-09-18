package Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/adminviewuser")
public class adminviewuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		String cusid = req.getParameter("userid");
		model obj = new model();
		
		
		try {
			obj.getuserprofile(cusid);
			ses.setAttribute("admninviewuser", obj.usersobj);
			res.sendRedirect("Adminviewuser.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
