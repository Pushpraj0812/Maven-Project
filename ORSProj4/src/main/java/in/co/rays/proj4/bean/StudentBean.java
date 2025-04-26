package in.co.rays.proj4.bean;

import java.sql.Date;

public class StudentBean extends BaseBean{
	
	private String fristName;
	private String lastName;
	private Date dob;
	private String mobileNo;
	private String email;
	private long collageID;
	private String collageName;
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCollageID() {
		return collageID;
	}
	public void setCollageID(long collageID) {
		this.collageID = collageID;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
}