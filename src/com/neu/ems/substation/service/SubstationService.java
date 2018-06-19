package com.neu.ems.substation.service;

public class SubstationService {

	private SubstationService(){
	}
	
	private static SubstationService service = new SubstationService();
	
	public static SubstationService getInstance(){
		return service;
	}
}
