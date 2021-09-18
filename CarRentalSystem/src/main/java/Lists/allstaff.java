package Lists;

public class allstaff 
{

	public String staffid;
	public String name;
	public String phone;
	public String email;
	public String aadharnumber;
	public String path;
	public allstaff(String staffid, String name, String phone, String email, String aadharnumber, String path) {
		super();
		this.staffid = staffid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.aadharnumber = aadharnumber;
		this.path = path;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "allstaff [staffid=" + staffid + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", aadharnumber=" + aadharnumber + ", path=" + path + "]";
	}
	
	
}
