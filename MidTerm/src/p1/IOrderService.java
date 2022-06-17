package p1;

import java.util.List;
import java.util.Map;


public interface IOrderService {
		
		public List<Order> getAllOrdersByCategory(String category)throws InvalidCategoryException;
		public int getTotalOrderCost(String category)throws InvalidCategoryException;
		public List<Order> getAllCanceledOrder();
		public Map<String, List<Order>> createOrderMapByUser(); // key is username , value is List of orders
		public List<Order> filterOrders(String action); 
		public List<Order> getOrdersBasedOnOrderValue(); // sort the orders
		public void generatePDFReports(); // method will count the number of orders on cash payment , online payment and remains unpaid, delivered or cancelled

		
}

