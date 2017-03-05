package com.merck.sda.dto;

public class UserAccessDTO {
	
	private String servername;
	private String foldername;
	private String startdate;
	private String enddate;
	private String userISID;
	
	
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getFoldername() {
		return foldername;
	}
	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getUserISID() {
		return userISID;
	}
	public void setUserISID(String userISID) {
		this.userISID = userISID;
	}
	

}
