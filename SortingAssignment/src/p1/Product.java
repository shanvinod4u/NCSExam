package p1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Product implements Serializable, Comparable<Product> {

	private static final long serialVersionUID = 1L;
	private int price;
	private List<Review> review;
	private LocalDate launchDate;
	private int reviewCount;
	private int avgRating;
	
	public int getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}

	@Override
	public int compareTo(Product p) {
		return this.price - p.price;
	}

	public int getPrice() {
		return price;
	}
	


	@Override
	public String toString() {
		return "Product [price=" + price + ", review=" + review + ", launchDate=" + launchDate + ", reviewCount="
				+ reviewCount + ", avgRating=" + avgRating + "]";
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		
		//System.out.println(" --->> Inside Hashcode :- "+this.name+" - "+this.accountNumber);
		return (int)(price+3);
		//108
	}

	@Override
	public boolean equals(Object obj) {
		//System.out.println(" ---------------->> Inside Equals :- "+this.name+" - "+this.accountNumber);
		if(obj instanceof Product)
		{
			Product product = (Product) obj;
			
			boolean a = this.launchDate.equals(product.launchDate);
			boolean b = this.price == product.price;
			boolean c = this.review.equals(product.review);
			
			return a && b && c;
			
		}
		else return false;
	}

	public Product(int price, List<Review> review, LocalDate launchDate) {
		super();
		this.price = price;
		this.review = review;
		this.launchDate = launchDate;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}



}
