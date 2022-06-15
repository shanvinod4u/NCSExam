package p1;

public class Review  {
	
	private int starRating;
	private String comment;
	
	
	
	public Review(int starRating, String comment) {
		super();
		this.starRating = starRating;
		this.comment = comment;
	}
	
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [starRating=" + starRating + ", comment=" + comment + "]";
	}
}
