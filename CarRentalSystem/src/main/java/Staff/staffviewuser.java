package Staff;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/staffviewuser")
public class staffviewuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		System.out.println("coming to servlet");
		HttpSession ses = req.getSession();
		String cusid = req.getParameter("userid");
		model obj = new model();

		try {
			obj.getuserprofile(cusid);
			ses.setAttribute("staffviewuserobj", obj.usersobj);
			res.sendRedirect("Staffviewuser.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
