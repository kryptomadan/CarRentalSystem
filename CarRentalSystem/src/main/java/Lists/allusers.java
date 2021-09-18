package Lists;

public class allusers 
{
	public String cusid;
	public String fname;
	public String lname;
	public String phone;
	public String email;
	public String aadharnumber;
	public String path;
	public allusers(String cusid, String fname, String lname, String phone, String email, String aadharnumber,
			String path) {
		super();
		this.cusid = cusid;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.aadharnumber = aadharnumber;
		this.path = path;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "allusers [cusid=" + cusid + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email="
				+ email + ", aadharnumber=" + aadharnumber + ", path=" + path + "]";
	}
	
	
}
