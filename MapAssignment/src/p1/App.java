package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {

	
	public static void main(String[] args) {
		
		 String rootPath = "C:\\Users\\malaishanmugam\\Desktop\\NCSTraining\\Collection Map Assignment\\";
		 String fileName = "mapdemo.csv";
		 File f = new File(rootPath+fileName);
		
		Map<Integer, Integer> map = new HashMap<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		try {
			while((line = br.readLine()) != null) {
				try {
				String data[] = line.split(",");
				int userId = Integer.parseInt(data[0]);
				int cost = Integer.parseInt(data[1]);
				
				if(!map.containsKey(userId)) {
					map.put(userId, cost);
				}else {
					map.put(userId, map.get(userId) + cost);
				}
				}catch (NumberFormatException e) {
					System.out.println("Not an integer");
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}	
	
}
