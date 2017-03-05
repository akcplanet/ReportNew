package com.merck.sda.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
/*@Entity*/
/*@Table(name = "Ownership", catalog = "SDA")*/
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE)

public class Ownership extends BaseModel<String> implements Serializable{

	private String typeid;
	private String servername;
	private String foldername;
	private String ownerISID;
	private String ownershiptype;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@JsonProperty("id")
	public String getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

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

	public String getOwnerISID() {
		return ownerISID;
	}

	public void setOwnerISID(String ownerISID) {
		this.ownerISID = ownerISID;
	}

	public String getOwnershiptype() {
		return ownershiptype;
	}

	public void setOwnershiptype(String ownershiptype) {
		this.ownershiptype = ownershiptype;
	}
}
