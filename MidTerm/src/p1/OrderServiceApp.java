package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;




public class OrderServiceApp implements IOrderService {
	
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	List<Order> orders = new ArrayList<>();
	
	String rootPath = "C:\\Users\\malaishanmugam\\Desktop\\NCSTraining\\MidTerm\\";
	String fileName = "Order.csv";
	String pdfFile = "Reports.pdf";
	File f = new File(rootPath+fileName);
	File f1 = new File(rootPath+pdfFile);
	
	
	public static void main(String[] args){
		
		OrderServiceApp app = new OrderServiceApp();
		List<Order> order = app.getData();
		
		while(true)
		{
			System.out.println("\n\n -------------------------------------\n");
			System.out.println("1. Get orders by category");
			System.out.println("2. Get total order cost");
			System.out.println("3. Get cancelled orders");
			System.out.println("4. Get order by user ");
			System.out.println("5. Filter order");
			System.out.println("6. Get order by value ");
			System.out.println("7. Generate report");
			
			System.out.println("0. Exit");
			
			System.out.println("Enter User Choice :- ");
			int choice = app.sc.nextInt();
			switch (choice) {
			
			case 0: 
					System.exit(0);
					
			case 1:
				System.out.println("Please input the category");
				String cat = app.sc1.nextLine();
				
				try {
					List<Order> orderByCategery = app.getAllOrdersByCategory(cat);
					for (Order order2 : orderByCategery) {
						app.showDetails(order2);
					}
				} catch (InvalidCategoryException e) {
					e.getMessage();
				}
				break;
				
			case 2:
				System.out.println("Please input the category");
				String cat1 = app.sc1.nextLine();
				try {
					app.getTotalOrderCost(cat1);
				} catch (InvalidCategoryException e) {
					
					e.getMessage();
				}
				break;
				
			case 3:
				List<Order> cancelOrders = app.getAllCanceledOrder();
				for (Order order2 : cancelOrders) {
					app.showDetails(order2);
				}
				break;
				
			case 4:
				
				Map<String, List<Order>> map = app.createOrderMapByUser();
				for(Map.Entry<String,List<Order>> ords : map.entrySet()) {
					System.out.println("Key : "+ ords.getKey() + " Value : " + ords.getValue());
				}
				break;
				
			case 5:
				System.out.println("Please input an action");
				String cat3 = app.sc1.nextLine();
				List<Order> orderByAction = app.filterOrders(cat3);
				for (Order order2 : orderByAction) {
					app.showDetails(order2);
				}
				break;
				
			case 6:
				List<Order> sortedOrder = app.getOrdersBasedOnOrderValue();
				 for (Order order2 : sortedOrder) {
					app.showDetails(order2);
				}
				break;
			
			case 7:
				app.generatePDFReports();
				try {
					app.pdfRead();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		default:
			break;
		}
		}
	}

	@Override
	public List<Order> getAllOrdersByCategory(String category) throws InvalidCategoryException {
		List<Order> order = orders;
		List<Order> orderByCategory = new ArrayList<>();
		for (Order order2 : order) {
			if(order2.getCategory().equals(category)) {
				orderByCategory.add(order2);
			}
		}
		return orderByCategory;
	}

	@Override
	public int getTotalOrderCost(String category) throws InvalidCategoryException {
		List<Order> order = orders;
		int totalOrderCost = 0;
		for (Order order2 : order) {
			if(order2.getCategory().equals(category) && order2.getAction().equals("delivered")) {
				totalOrderCost += order2.getOrderCost();
			}
			
		}
		System.out.println(totalOrderCost);
		return totalOrderCost;
	}

	@Override
	public List<Order> getAllCanceledOrder() {
		List<Order> order = orders;
		List<Order> cancelledOrder = new ArrayList<>();
		for (Order order2 : order) {
			if(order2.getAction().equals("cancelled")) {
					cancelledOrder.add(order2);
			}
		}
		return cancelledOrder;
	}

	@Override
	public Map<String, List<Order>> createOrderMapByUser() {
		List<Order> order = orders;
		Map<String, List<Order>> map = new HashMap<>();
		for (Order order2 : order) {
			if(!map.containsKey(order2.getUsername())) {
				map.put(order2.getUsername(), order);
			}
		}
		return map;
	}

	@Override
	public List<Order> filterOrders(String action) {
		List<Order> order = orders;
		List<Order> orderByAction = new ArrayList<>();
		for (Order order2 : order) {
			if(order2.getAction().equals(action)) {
				orderByAction.add(order2);
			}
		}
		return orderByAction;
	}

	@Override
	public List<Order> getOrdersBasedOnOrderValue() {
		List<Order> order = orders;
		List<Order> sortedOrder = null;
		SortByOrderValue sortByValue = new SortByOrderValue();
		Collections.sort(order, sortByValue);
		sortedOrder = order;
		return sortedOrder;
	}

	@Override
	public void generatePDFReports() {
		List<Order> order = orders;
		int count1 = 0;
		int count2 =0;
		int delivered = 0;
		int cancelled = 0;
		
		for (Order order2 : order) {
			if (order2.getAction().equals("delivered")) {
				count1++;
			}else if (order2.getAction().equals("cancelled")) {
				count2++;
			}
		}
		 delivered = count1;
		 cancelled = count2;
		 
		 PDDocument document = new PDDocument();
		 PDPage page = new PDPage();
		 document.addPage(page);
		 		 
		 try {
			PDPageContentStream contStream = new PDPageContentStream(document, page);
			
			contStream.beginText();
			contStream.setLeading(15.5f);
			contStream.setFont(PDType1Font.TIMES_ROMAN, 12f);
			contStream.newLineAtOffset(25, 700);
			String line1 = "Total count of delivered order : " + delivered;
			String line2 = "Total count of cancelled order : " + cancelled;
			contStream.showText(line1);
			contStream.newLine();
			contStream.newLine();
			contStream.showText(line2);
			contStream.newLine();
			contStream.endText();
			
			contStream.close();
			document.save(f1);
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public void pdfRead() throws Exception {
		
		try {
			
			PDDocument myPdf;
			myPdf = PDDocument.load(f1);
			PDFTextStripper pdfReader;
			pdfReader = new PDFTextStripper();
			String wholePdfDoc = pdfReader.getText(myPdf);
			System.out.println(wholePdfDoc);
			myPdf.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getCategory(String category) throws InvalidCategoryException {
		
		if((!category.equals("cloths")) || (!category.equals("shoes")) || (!category.equals("electronic"))
				||(!category.equals("grocery"))|| (!category.equals("pharma")) ) {
			InvalidCategoryException exp = new InvalidCategoryException(category);
			throw exp;
		}
	}
	
	public void showDetails(Order order) {
		System.out.println("Username :" + order.getUsername() + " Category: " + order.getCategory()+
				" Order Cost: " + order.getOrderCost()+ " Date Of Order: " + order.getDateOfOrder()+
				 " Action: " + order.getAction());
	}
	
	public List<Order> getData() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = "";
		try {
				while((line = br.readLine()) != null) {
					Order orderObj = new Order();
					String[] data = line.split(",");
					orderObj.setUsername(data[0]); 
					orderObj.setCategory(data[1]);
					orderObj.setOrderCost(Integer.parseInt(data[2]));
					orderObj.setDateOfOrder(data[3]);
					orderObj.setAction(data[4]);
					
					orders.add(orderObj);					
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
}