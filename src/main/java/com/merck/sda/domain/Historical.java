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
/*@Table(name = "Historical", catalog = "SDA")*/
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE)

public class Historical extends BaseModel<String> implements Serializable{

	private String servername;
	private String foldername;
	private String userISID;
	private String dateStatus;
	private String type;
	
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

	public String getUserISID() {
		return userISID;
	}

	public void setUserISID(String userISID) {
		this.userISID = userISID;
	}

	public String getDateStatus() {
		return dateStatus;
	}

	public void setDateStatus(String dateStatus) {
		this.dateStatus = dateStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateStatus == null) ? 0 : dateStatus.hashCode());
		result = prime * result + ((foldername == null) ? 0 : foldername.hashCode());
		result = prime * result + ((servername == null) ? 0 : servername.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userISID == null) ? 0 : userISID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historical other = (Historical) obj;
		if (dateStatus == null) {
			if (other.dateStatus != null)
				return false;
		} else if (!dateStatus.equals(other.dateStatus))
			return false;
		if (foldername == null) {
			if (other.foldername != null)
				return false;
		} else if (!foldername.equals(other.foldername))
			return false;
		if (servername == null) {
			if (other.servername != null)
				return false;
		} else if (!servername.equals(other.servername))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userISID == null) {
			if (other.userISID != null)
				return false;
		} else if (!userISID.equals(other.userISID))
			return false;
		return true;
	}
	
	

}
