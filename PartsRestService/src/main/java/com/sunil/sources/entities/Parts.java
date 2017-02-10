package com.sunil.sources.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parts {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer partnumber;
	
	private String partname;
	private String description;
	public Integer getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(Integer partnumber) {
		this.partnumber = partnumber;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Parts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parts(Integer partnumber, String partname, String description) {
		super();
		this.partnumber = partnumber;
		this.partname = partname;
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((partname == null) ? 0 : partname.hashCode());
		result = prime * result + ((partnumber == null) ? 0 : partnumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parts other = (Parts) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (partname == null) {
			if (other.partname != null)
				return false;
		} else if (!partname.equals(other.partname))
			return false;
		if (partnumber == null) {
			if (other.partnumber != null)
				return false;
		} else if (!partnumber.equals(other.partnumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Parts [partnumber=" + partnumber + ", partname=" + partname + ", description=" + description + "]";
	}
	
	
	
}
