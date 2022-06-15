package com.ncs.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass implements FlightService {
	String rootPath = "C:\\Users\\malaishanmugam\\Desktop\\NCSTraining\\";
	String fileName = "PassengerList.txt";
	File f = new File(rootPath+fileName);
	
	Flight flights[] = new Flight[3];
	public Flight[] sampleData() {
		
		Passenger p1 = new Passenger();
		p1.setName("Mike");
		p1.setGender("Male");
		p1.setAge(35);
		
		Passenger p2 = new Passenger();
		p2.setName("Jessy");
		p2.setGender("Female");
		p2.setAge(30);
		
		Passenger p3 = new Passenger();
		p3.setName("John");
		p3.setGender("Male");
		p3.setAge(25);
		
		Passenger p4 = new Passenger();
		p4.setName("David");
		p4.setGender("Male");
		p4.setAge(40);
		
		Flight f1 = new Flight();
		f1.setFlightName("SIA");
		f1.setSourceAirport("Singapore");
		f1.setDestinationAirport("Mumbai");
		
		Passenger PassengersF1[] = new Passenger[3];
		PassengersF1[0] = p1;
		PassengersF1[1] = p2;
		PassengersF1[2] = p4;
		f1.setPassengers(PassengersF1);
		
		 
		Flight f2 = new Flight();
		f2.setFlightName("IA");
		f2.setSourceAirport("Singapore");
		f2.setDestinationAirport("Mumbai");
		
		Passenger PassengersF2[] = new Passenger[4];
		PassengersF2[0] = p1;
		PassengersF2[1] = p2;
		PassengersF2[2] = p3;
		PassengersF2[3] = p4;
		f2.setPassengers(PassengersF2);
		
		Flight f3 = new Flight();
		f3.setFlightName("Scoot");
		f3.setSourceAirport("Singapore");
		f3.setDestinationAirport("Mumbai");
		
		Passenger PassengersF3[] = new Passenger[2];
		PassengersF3[0] = p1;
		PassengersF3[1] = p4;
		f3.setPassengers(PassengersF3);
		
		flights[0] = f1;
		flights[1] = f2;
		flights[2] = f3;
		return flights;
		
	}

	public static void main(String[] args) {

		MainClass obj = new MainClass();
	    Flight[] flights = obj.sampleData();
		System.out.println("\n\n------ Flight Names -------");
		String[] flightNames = obj.getAllFlightNames();
		for (String flightName : flightNames) {
			System.out.println(flightName);
		}
		
		String srcAirport = "Singapore";
		String destAirport = "Mumbai";
		
		System.out.println("\n---- Flights between "+srcAirport+" and "+destAirport+" ----");
		Flight[] fl = obj.getFlightsBetweenAirports(srcAirport, destAirport);
		for (Flight flight : fl) {
			System.out.println(flight.getFlightName());
		}
		
		
		for (Flight flight : flights) {

			System.out.println("\n\n------"+flight.getFlightName()+"-------");
			Passenger PassengerInfo[] = obj.getPassengersInfo(flight);
			for (Passenger passenger : PassengerInfo) {
				obj.displayPassengerInfo(passenger);
			}	
			
			int count = obj.getTotalPassengersCount(flight);
			System.out.println("Total passengers : "+ count);
			
			int avgAge = obj.getAveragePassengerAge(flight);
			System.out.println("Average age of passengers : " + avgAge);
			
			int femalePass = obj.getTotalFemalePassengersCount(flight);
			System.out.println("Total female passengers : " + femalePass);
			
			int malePass = obj.getTotalMalePassengersCount(flight);
			System.out.println("Total male passengers : " + malePass);
			}
			
		for (Flight flight : flights) {
			obj.createFile(flight);
		}
		}
		

	public void createFile(Flight flight) {
		
		try {
			
			Passenger p[] = flight.getPassengers();
			writeFile(p);
			
			Passenger ps[] = (Passenger[]) readFile();
			System.out.println(ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public void writeFile(Passenger[] p) throws Exception {
		
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p);
	}
	
	public Passenger[] readFile()  throws Exception {
			Passenger p[] = null;
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			p = (Passenger[])ois.readObject();
			return p;
		}
	
	
	
	public void displayPassengerInfo(Passenger p) {
		System.out.println(p.getName()+" - "+p.getGender()+" - "+p.getAge());
	}

	@Override
	public String[] getAllFlightNames() {
		Flight listOfFlights[] =  sampleData();
		String flightNames[] = new String[listOfFlights.length];
		int index = 0;
		for (Flight flight : listOfFlights) {
			flightNames[index++] = flight.getFlightName();
		}
		return flightNames;
		
	}

	@Override
	public Flight[] getFlightsBetweenAirports(String srcAirport, String destinationAirport) {
		Flight listOfFlights[] =  sampleData();
		Flight f[] = new Flight[listOfFlights.length];
		int i = 0;
		for (Flight flight : listOfFlights) {
			if((flight.getSourceAirport().equals(srcAirport))&& (flight.getDestinationAirport().equals(destinationAirport)))
			{
				f[i++] = flight;
			}
		}	
		return f;
	}

	@Override
	public Passenger[] getPassengersInfo(Flight flight) {
		return flight.getPassengers();
	}

	@Override
	public int getTotalPassengersCount(Flight flight) {
		Passenger[] passengers = flight.getPassengers();
		int count = 0;
		for (Passenger passenger : passengers) {
			if(passenger != null) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getAveragePassengerAge(Flight flight) {
		Passenger[] passengers = flight.getPassengers();
		int count = 0;
		int totalAge = 0;
		int avgAge = 0;
		for (Passenger passenger : passengers) {
			if(passenger != null) {
				totalAge += passenger.getAge();
				count++;
			}
		}
		avgAge = totalAge/count;
		return avgAge;
	}

	@Override
	public int getTotalFemalePassengersCount(Flight flight) {
		Passenger[] passengers = flight.getPassengers();
		int count = 0;
		for (Passenger passenger : passengers) {
			if(passenger.getGender().equals("Female")) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getTotalMalePassengersCount(Flight flight) {
		Passenger[] passengers = flight.getPassengers();
		int count = 0;
		for (Passenger passenger : passengers) {
			if(passenger.getGender().equals("Male")) {
				count++;
			}
		}
		return count;
	}

}
