package com.ncs.exercise;

public class EmployeeServiceApp {
	
	public static void main(String[] args) {
		
			
		EmployeeService service = new EmployeeService();
		String codes[] = service.getCity();
		String Ids[] = service.getEmployeeCodes();
		for (String empId : Ids) {
			System.out.println(empId + ": " );
			for (String city : codes) {
				System.out.println("--->> city code "+city);
				if (city.equals("011")) {
					System.out.println("Delhi");
				}
				else if (city.equals("022")) {
					System.out.println("Mumbai");
				}
				else if (city.equals("080")) {
					System.out.println("Banglore");
				}
				else if (city.equals("020")) {
					System.out.println( "Pune");
				}
			}	
		}
	}
}
