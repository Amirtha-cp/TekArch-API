package com.TekarchAPI.utils;

import com.github.javafaker.Faker;


public class FakerUtils {

	private static final Faker fakerObj = new Faker();
	
	public static String generateAccountno() {
		return "TA-" + fakerObj.number().numberBetween(10000, 30000);
	}
	
	public static String generateDepartmentno() {
		return "TA-" + fakerObj.number().numberBetween(1, 9);
	}
	  public static String generateSalary() {
	        return fakerObj.number().digits(5);
	    }

	    public static String generatePincode() {
	        return fakerObj.address().zipCode();
	    }
}
