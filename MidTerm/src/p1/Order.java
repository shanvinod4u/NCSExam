package p1;

import java.io.Serializable;


public class Order implements Serializable, Comparable<Order> {
	

	private static final long serialVersionUID = 1L;
	private String username;
	private String category;
	private int orderCost;
	private String dateOfOrder;
	private String action;
	
	
	
	public Order(String username, String category, int orderCost, String dateOfOrder, String action) {
		super();
		this.username = username;
		this.category = category;
		this.orderCost = orderCost;
		this.dateOfOrder = dateOfOrder;
		this.action = action;
	}
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		
		return (int)(orderCost+3);
	}
	
	@Override
	public String toString() {
		return "Order [username=" + username + ", category=" + category + ", orderCost=" + orderCost + ", dateOfOrder="
				+ dateOfOrder + ", action=" + action + "]";
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Order)
		{
			Order order = (Order) obj;
			
			boolean a = this.username.equals(order.username);
			boolean b = this.orderCost == order.orderCost;
			boolean c = this.dateOfOrder.equals(order.dateOfOrder);
			boolean d = this.category.equals(order.category);
			boolean e = this.action.equals(order.action);
			
			return a && b && c && d && e;
			
		}
		else return false;
	}


	@Override
	public int compareTo(Order o) {
		return this.getOrderCost() - o.getOrderCost();
	}
	
	

}
