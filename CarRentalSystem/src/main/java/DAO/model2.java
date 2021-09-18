package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import Lists.bookedcars;
import Lists.transactions;

public class model2 {
	database obj = new database();
	public ArrayList<bookedcars> bookedcarsobj = new ArrayList<bookedcars>();
	public ArrayList<transactions> transactionobj = new ArrayList<transactions>();

	
	public void bookcar(String cusid,String cusname,String carnumber,String carname,String cname,String from,String to,String path) throws SQLException
	{
		obj.connect();
		String query="insert into bookedcars values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm = obj.con.prepareStatement(query);
		
		stm.setString(1, carnumber);
		stm.setString(2, carname);
		stm.setString(3, cname);
		stm.setString(4, cusid);
		stm.setString(5, cusname);
		stm.setString(6, from);
		stm.setString(7, to);
		stm.setString(8, "no");
		stm.setString(9, "no");
		stm.setString(10,path);
		stm.executeUpdate();
	}
	
	public void setbookedyes(String carnumber) throws SQLException
	{
		obj.connect();
		String query ="update availablecars set booked=? where carnumber=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "yes");
		stm.setString(2, carnumber);
		stm.executeUpdate();
		
	}
	
	public boolean ifpaid(String carnumber) throws SQLException
	{
		obj.connect();
		String query = "select * from bookedcars where  carnumber =? and paid=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, carnumber);
		stm.setString(2, "no");
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
		
	}
	
	public void setpaidyes(String carnumber) throws SQLException
	{
		obj.connect();
		String query ="update bookedcars set paid=?,Ridecomplete=? where carnumber=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "yes");
		stm.setString(2, "no");
		stm.setString(3, carnumber);
		stm.executeUpdate();
		
	}
	
	public void adminridedetails() throws SQLException
	{
		obj.connect();
		String query="select * from bookedcars where paid=? and Ridecomplete=?";
		PreparedStatement stm  = obj.con.prepareStatement(query);
		stm.setString(1, "yes");
		stm.setString(2, "no");
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			bookedcarsobj.add(new bookedcars(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
		}
	}
	
	public void setcompleteride(String carnumber) throws SQLException
	{
		obj.connect();
		String query="update bookedcars set Ridecomplete=? where carnumber=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "yes");
		stm.setString(2, carnumber);
		stm.executeUpdate();
		
		String query2="update availablecars set booked=? where carnumber=?";
		PreparedStatement stm2 = obj.con.prepareStatement(query2);
		stm2.setString(1, "no");
		stm2.setString(2, carnumber);
		stm2.executeUpdate();
	}
	
	public int calculatdays(String from,String to)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(from, dtf);
	    LocalDate date2 = LocalDate.parse(to, dtf);
	    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
	    int days = (int) daysBetween;
	    return days;
	    
	}
	
	public void addtransactions(String cusid,String carnumber,String carname,String carimage,String from,String to,int days) throws SQLException
	{
		obj.connect();
		long totalamt = checkamtfordays(carnumber, days);
		String total = String.valueOf(totalamt);
		String query="insert into transactions values(?,?,?,?,?,?,?)";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, cusid);
		stm.setString(2, carnumber);
		stm.setString(3, carname);
		stm.setString(4, carimage);
		stm.setString(5, total);
		stm.setString(6, from);
		stm.setString(7, to);
		stm.executeUpdate();
	}
	
	public long checkamtfordays(String carnumber,int days) throws SQLException
	{
		obj.connect();
		String query="select * from availablecars where carnumber=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, carnumber);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			long amt = Integer.parseInt(rs.getString(5));
			amt = days*amt;
			return amt;
		}
		return 0;
	}
	
	public void alltransactions() throws SQLException
	{
		obj.connect();
		String query="select * from transactions";
		PreparedStatement stm = obj.con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			transactionobj.add(new transactions(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
	}
	
	public void useralltransactions(String cusid) throws SQLException
	{
		obj.connect();
		String query="select * from transactions where CustomerID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, cusid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			transactionobj.add(new transactions(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
	}
	
	public void userbookedcars(String cusid) throws SQLException
	{
		obj.connect();
		String query="select * from bookedcars where CustomerID=? and Ridecomplete=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, cusid);
		stm.setString(2, "no");
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			bookedcarsobj.add(new bookedcars(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
		}
	}
	
}//end of class

