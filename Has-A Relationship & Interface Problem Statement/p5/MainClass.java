package p5;


public class MainClass implements EmployeeService{
	Project projects[] = new Project[3];
	
	public Project sampleData1() {
		
		Project p1 = new Project();
		
		p1.setProjectName("BankApp");
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setName("A");
		e1.setSalary(2000);
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setName("B");
		e2.setSalary(8000);
		
		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setName("C");
		e3.setSalary(6000);
		
		Employee e4 = new Employee();
		e4.setEmpId(4);
		e4.setName("D");
		e4.setSalary(5000);
		
		Employee resourceTeam[] = new Employee[3];
		resourceTeam[0] = e1;
		resourceTeam[1] = e2;
		resourceTeam[2] = e3;
		
		
		p1.setResourceTeam(resourceTeam);
		return p1;
		
	}
	public Project SampleData2() {
		
		Project p2 = new Project();
		
		p2.setProjectName("AccountApp");
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setName("A");
		e1.setSalary(2000);
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setName("B");
		e2.setSalary(8000);
		
		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setName("C");
		e3.setSalary(6000);
		
		Employee e4 = new Employee();
		e4.setEmpId(4);
		e4.setName("D");
		e4.setSalary(5000);
		
		Employee resourceTeam[] = new Employee[2];
		resourceTeam[0] = e1;
		resourceTeam[1] = e4;
		
		
		p2.setResourceTeam(resourceTeam);
		return p2;
		
	}
	public Project SampleData3() {
		
		Project p3 = new Project();
		
		p3.setProjectName("DeviceApp");
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setName("A");
		e1.setSalary(2000);
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setName("B");
		e2.setSalary(8000);
		
		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setName("C");
		e3.setSalary(6000);
		
		Employee e4 = new Employee();
		e4.setEmpId(4);
		e4.setName("D");
		e4.setSalary(5000);
		
		Employee resourceTeam[] = new Employee[4];
		resourceTeam[0] = e1;
		resourceTeam[1] = e2;
		resourceTeam[2] = e3;
		resourceTeam[3] = e4;
		
		
		p3.setResourceTeam(resourceTeam);
		return p3;
		
	}
	

	
	public static void main(String[] args) {
		MainClass obj = new MainClass();
		obj.projects[0] = obj.sampleData1();
		obj.projects[1] = obj.SampleData2();
		obj.projects[2] = obj.SampleData3();
		
		for (Project project : obj.projects) {
			System.out.println("\n\n ==== "+project.getProjectName()+" ====");
			Employee arr[] = obj.getAllEmployees(project);
			for (Employee employee : arr) {
				obj.displayEmployeeInfo(employee);
			}
			
			int salary = obj.getSalary(2, project);
			System.out.println(" salary is "+salary);
			
			int totalSalaryPaid = obj.getTotalSalaryPaid(project);
			System.out.println("Total Salary cost "+totalSalaryPaid);
			
			String[] employeeNames = obj.getEmployeeNames(project);
				for (String employee : employeeNames) {
					System.out.println(employee);
				}
		}//end of for loop 
		
	
		
	}// end main

	
	public void displayEmployeeInfo(Employee e)
	{
		System.out.println("\n"+e.getEmpId()+" - "+e.getName()+" -  "+e.getSalary());
	}

	@Override
	public Employee[] getAllEmployees(Project project) {
		return project.getResourceTeam();
	}

	@Override
	public int getSalary(int empId, Project project) {

		Employee listOfEmployees[] = getAllEmployees(project);
		for (Employee employee : listOfEmployees) {
			if(employee.getEmpId() == empId) {
			return employee.getSalary();
			}
		}
		return 0;
	}

	@Override
	public int getTotalSalaryPaid(Project project) {
		Employee listofEmployees[] = getAllEmployees(project);
		
		int totalSalary = 0;
		for (Employee employee : listofEmployees) {
			totalSalary += employee.getSalary();
		}
		
		return totalSalary;
	}

	@Override
	public String[] getEmployeeNames(Project project) {
		
		Employee listOfEmployees[] = getAllEmployees(project);
		
		String employeeNames[] = new String[listOfEmployees.length];
		int pos = 0;
		for (Employee employee : listOfEmployees) {
			employeeNames[pos++] = employee.getName();
		}
		
		return employeeNames;
	}


	
	
}
