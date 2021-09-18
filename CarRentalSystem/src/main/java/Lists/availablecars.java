package Lists;

public class availablecars 
{
	public String carname;
	public String carnumber;
	public String comp;
	public String mileage;
	public String amtperday;
	public String gears;
	public String enginetype;
	public String path;
	public availablecars(String carname, String carnumber, String comp, String mileage, String amtperday, String gears,
			String enginetype, String path) {
		super();
		this.carname = carname;
		this.carnumber = carnumber;
		this.comp = comp;
		this.mileage = mileage;
		this.amtperday = amtperday;
		this.gears = gears;
		this.enginetype = enginetype;
		this.path = path;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getAmtperday() {
		return amtperday;
	}
	public void setAmtperday(String amtperday) {
		this.amtperday = amtperday;
	}
	public String getGears() {
		return gears;
	}
	public void setGears(String gears) {
		this.gears = gears;
	}
	public String getEnginetype() {
		return enginetype;
	}
	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "availablecars [carname=" + carname + ", carnumber=" + carnumber + ", comp=" + comp + ", mileage="
				+ mileage + ", amtperday=" + amtperday + ", gears=" + gears + ", enginetype=" + enginetype + ", path="
				+ path + "]";
	}
	
	
	
}
