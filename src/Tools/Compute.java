package Tools;

import java.text.DecimalFormat;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;
import static java.lang.Math.asin;
import static java.lang.Math.acos;
import static java.lang.Math.atan;

public class Compute {
	private static DecimalFormat trigFormat = new DecimalFormat("0.000000");
	private static DecimalFormat inverseTrigFormat = new DecimalFormat("000.000000");

	public static void QuadraticCalculate(int a, int b, int c) {
		final double QUADRATIC_FORMULA_POWER = pow(b, 2);
		double solution1sqrt = sqrt(QUADRATIC_FORMULA_POWER - 4*a*c);
		double solution1 = (-b + solution1sqrt)/2*a; 
		double solution2 = (-b - solution1sqrt)/2*a;
		
		String solution1check = Double.toString(solution1);
		String solution2check = Double.toString(solution2);
		
		if(solution1check.equals("NaN") && solution2check.equals("NaN")) {
			System.out.println("Error - Imaginary Solution (Negative Square Root)");
			
		}else {
			System.out.println("Solution, (" + solution1 + " , " + solution2 + ")");
		}
	}
	
	public static double FactorialCalculate(double factorialNum) {
		if(factorialNum > 1) {
			return factorialNum * FactorialCalculate(factorialNum - 1);
			
		}else {
			return 1;
		}
	
	}
	
	public static double CoordinateDistanceCalculate(double x1, double x2, double y1, double y2) {
		double innerX = x1 - x2;
		double innerXsquare = pow(innerX, 2);
		
		double innerY = y1 - y2;
		double innerYsquare = pow(innerY, 2);
		
		double innerEquation = innerXsquare + innerYsquare;

		double distance = sqrt(innerEquation);
		
		return distance;
	}
	
	public static double SlopeCalculate(double x1, double x2, double y1, double y2) {
		double slope = (y2 - y1)/(x2 - x1);
		return slope;
	}
	
	public static double toRadians(double deg) {
		double rad = deg * PI / 180;
		return rad;
	}

	public static double toDegrees(double rad) {
		double deg = rad * 180 / PI;
		return deg;
	}

	public static double sinDeg(double radAngle) {
		double value = sin(toRadians(radAngle));
		String formattedStr = trigFormat.format(value);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}

	public static double cosDeg(double radAngle) {
		double value = cos(toRadians(radAngle));
		String formattedStr = trigFormat.format(value);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}

	public static double tanDeg(double radAngle) {
		double value = tan(toRadians(radAngle));
		String formattedStr = trigFormat.format(value);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}

	public static double arcsin(double angle){
		double val = toDegrees(asin(angle));
		String formattedStr = inverseTrigFormat.format(val);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}

	public static double arccos(double angle){
		double val = toDegrees(acos(angle));
		String formattedStr = inverseTrigFormat.format(val);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}

	public static double arctan(double angle){
		double val = toDegrees(atan(angle));
		String formattedStr = inverseTrigFormat.format(val);
		double formattedVal = Double.parseDouble(formattedStr);
		return formattedVal;
	}
	
	public static void PrimeFactorize(int n) {

        while (n % 2 == 0) {
            System.out.print(2 + ", ");
            n /= 2;
        }

        for (int i = 3; i <= sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + ", ");
                n /= i;
            }
        }

        if (n > 2)
            System.out.print(n);
    }

	public static int[][] sumMatrix(int[][] a, int[][] b) {
		int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

	public static int[][] subtractMatrix(int[][] a, int[][] b) {
	       int rows = a.length;
	       int columns = a[0].length;
	       int[][] result = new int[rows][columns];
	       for (int i = 0; i < rows; i++) {
	           for (int j = 0; j < columns; j++) {
	               result[i][j] = a[i][j] - b[i][j];
	           }
	       }
	       return result;
	   }

	public static int[][] multiplyMatrix(int[][] a, int[][] b, int r1, int c1, int c2) {
		int[][] product = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return product;
	}

	public static int[][] readMatrix(int rows, int columns) {
	    	@SuppressWarnings("resource")
			var input = new Scanner(System.in);
	    	int[][] result = new int[rows][columns];
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                result[i][j] = input.nextInt();
	            }
	        }
	        return result;
	}

	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
	    int columns = matrix[0].length;
	    for (int i = 0; i < rows; i++) {
	    	for (int j = 0; j < columns; j++) {
	               System.out.print(matrix[i][j] + " ");
	           }
	           System.out.println();
	       }
	}
	 
	public static double permutation(int a, int b) {
		double num1 = FactorialCalculate(a);
		double num2 = FactorialCalculate(a-b);
		double answer = num1/num2;
		return answer;
	}
	
	public static double logbx(double b, double x) {
		return Math.log(x)/Math.log(b);
	}
	
}
