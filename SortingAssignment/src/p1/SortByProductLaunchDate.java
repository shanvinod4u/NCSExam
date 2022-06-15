package p1;

import java.util.Comparator;

public class SortByProductLaunchDate implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getLaunchDate().compareTo(p2.getLaunchDate());
	}

}
