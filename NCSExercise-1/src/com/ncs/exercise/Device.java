package com.ncs.exercise;

import java.util.Random;

public class Device {
	
	private String deviceName;
	private String ModelNumber;
	private int cost;
	private int avgRating;
	private String brandName;
	
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getModelNumber() {
		return ModelNumber;
	}
	public void setModelNumber(String modelNumber) {
		ModelNumber = modelNumber;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String createModelNumber(int length) {
		
		String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String NUMBER = "0123456789";
		String ALPHANUMERIC = CHAR + NUMBER;
		
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
	
		for(int i=0; i<length; i++) {
			
			int rndCharAt = rand.nextInt(ALPHANUMERIC.length());
			char randChar = ALPHANUMERIC.charAt(rndCharAt);
			sb.append(randChar);
		
		}
		return sb.toString();
		
	}
	
	
	
}
