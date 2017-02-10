package com.sunil.sources.businessservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.sources.entities.Parts;
import com.sunil.sources.repositories.PartsRepository;

@Service
public class PartsService {

	@Autowired
	private PartsRepository prepo;

	public List<Parts> listParts() {
		List<Parts> plist = new ArrayList<Parts>();
		prepo.findAll().forEach(plist::add);
		return plist;
	}

	public String addPart(Parts part) {
		String result = "success";
		try {
			prepo.save(part);
		} catch(Exception ex) {
			result = "Failed due to: " + ex.getMessage();
		}
		return result;
	}
	
	
}
