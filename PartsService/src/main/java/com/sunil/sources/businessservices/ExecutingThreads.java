package com.sunil.sources.businessservices;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;

import com.sunil.sources.entities.Parts;
import com.sunil.sources.repositories.PartsRepository;

@Service
public class ExecutingThreads implements Callable<String>{

	private Parts part;
	
	private PartsRepository prepo;
	
	public ExecutingThreads() {
		super();
	}
	
	public ExecutingThreads(PartsRepository prepo, Parts part) {
		super();
		this.part = part;
		this.prepo = prepo;
	}
	
	@Override
	public String call() throws Exception {
		String result = "";
		try {
			System.out.println("Entered and sleeping for 4 seconds");
			Thread.currentThread().sleep(4000);
			System.out.println("woke up and executing save");
//			part.setPartnumber(3);
			System.out.println("Received part: " +  part.toString() );
			Parts savedPart = prepo.save(part);
			result = "successfully loaded part: " + savedPart.toString();
			System.out.println(result);
		} catch(Exception ex) {
			result = "Failed due to: " + ex.getMessage();
			System.out.println(result);
		}
		return result;
	}

}
