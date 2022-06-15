package com.ncs.training;

public class AirportDB {
	
	public static String allAirports[] = new  String[5];
	
	static {
		allAirports[0] = "Singapore";
		allAirports[1] = "New Delhi";
		allAirports[2] = "Hong Kong";
		allAirports[3] = "Shingai";
		allAirports[4] = "KL-Airport";
		
	}
	
	public static void main(String[] args) {
		
		AirportDB obj = new AirportDB();
		String airportName = "Mumbai";
		
		try {
			obj.checkValidAirport(airportName);
			
		} catch (InvalidAirportException e) {
			System.out.println(e.getIssue());
		}
		
	}
	
	public void checkValidAirport(String airportName) throws InvalidAirportException {
		for (String string : allAirports) {
			if(!string.equals(airportName)) {
				InvalidAirportException exp = new InvalidAirportException(airportName);
				throw exp;
				
			}else {
				System.out.println(airportName + " is a valid airport");
				break;
			}
		}
	}

}
