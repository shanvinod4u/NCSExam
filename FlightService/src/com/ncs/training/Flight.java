package com.ncs.training;

import java.io.ObjectInputStream;
import java.io.Serializable;


public class Flight implements Serializable {

	private static final long serialVersionUID = 42L;
	private String flightName;
	private Passenger passengers[];
	private String sourceAirport;
	private String destinationAirport;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Passenger[] getPassengers() {
		return passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", sourceAirport="
				+ sourceAirport + ", destinationAirport=" + destinationAirport + "]";
	}
	
	private void readObject(ObjectInputStream ois)throws Exception
	{
		ois.defaultReadObject();
		
		this.setPassengers(new Passenger[ois.readInt()]);
	}

}
