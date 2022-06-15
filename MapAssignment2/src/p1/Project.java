package p1;

import java.util.List;

public class Project {
	
	private String projectName;
	private List<Employee> resourceTeam;

	
	public String getProjectName() {
		return projectName;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", resourceTeam=" + resourceTeam + "]";
	}
	public List<Employee> getResourceTeam() {
		return resourceTeam;
	}
	public void setResourceTeam(List<Employee> resourceTeam2) {
		this.resourceTeam = resourceTeam2;
	}
	
}
