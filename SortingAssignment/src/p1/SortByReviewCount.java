package p1;

import java.util.Comparator;

public class SortByReviewCount implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getReviewCount() + p2.getReviewCount();
	}

}
