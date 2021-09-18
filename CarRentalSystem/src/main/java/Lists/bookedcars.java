package Lists;

public class bookedcars {

	public String carnumber;
	public String carname;
	public String carcomp;
	public String cusid;
	public String custname;
	public String from;
	public String to;
	public String paid;
	public String ridecomplete;
	public String path;
	public bookedcars(String carnumber, String carname, String carcomp, String cusid, String custname, String from,
			String to, String paid, String ridecomplete, String path) {
		super();
		this.carnumber = carnumber;
		this.carname = carname;
		this.carcomp = carcomp;
		this.cusid = cusid;
		this.custname = custname;
		this.from = from;
		this.to = to;
		this.paid = paid;
		this.ridecomplete = ridecomplete;
		this.path = path;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarcomp() {
		return carcomp;
	}
	public void setCarcomp(String carcomp) {
		this.carcomp = carcomp;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public String getRidecomplete() {
		return ridecomplete;
	}
	public void setRidecomplete(String ridecomplete) {
		this.ridecomplete = ridecomplete;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "bookedcars [carnumber=" + carnumber + ", carname=" + carname + ", carcomp=" + carcomp + ", cusid="
				+ cusid + ", custname=" + custname + ", from=" + from + ", to=" + to + ", paid=" + paid
				+ ", ridecomplete=" + ridecomplete + ", path=" + path + "]";
	}
	
}
