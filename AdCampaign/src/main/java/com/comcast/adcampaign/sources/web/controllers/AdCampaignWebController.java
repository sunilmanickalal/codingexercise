package com.comcast.adcampaign.sources.web.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comcast.adcampaign.sources.entities.Campaign;
import com.comcast.adcampaign.sources.services.AdCampaignService;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the main web controller for the application.
 */

@Controller
public class AdCampaignWebController {
	
	@Autowired
	private AdCampaignService adService;
	
	@RequestMapping(value="/ad", method=RequestMethod.GET)
	public String ad(Model mod) {
		mod.addAttribute("listAllCampaigns", adService.listAllCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/{partnerId}/delete", method=RequestMethod.GET)
	public String deleteCampaigne(@PathVariable String partnerId,Model mod) {
		adService.deleteCampaign(partnerId);
		mod.addAttribute("listAllCampaigns", adService.listAllCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/{partnerId}/update", method=RequestMethod.GET)
	public String updateCampaigne(@PathVariable String partnerId,Model mod) {
		mod.addAttribute("uCampaign", adService.findByPartnerId(partnerId));
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
			status = adService.addCampaign(cam);
			mod.addAttribute("status", status);
		}
		mod.addAttribute("listAllCampaigns", adService.listAllCampaigns());
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
			status = adService.updateCampaign(cam);
			mod.addAttribute("status", status);
		mod.addAttribute("listAllCampaigns", adService.listAllCampaigns());
		return "ad/list";
	}
	
	@RequestMapping(value="/ad/new", method=RequestMethod.GET)
	public String addCampaign() {
		return "ad/new";
	}
	
}
