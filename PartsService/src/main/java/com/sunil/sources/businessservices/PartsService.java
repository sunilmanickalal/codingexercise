package com.sunil.sources.businessservices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.sources.entities.Parts;
import com.sunil.sources.repositories.PartsRepository;

@Service
public class PartsService {

	@Autowired
	PartsRepository prepo;
	
	public List<Parts> listParts() {
		List<Parts> plist = new ArrayList<Parts>();
		prepo.findAll().forEach(plist::add);
		return plist;
	}


	public String addPart(Parts part) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<String> status = es.submit(new ExecutingThreads(prepo, part));
		try {
			System.out.println("Future: " + status.get() );
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successfully received data";
	}


}
