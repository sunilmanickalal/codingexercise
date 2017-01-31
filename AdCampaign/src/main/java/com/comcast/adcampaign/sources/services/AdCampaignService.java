package com.comcast.adcampaign.sources.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comcast.adcampaign.sources.entities.Campaign;
import com.comcast.adcampaign.sources.repositories.AdCampaignRepository;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the business service for the ad campaign application
 */

@Service
public class AdCampaignService {
	
	@Autowired
	private AdCampaignRepository adrepo;
	
	public List<Campaign> listAllCampaigns() {
		List<Campaign> campaignList = new ArrayList<Campaign>();
		adrepo.findAll().forEach(campaignList::add);
		
		return campaignList;
	}
	
	public Campaign findByPartnerId(String partnerId) {
		Campaign cam = adrepo.findOne(partnerId);
		return cam;
	}

	public String addCampaign(Campaign c) {
		try {
			if(adrepo.findOne(c.getPartner_id())==null) {
				String state = checkForActiveAdsPresence();
				if(state.equalsIgnoreCase("false")) {
					c.setCreation_date(new Timestamp(System.currentTimeMillis()));
					c.setScreationDate(new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss").format(new Timestamp(System.currentTimeMillis())));
					adrepo.save(c);
				} else {
					throw new Exception("Active ad with PartnerID: ["+state+"] present, Please wait until it gets expired");
				}
			} else {
				throw new Exception("Duplicate Record - " + c.getPartner_id());
			}
		} catch(Exception ex) {
			return "Failed to add Campaign due to: " + ex.toString() ;
		}
		return "Successfully Added Campaign PartnerID: " + c.getPartner_id();
	}

	private String checkForActiveAdsPresence() {
		List<Campaign> campaignList = new ArrayList<Campaign>();
		adrepo.findAll().forEach(campaignList::add);
		for(Campaign cp: campaignList) {
			long now = cp.getCreation_date().getTime();
			Timestamp creationTimeInDB = new Timestamp(now);
			int durationFromDB = cp.getDuration();
			long afterAddingTime = now + TimeUnit.SECONDS.toMillis(durationFromDB);
			Timestamp totalTimeFromDB = new Timestamp(afterAddingTime);
			Timestamp current = new Timestamp(System.currentTimeMillis());
			long actual = current.getTime() - totalTimeFromDB.getTime();
			System.out.println("creationTimeInDB: " + new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss").format(creationTimeInDB) 
					+ "\nTotalTime From DB: " + new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss").format(totalTimeFromDB)
					+ "\nCurrentTime: " + new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss").format(current));
			System.out.println("Difference: " + actual);
			if(actual<0){
				System.out.println("falls within the active ad time");
				return cp.getPartner_id();
			} 
		}
		return "false";
	}

	public String updateCampaign(Campaign cu) {
		try{
			adrepo.save(cu);
		} catch(Exception ex) {
			return "Failed to update Campaign due to: " + ex.toString();
		}
		return "Successfully Updated Campaign PartnerID: " + cu.getPartner_id();
	}

	public String deleteCampaign(String partnerId) {
		try {
			adrepo.delete(partnerId);
		} catch (Exception ex) {
			return "Failed to delete Campaign due to: " + ex.toString();
		}
		return "Successfully Deleted Campaign PartnerID: " + partnerId;
	}
	
	
	
}
