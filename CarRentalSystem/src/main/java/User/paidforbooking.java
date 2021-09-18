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

import DAO.model2;


@WebServlet("/paidforbooking")
public class paidforbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		String carnumber= ses.getAttribute("bookingcarnumber").toString();
		model2 obj = new model2();
		try {
			obj.setpaidyes(carnumber);
			out.println("<script type=\"text/javascript\">");
		      out.println("window.close();");
		      out.println("location='CustomerMakePaymentPage.jsp';");
		      out.println("</script>");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
}
