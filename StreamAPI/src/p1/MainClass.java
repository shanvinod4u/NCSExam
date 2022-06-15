package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Abc implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);		
	}
	
}

public class MainClass {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		Abc abc = new Abc();
		list.stream().forEach(abc);
		
		//innerClass
		
		System.out.println("\n Inner Class Method");
		list.stream().forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});
		
		System.out.println("\n Lambda Expression Method");
		list.stream().forEach((String t) -> {
				System.out.println(t);
			});		
		
		System.out.println("\n Simplified Lambda Expression Method");
		list.stream().forEach((t)-> System.out.println(t));	

	}

}
