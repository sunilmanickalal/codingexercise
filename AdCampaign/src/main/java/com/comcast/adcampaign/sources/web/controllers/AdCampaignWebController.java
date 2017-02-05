package com.comcast.adcampaign.sources.web.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.comcast.adcampaign.sources.constants.AdCampaignConstants;
import com.comcast.adcampaign.sources.entities.Campaign;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the main web controller for the application.
 */

@Controller
public class AdCampaignWebController {
	
	private String urlGETList = AdCampaignConstants.HOST_AND_PORT + "/adservice/listAllCampaigns";
	private String urlGETById = AdCampaignConstants.HOST_AND_PORT + "/adservice/findByCampaignId/";
	private String urlPOST = AdCampaignConstants.HOST_AND_PORT + "/adservice/addCampaign";
	private String urlPUT = AdCampaignConstants.HOST_AND_PORT + "/adservice/updateCampaign";
	private String urlDELETE = AdCampaignConstants.HOST_AND_PORT + "/adservice/deleteCampaign/";
	
	@RequestMapping(value="/ad", method=RequestMethod.GET)
	public String ad(Model mod) {
		mod.addAttribute("listAllCampaigns", getListOfCampaigns());
		return "ad/list";
	}

	private Campaign[] getListOfCampaigns() {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Campaign[]> responseEntity = restTemplate.getForEntity(urlGETList, Campaign[].class);
        Campaign[] objects = responseEntity.getBody();
        displayContents(objects);
		return objects;
	}
	
	private void displayContents(Campaign[] objects) {
		for(Campaign cam: objects) {
			System.out.println("Output: " + cam.toString());
		}
	}

	@RequestMapping(value="/ad/{partnerId}/delete", method=RequestMethod.GET)
	public String deleteCampaigne(@PathVariable String partnerId,Model mod) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlDELETE+partnerId);
//		adService.deleteCampaign(partnerId);
		mod.addAttribute("listAllCampaigns", getListOfCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/{partnerId}/update", method=RequestMethod.GET)
	public String updateCampaigne(@PathVariable String partnerId,Model mod) {
		RestTemplate restTemplate = new RestTemplate();
		mod.addAttribute("uCampaign", restTemplate.getForObject(urlGETById + partnerId, Campaign.class));
		return "ad/edit";
	}
	
	@RequestMapping(value="/ad/adList",method=RequestMethod.POST)
	public String adList(HttpServletRequest req, Model mod) {
		String status = "";
		System.out.println("inside adList method");
		if(req.getParameter("partner_id")!=null) {
			String partner_id = req.getParameter("partner_id");
			int duration = Integer.parseInt(req.getParameter("duration"));
			String ad_content = req.getParameter("ad_content");
			System.out.println("partner: " + partner_id + " duration: " + duration + ", ad_content: " + ad_content );
			Campaign cam = new Campaign();
			cam.setPartner_id(partner_id);
			cam.setDuration(duration);
			cam.setAd_content(ad_content);
			
			RestTemplate restTemplate = new RestTemplate();
			status = (String) restTemplate.postForObject(urlPOST, cam, String.class);
			mod.addAttribute("status", status);
			System.out.println(status);
		}
		
		mod.addAttribute("listAllCampaigns", getListOfCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/{partnerId}/updateList",method=RequestMethod.POST)
	public String updateList(HttpServletRequest req, Model mod) {
		String status = "";
			System.out.println("inside updateList");
			String partner_id = req.getParameter("partner_id");
			int duration = Integer.parseInt(req.getParameter("duration"));
			String ad_content = req.getParameter("ad_content");
			String oldts = req.getParameter("creation_date");
			System.out.println("oldts: " + oldts);
			Timestamp ts = Timestamp.valueOf(oldts);
			System.out.println("ts: " + ts);
			System.out.println("partner: " + partner_id + " duration: " + duration + ", ad_content: " + ad_content );
			Campaign cam = new Campaign();
			cam.setPartner_id(partner_id);
			cam.setDuration(duration);
			cam.setAd_content(ad_content);
			cam.setCreation_date(ts);
			cam.setScreationDate(new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss").format(ts));
			try{
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.put(urlPUT, cam);
				status = "successfully updated: " + cam.getPartner_id() ;
			} catch (Exception ex) {
				status = "Failed to update due to: " + ex;
			}
			mod.addAttribute("status", status);
			mod.addAttribute("listAllCampaigns", getListOfCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/new", method=RequestMethod.GET)
	public String addCampaign() {
		return "ad/new";
	}
	
}
