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


@WebServlet("/staffviewdetailedcar")
public class staffviewdetailedcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String carnumber = req.getParameter("carnumber");
		model obj = new model();
		HttpSession ses = req.getSession();
		
		try {
			obj.detailedcarsview(carnumber);
			ses.setAttribute("detailedcararray", obj.carsobj);
			res.sendRedirect("StaffViewDetailedCar.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
