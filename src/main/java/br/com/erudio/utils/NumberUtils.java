package br.com.erudio.utils;

public class NumberUtils {

	public static boolean isNumeric(String value) {
		if (value == null)
			return false;
		
		String number = value.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static Double convertValueToDouble(String value) {
		if (value == null) 
			return 0D;
		String number = value.replace(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		
		return 0D;
	}
}
