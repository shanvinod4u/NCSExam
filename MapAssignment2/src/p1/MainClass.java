package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MainClass {
	
	public Project sampleData() {
		
		List<Employee> emp = new ArrayList<>();
				
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
		
		emp.add(e1);
		emp.add(e2);
		
		Project p1 = new Project();
		p1.setProjectName("BankApp");
		p1.setResourceTeam(emp);
		return p1;
	}

	
	public static void main(String[] args) {
		MainClass obj = new MainClass();
		
		Project project = new Project();
		project = obj.sampleData();
		
		List<Employee> employees = obj.getAllEmployees(project);
		
		System.out.println("\n------- "+project.getProjectName()+"----");
		for (Employee e : employees) {
			if(e != null) {
				System.out.println("\nEmpId = "+e.getEmpId()+"\nName = "+e.getName()+" \nSalary =  "+e.getSalary());
			}
		}
		System.out.println("\n------------------------------------\n");
		String projectName = obj.getProjectInfo(1, project);
		System.out.println("\nEmployee working on project: " + projectName);
	}

	
	public List<Employee> getAllEmployees(Project project){
		
		Map<Project, List<Employee>> hashMap = new HashMap<>();
		hashMap.put(project, project.getResourceTeam());
		List<Employee> employees = null;
		for (Entry<Project, List<p1.Employee>> emp : hashMap.entrySet()) {
			
			 employees = emp.getValue();
			
		}
		return employees;
	}
	
	public String getProjectInfo(int empId, Project project) {
		Map<Project, List<Employee>> hashMap = new HashMap<>();
		hashMap.put(project, project.getResourceTeam());
		List<Employee> employees = null;
		String projectName = null;
		for (Entry<Project, List<p1.Employee>> emp : hashMap.entrySet()) {
			employees = emp.getValue();	
			for (Employee employee : employees) {
				if(employee.getEmpId() == empId) {
				projectName = emp.getKey().getProjectName(); 
				}
			}
		}
		return projectName;
	}
	
}
