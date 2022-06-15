package p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


import java.util.Collection;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) {
		
		List<Review> rev1 = new ArrayList<>();
		Review r1 = new Review(5, "Very Good");
		Review r2 = new Review(4, "Good");
		Review r3 = new Review(3, "Average");
		
		rev1.add(r1);
		rev1.add(r2);
		rev1.add(r3);
		
		List<Review> rev2 = new ArrayList<>();
		Review re1 = new Review(5, "Very Good");
		Review re2 = new Review(1, "Poor");
		
		rev2.add(re1);
		rev2.add(re2);
	
		
		Product p1 = new Product(100,rev1,(LocalDate.now()));
		p1.setReviewCount(reviewCount(p1));
		p1.setAvgRating(averageRating(p1));
		
		Product p2 = new Product(250, rev2,(LocalDate.of(2022, 06, 13)));
		p2.setReviewCount(reviewCount(p2));
		p2.setAvgRating(averageRating(p2));
		
		TreeSet<Product> set = new TreeSet<>();
		set.add(p1);
		set.add(p2);
		print(set, "Sort Based on Price");
		
		List<Product> list1 = new ArrayList<>();
		list1.addAll(set);
		SortByProductLaunchDate sortDate = new SortByProductLaunchDate();
		Collections.sort(list1, sortDate);
		print(list1,"Sort by LaunchDate");
		
		List<Product> list2 = new ArrayList<>();
		list2.addAll(set);
		SortByReviewCount sortReviewCount = new SortByReviewCount();
		Collections.sort(list2, sortReviewCount);
		print(list2,"Sort by Review Count");
		
		List<Product> list3 = new ArrayList<>();
		list3.addAll(set);
		SortByReview sortReiview = new SortByReview();
		Collections.sort(list3, sortReiview);
		print(list3,"Sort by Review Ratings");
		
		
		
		
	}
	
	public static void print(Collection<Product> collection, String tagLine) {
		System.out.println("\n-----" + tagLine + " -----\n");
		for (Product product : collection) {
			System.out.println(product);
		}
	}
	
	public static int reviewCount(Product product) {
		List<Review> r = product.getReview();
		int count =0;
		for (Review review : r) {
			if (review != null) {
				count++;
			}	
		}
		return count;
	}
	
	public static int averageRating(Product product) {
		List<Review> r = product.getReview();
		int count = 0;
		int totalRating = 0;
		int averageRating = 0;
		
		for (Review review : r) {
			if (review != null) {
				totalRating += review.getStarRating();
				count++;
			}	
		}
		averageRating = totalRating / count;
		return averageRating;
	}
	

}
