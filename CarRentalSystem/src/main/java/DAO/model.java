package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Lists.allusers;
import Lists.availablecars;

public class model {
database obj = new database();
public ArrayList<availablecars> carsobj = new ArrayList<availablecars>();
public ArrayList<Lists.allstaff> staffobj = new ArrayList<Lists.allstaff>();
public ArrayList<allusers> usersobj = new ArrayList<allusers>();
public String activestaffid; 
public String activeuserid;

public void uploadcarimage(String carnum,String path) throws SQLException
{
obj.connect();
String query = "insert into availablecars values(?,?,?,?,?,?,?,?,?)";

PreparedStatement stm = obj.con.prepareStatement(query);
stm.setString(1, carnum);
stm.setString(2, "null");
stm.setString(3, "null");
stm.setString(4, "null");
stm.setString(5, "null");
stm.setString(6, "null");
stm.setString(7, "null");
stm.setString(8, path);
stm.setString(9, "no");
stm.executeUpdate();



}

public boolean checkcarnumber(String carnum) throws SQLException
{
obj.connect();
String query ="select * from availablecars where carnumber=? and carname=?";
PreparedStatement stm = obj.con.prepareStatement(query);
stm.setString(1, carnum);
stm.setString(2, "null");
ResultSet rs = stm.executeQuery();
if(rs.next()) {
	return true;
}
return false;
}

public boolean checkcarnumberimage(String carnum) throws SQLException
{
	obj.connect();
	String query ="select * from availablecars where carnumber=? ";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, carnum);
	
	ResultSet rs = stm.executeQuery();
	if(rs.next()) {
		return true;
	}
	return false;
}


public void addcardetails(String carname,String comp,String carnumber,String mileage,String amt,String enginetype,String gear) throws SQLException
{
	obj.connect();
	String query="update availablecars set carname=?,carcompany=?,mileage=?,amtperday=?,noofgears=?,enginetype=? where carnumber=? and carname=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, carname);
	stm.setString(2, comp);
	stm.setString(3, mileage);
	stm.setString(4,amt);
	stm.setString(5, gear);
	stm.setString(6, enginetype);
	stm.setString(7, carnumber);
	stm.setString(8, "null");
	stm.executeUpdate();
	
	
	
}

public boolean adminlogin(String usrname,String pass) throws SQLException
{
	obj.connect();
	String query ="select * from admin where usrname=? and password=?";
	PreparedStatement stm =obj.con.prepareStatement(query);
	stm.setString(1, usrname);
	stm.setString(2, pass);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
	return true;
	}	
	return false;
}

public void availablecars() throws SQLException
{
	obj.connect();
	String query ="select * from availablecars where booked=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, "no");
	ResultSet rs = stm.executeQuery();
	while(rs.next())
	{
		carsobj.add(new availablecars(rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
	}

}
public void detailedcarsview(String carnumber) throws SQLException
{
	
	obj.connect();
	String query ="select * from availablecars where carnumber=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, carnumber);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		carsobj.add(new availablecars(rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
	}
}

public boolean checkstaffaadhar(String aadharnumber) throws SQLException
{
	obj.connect();
	String query="select * from staff where Aadharnumber=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, aadharnumber);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	
	return false;
}

public void uploadstaffaadhar(String Staffid,String path,String aadharnumber) throws SQLException
{
	obj.connect();
	
	if(checkstaffid(Staffid))
	{
		int staff = (int)(Math.random()*(2000-1500+1)+1500);
		String staffid = String.valueOf(staff);
		uploadstaffaadhar("ST"+staffid, path, aadharnumber);
	}
	
	else {
	String query= "insert into staff values(?,?,?,?,?,?,?,?)";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, Staffid);
	stm.setString(2, "null");
	stm.setString(3, "null");
	stm.setString(4, "null");
	stm.setString(5, "null");
	stm.setString(6, "null");
	stm.setString(7, aadharnumber);
	stm.setString(8, path);
	stm.executeUpdate();
	
	
	}
}

public boolean checkstaffid(String staffid) throws SQLException// this method is used to check duplicate of staffid
{

	obj.connect();
	String query ="select * from staff where StaffID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, staffid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	return false;
}

public boolean checkstaffaddharconfirm(String aadharnumber) throws SQLException
{
	obj.connect();
	String query="select * from staff where Aadharnumber=? and usrname=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, aadharnumber);
	stm.setString(2, "null");
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	return false;
}

