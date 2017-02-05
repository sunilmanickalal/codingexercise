package com.comcast.adcampaign.sources.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.adcampaign.sources.entities.Campaign;
import com.comcast.adcampaign.sources.services.AdCampaignService;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the main rest controller for the application
 */

@RestController
public class AdCampaignRestService {

	@Autowired
	private AdCampaignService adService;
	
	@RequestMapping(value="/adservice/listAllCampaigns", method=RequestMethod.GET)
	public List<Campaign> listAllCampaigns() {
		return adService.listAllCampaigns();
	}
	
	@RequestMapping(value="/adservice/findByCampaignId/{partnerId}", method=RequestMethod.GET)
	public Campaign findByCampaignId(@PathVariable String partnerId) {
		return adService.findByPartnerId(partnerId);
	}
	
	@RequestMapping(value="/adservice/addCampaign", method=RequestMethod.POST)
	public String addCampaign(@RequestBody Campaign c) {
		return adService.addCampaign(c);
	}
	
	@RequestMapping(value="/adservice/updateCampaign", method=RequestMethod.PUT)
	public String updateCampaign(@RequestBody Campaign cu) {
		return adService.updateCampaign(cu);
	}
	
	@RequestMapping(value="/adservice/deleteCampaign/{partnerId}", method=RequestMethod.DELETE)
	public String deleteCampaign(@PathVariable String partnerId) {
		return adService.deleteCampaign(partnerId);
	}
	
}
