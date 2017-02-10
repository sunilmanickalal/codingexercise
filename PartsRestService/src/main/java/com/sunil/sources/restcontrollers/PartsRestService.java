package com.sunil.sources.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.sources.businessservices.PartsService;
import com.sunil.sources.entities.Parts;

@RestController
public class PartsRestService {
	
	@Autowired
	private PartsService pservice;
	
	@RequestMapping(value="/plist", method=RequestMethod.GET)
	public List<Parts> listParts() {
		return pservice.listParts();
	}
	
	@RequestMapping(value="/addPart", method=RequestMethod.POST)
	public String addPart(@RequestBody Parts part) {
		return pservice.addPart(part);
	}
	
}
