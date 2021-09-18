package Staff;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model2;


@WebServlet("/staffridecomplete")
public class staffridecomplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String cusid = req.getParameter("userid");
		String carnumber = req.getParameter("carnum");
		String carname = req.getParameter("carname");
		String carimage = req.getParameter("carpath");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		model2 obj = new model2();
		
		try {
			int days= obj.calculatdays(from,to);
			obj.addtransactions(cusid, carnumber, carname, carimage, from, to, days);
			
			obj.setcompleteride(carnumber);
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('Ride is Finished');");
		      out.println("location='StaffViewRideDetails.jsp';");
		      out.println("</script>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
