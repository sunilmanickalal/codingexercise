package com.comcast.adcampaign.sources.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the entity object for ad campaign.
 */

@Entity
public class Campaign {
	
	@Id
	private String partner_id;
	private int duration;
	private String ad_content;
	private Timestamp creation_date;
	private String screationDate;
	
	public Campaign() {
		super();
	}

	public Campaign(String partner_id, int duration, String ad_content, Timestamp creation_date) {
		super();
		this.partner_id = partner_id;
		this.duration = duration;
		this.ad_content = ad_content;
		this.creation_date = creation_date;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}

//	@JsonIgnore
//    @JsonProperty(value = "creation_date")
	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	
//	@JsonIgnore
//    @JsonProperty(value = "screationDate")
	public String getScreationDate() {
		return screationDate;
	}

	public void setScreationDate(String screationDate) {
		this.screationDate = screationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ad_content == null) ? 0 : ad_content.hashCode());
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + duration;
		result = prime * result + ((partner_id == null) ? 0 : partner_id.hashCode());
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
		Campaign other = (Campaign) obj;
		if (ad_content == null) {
			if (other.ad_content != null)
				return false;
		} else if (!ad_content.equals(other.ad_content))
			return false;
		if (creation_date == null) {
			if (other.creation_date != null)
				return false;
		} else if (!creation_date.equals(other.creation_date))
			return false;
		if (duration != other.duration)
			return false;
		if (partner_id == null) {
			if (other.partner_id != null)
				return false;
		} else if (!partner_id.equals(other.partner_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Campaign [partner_id=" + partner_id + ", duration=" + duration 
				+ ", ad_content=" + ad_content + ", creation_date=" + creation_date + "]";
	}
	
}
