package User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/selectedcar")
public class selectedcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String carnumber = req.getParameter("carnumber");
		model obj = new model();
		HttpSession ses = req.getSession();
		
		try {
			obj.detailedcarsview(carnumber);
			ses.setAttribute("userselectedcararray", obj.carsobj);
			res.sendRedirect("Customerselectedcar.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
