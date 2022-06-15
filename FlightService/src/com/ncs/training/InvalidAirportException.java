package com.ncs.training;

public class InvalidAirportException extends Exception {
	
	String airportName;
	
	public InvalidAirportException(String name) {
		super();
		this.airportName = name;
	}
	
	public String getIssue() {
		return airportName+" airport not in the list";
	}
}
