package p1;

import java.util.Comparator;

public class SortByOrderValue implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		
		return o1.getOrderCost() - o2.getOrderCost();
	}

}
