package User;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model2;

@WebServlet("/bookcar")
public class bookcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		String cusid = req.getParameter("custid");
		String cusname = req.getParameter("cusname");
		String carnumber = req.getParameter("vehicleid");
		String carname = req.getParameter("carname");
		String carcomp = req.getParameter("cname");
		String from = req.getParameter("fromdate");
		String to = req.getParameter("todate");
		String path = req.getParameter("path");
		HttpSession ses = req.getSession();
		model2 obj = new model2();
		
		try {
			obj.setbookedyes(carnumber);
			ses.setAttribute("bookingcarnumber", carnumber);
			ses.setAttribute("bookingcarname", carcomp+carname);
			obj.bookcar(cusid, cusname, carnumber, carname, carcomp, from, to,path);
			res.sendRedirect("CustomerMakePaymentPage.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
