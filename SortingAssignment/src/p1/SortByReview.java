package p1;


import java.util.Comparator;
import java.util.List;

public class SortByReview implements Comparator<Product> {
		
	

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getAvgRating() - p2.getAvgRating();
	}
}
