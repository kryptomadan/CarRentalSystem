package Lists;

public class transactions {
public String cusid;
public String carnumber;
public String carname;
public String carimage;
public String totalamt;
public String from;
public String to;
public transactions(String cusid, String carnumber, String carname, String carimage, String totalamt, String from,
		String to) {
	super();
	this.cusid = cusid;
	this.carnumber = carnumber;
	this.carname = carname;
	this.carimage = carimage;
	this.totalamt = totalamt;
	this.from = from;
	this.to = to;
}
public String getCusid() {
	return cusid;
}
public void setCusid(String cusid) {
	this.cusid = cusid;
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
public String getCarimage() {
	return carimage;
}
public void setCarimage(String carimage) {
	this.carimage = carimage;
}
public String getTotalamt() {
	return totalamt;
}
public void setTotalamt(String totalamt) {
	this.totalamt = totalamt;
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
@Override
public String toString() {
	return "transactions [cusid=" + cusid + ", carnumber=" + carnumber + ", carname=" + carname + ", carimage="
			+ carimage + ", totalamt=" + totalamt + ", from=" + from + ", to=" + to + "]";
}

}
