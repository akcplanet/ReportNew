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
/*@Table(name = "UserAccess", catalog = "SDA")*/
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class UserAccess extends BaseModel<String> implements Serializable{
	private String servername;
	private String foldername;
	private String readtypeandisid;
	private String readwritetypeandisid;
	
	
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

	public String getReadtypeandisid() {
		return readtypeandisid;
	}

	public void setReadtypeandisid(String readtypeandisid) {
		this.readtypeandisid = readtypeandisid;
	}

	public String getReadwritetypeandisid() {
		return readwritetypeandisid;
	}

	public void setReadwritetypeandisid(String readwritetypeandisid) {
		this.readwritetypeandisid = readwritetypeandisid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((foldername == null) ? 0 : foldername.hashCode());
		result = prime * result + ((readtypeandisid == null) ? 0 : readtypeandisid.hashCode());
		result = prime * result + ((readwritetypeandisid == null) ? 0 : readwritetypeandisid.hashCode());
		result = prime * result + ((servername == null) ? 0 : servername.hashCode());
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
		UserAccess other = (UserAccess) obj;
		if (foldername == null) {
			if (other.foldername != null)
				return false;
		} else if (!foldername.equals(other.foldername))
			return false;
		if (readtypeandisid == null) {
			if (other.readtypeandisid != null)
				return false;
		} else if (!readtypeandisid.equals(other.readtypeandisid))
			return false;
		if (readwritetypeandisid == null) {
			if (other.readwritetypeandisid != null)
				return false;
		} else if (!readwritetypeandisid.equals(other.readwritetypeandisid))
			return false;
		if (servername == null) {
			if (other.servername != null)
				return false;
		} else if (!servername.equals(other.servername))
			return false;
		return true;
	}
	
	
	
}