public void addstaff(String fname,String lname,String phone,String email,String usrname,String pass,String aadharnumber) throws SQLException
{
	obj.connect();
	String query="update staff set usrname=?,password=?,Name=?,email=?,phone=? where Aadharnumber=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, usrname);
	stm.setString(2, pass);
	stm.setString(3, fname+" "+lname);
	stm.setString(4, email);
	stm.setString(5, phone);
	stm.setString(6, aadharnumber);
	stm.executeUpdate();
}

public void allstaff() throws SQLException
{
	obj.connect();
	String query="select * from staff";
	PreparedStatement stm = obj.con.prepareStatement(query);
	ResultSet rs = stm.executeQuery();
	while(rs.next())
	{
		
		staffobj.add(new Lists.allstaff(rs.getString(1),rs.getString(4),rs.getString(6),rs.getString(5),rs.getString(7),rs.getString(8)));
	}

}

public void detailedstaff(String staffid) throws SQLException
{
	obj.connect();
	String query="select * from staff where StaffID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, staffid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		staffobj.add(new Lists.allstaff(rs.getString(1),rs.getString(4),rs.getString(6),rs.getString(5),rs.getString(7),rs.getString(8)));
	}

}

public boolean stafflogin(String usrname,String pass) throws SQLException
{

	obj.connect();
	String query="select * from staff where usrname=? and password=?";
	PreparedStatement stm =obj.con.prepareStatement(query);
	stm.setString(1, usrname);
	stm.setString(2, pass);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		activestaffid = rs.getString(1);
		return true;
		
	}
	return false;
}

public boolean checkuseraadhar(String aadharnumber) throws SQLException
{
	obj.connect();
	String query="select * from users where AadharNumber=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, aadharnumber);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	
	return false;
}

public void useraadharupload(String cusid,String aadharnumber,String path) throws SQLException
{

	obj.connect();
	
	if(checkuserid(cusid))
	{
		int cid = (int)(Math.random()*(2000-1500+1)+1500);
		String cusidstr = String.valueOf(cid);
		useraadharupload("CUS"+cusidstr, aadharnumber, path);
	}
	
	else {
	String query="insert into users values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, cusid);
	stm.setString(2, "null");
	stm.setString(3, "null");
	stm.setString(4, "null");
	stm.setString(5, "null");
	stm.setString(6, "null");
	stm.setString(7, "null");
	stm.setString(8, aadharnumber);
	stm.setString(9, path);
	stm.executeUpdate();}
	
}

public boolean checkuserid(String cusid) throws SQLException
{
	obj.connect();
	String query ="select * from users where CustomerID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, cusid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	return false;

}

public boolean checkuseradharconfirm(String aadharnumber) throws SQLException
{
	obj.connect();
	String query="select * from users where AadharNumber=? and usrname=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, aadharnumber);
	stm.setString(2, "null");
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	return false;

}

public void adduser(String fname,String lname,String phone,String email,String usrname,String pass,String aadharnumber) throws SQLException
{
	obj.connect();
	String query="update users set usrname=?,password=?,FirstName=?,LastName=?,email=?,Phone=? where AadharNumber=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, usrname);
	stm.setString(2, pass);
	stm.setString(3, fname);
	stm.setString(4, lname);
	stm.setString(5, email);
	stm.setString(6, phone);
	stm.setString(7, aadharnumber);
	stm.executeUpdate();
	
}

public boolean userlogin(String usrname,String pass) throws SQLException
{
	obj.connect();
	String query="select * from users where usrname=? and password=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, usrname);
	stm.setString(2, pass);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		activeuserid = rs.getString(1);
		return true;
	}
	return false;
}

public void getstaffprofile(String staffid) throws SQLException
{
	obj.connect();
	String query="select * from staff where StaffID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, staffid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		staffobj.add(new Lists.allstaff(rs.getString(1),rs.getString(4),rs.getString(6),rs.getString(5),rs.getString(7),rs.getString(8)));
	}

}

public void getuserprofile(String cusid) throws SQLException
{
	obj.connect();
	String query="select * from users where CustomerID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, cusid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		usersobj.add(new allusers(rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
	}
}

public void availabelusers() throws SQLException
{
	obj.connect();
	String query="select * from users";
	PreparedStatement stm = obj.con.prepareStatement(query);
	ResultSet rs = stm.executeQuery();
	while(rs.next())
	{
		usersobj.add(new allusers(rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
	}

}


}//end of class
