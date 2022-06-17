package p1;

public class InvalidCategoryException extends Exception {

	private static final long serialVersionUID = 1L;
	String category;
	
	public InvalidCategoryException(String category) {
		super();
		this.category = category;
	}
	
	public String getMessage() {
		return "Invalid category. Please input valid category";
	}

}
