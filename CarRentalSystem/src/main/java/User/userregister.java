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


@WebServlet("/userregister")
public class userregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String phone = req.getParameter("phnum");
		String email = req.getParameter("emailid");
		String usrname = req.getParameter("uname");
		String pass = req.getParameter("pwd");
		String aadharnumber = ses.getAttribute("useraadharnumber").toString();
		
		model obj = new model();
		if(aadharnumber==null)
		{
			 	out.println("<script type=\"text/javascript\">");
		      out.println("alert('Enter the aadharnumber and upload aadhar to fill other details');");
		      out.println("location='NewUser.jsp';");
		      out.println("</script>");
		}
		else 
		{
		try {
			if(obj.checkuseradharconfirm(aadharnumber))
			{
				obj.adduser(fname, lname, phone, email, usrname, pass, aadharnumber);
				ses.removeAttribute("useraadharnumber");
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('You are registered Successfully');");
			      out.println("location='NewUser.jsp';");
			      out.println("</script>");
			}else {
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('upload Aadhar first  to Register');");
			      out.println("location='NewUser.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		
		
		
	}

}
