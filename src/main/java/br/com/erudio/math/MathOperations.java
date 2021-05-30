package br.com.erudio.math;

public class MathOperations {

	
	public static Double sum(Double valueOne, Double valueTwo) {
		return valueOne + valueTwo;
	}
	
	public static Double subtraction(Double valueOne, Double valueTwo) {
		return valueOne - valueTwo;
	}
	
	
	public static Double multiplication(Double valueOne, Double valueTwo) {
		return valueOne * valueTwo;
	}
	
	public static Double division(Double valueOne, Double valueTwo) {
		return valueOne / valueTwo;
	}

	public static Double mean(Double valueOne, Double valueTwo) {
		return (sum(valueOne,valueTwo))/2;
	}
	
	public static Double squareRoot(Double value) {
		return Math.sqrt(value);
	}
	
}
