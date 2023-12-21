package jCalculator;

import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import Tools.Compute;


public class Calculator {

	final static int SPEED_OF_LIGHT = 299792458;
	final static double C = pow(SPEED_OF_LIGHT, 2);
	
	public static void main(String[] args) {
			var input = new Scanner(System.in);
			var round = new DecimalFormat("0.00");
			
			System.out.println("\nWelcome to the calculator");
			
			CalculationExit:
			while(true) {
				
				ResetChoice:
				while(true) {
					System.out.println("\nWhich calculator would you like to use:");
					System.out.println("""
							
							(a) Quadratic Equation Calculator
							(b) Factorial Calculator
							(c) Standard Deviation and Mean Absolute Deviation Calculator
							(d) Standard Calculator
							(e) E = mc^2 Calculator
							(f) Coordinate Distance and Slope Calculator
							(g) Sine, Cosine, Tangent, Arcsin, Arccos, and Arctan Calculator
							(h) Pythagorean Theorem Calculator
							(i) Logarithm Calculator
							(j) Prime Factorization Calculator
							(k) Mortgage Calculator
							(l) Modular Inverse Calculator
							(m) Sine, Cosine, Tangent, and Cotangent Calculator Using Degrees
							(n) Matrix Calculator
							(o) Permutation/Combinaton Calculator
							(p) Degrees/Rotations/Time Needed to Travel a Certain Distance
							""");
					System.out.print("Enter your answer as a, b, c, d, etc.\n-> ");
					String calculatorChoice = input.next().toLowerCase();
					
					if(calculatorChoice.equals("a")) {
						System.out.print("Using your given quadratic equation (ax^2 + bx + c = 0), input a, b, and c");
						
						while(true) {
							System.out.print("\na = ");
							int a = input.nextInt();
							System.out.print("b = ");
							int b = input.nextInt();
							System.out.print("c = ");
							int c = input.nextInt();
							
							Compute.QuadraticCalculate(a, b, c);
							
							System.out.print("Keep Using (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("b")) {
						
						while(true) {
							System.out.print("Number to be factorialed: ");
							double result = Compute.FactorialCalculate(input.nextDouble());
							System.out.println("Factorial: " + result);
							
							System.out.print("Keep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("c")) {
						
						while(true) {
							
							System.out.print("How many numbers are in your set: ");
							byte lengthOfSet = input.nextByte();
							float[] setOfNumbers = new float[lengthOfSet];
							for(byte i = 0; i < lengthOfSet; i++) {
								System.out.print("Number: ");
								setOfNumbers[i] = input.nextFloat();
								
							}
							
							float sumOfOriginalValues = 0;
							double mean = 0;
							    for(int q = 0; q < setOfNumbers.length; q++) {
						    	sumOfOriginalValues += setOfNumbers[q]; 
							    mean = sumOfOriginalValues / setOfNumbers.length;
						    	
						    }
						    
						    double difference[] = new double[lengthOfSet];
						    
						    for(int w = 0; w < setOfNumbers.length; w++) {
						    	difference[w] = setOfNumbers[w] - mean;
						    	
						    }
						    
						    double squares[] = new double[lengthOfSet];
						    
						    for(int e = 0; e < difference.length; e++) {
						    	squares[e] = Math.pow(difference[e], 2);
						    	
						    }
						    
						    double sumOfSquares = 0;
						    
						    for(int r = 0; r < squares.length; r++) {
						    	sumOfSquares += squares[r]; 
						    	
						    }
						    
						    double quotient = sumOfSquares / (setOfNumbers.length - 1);
						    double standardDeviation = Math.pow(quotient, 0.5);
						    System.out.println("Standard Deviation (to the nearest hundredth): " + round.format(standardDeviation));
						    System.out.println("Mean Absolute Deviation (to the nearest hundredth): " + round.format(quotient));
							
							System.out.print("Keep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
						}
						
					}else if(calculatorChoice.equals("d")) {
						
						while(true) {
							
							System.out.print("Input first number: ");
							double number1 = input.nextDouble();
							
							System.out.print("Input operation (+, -, *, /, ^, or %): ");
							String operation = input.next();
							
							System.out.print("Input second number: ");
							double number2 = input.nextDouble();
							
							double result = 0;
							
							switch(operation) {
							case "+":
								result = number1 + number2;
								break;
							
							case "-":
								result = number1 - number2;
								break;
								
							case "*":
								result = number1 * number2;
								break;
								
							case "/":
								result = number1 / number2;
								break;
								
							case "^":
								result = Math.pow(number1, number2);
								break;
								
							case "%":
								result = number1 % number2;
								break;
							
							}
							System.out.println("= " + result);
							
							System.out.print("Keep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("e")) {
							
						while(true) {
								System.out.print("Enter mass (or \"m\") in kg (kilograms) in the equation E = mc^2: ");
								double m = input.nextDouble();
								
								if(m >= 0) {
									double e = m * C;
									System.out.println("Energy in joules: " + e);
									
								}else {
									System.out.println("Cannot have negative mass");
									
								}
								
								System.out.print("Keep using? (input \"back\" to go back to selecting a calculator): ");
								String keepUsing = input.next();
								
								while(true) {
									if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
										break;
									}
									
									System.out.println("Acceptable answers: Yes, No, Back");
									System.out.print("-> ");
									keepUsing = input.next().toLowerCase();
									
								}
								
								if(keepUsing.contains("no")) {
									break CalculationExit;
									
								}else if(keepUsing.contains("back")) {
									break ResetChoice;
									
								}
								
							}
						
					}else if(calculatorChoice.equals("f")){
						while(true) {
							System.out.print("Input x coordinate of first point: ");
							double xCoordinate1 = input.nextDouble();
							
							System.out.print("Input y coordinate of first point: ");
							double yCoordinate1 = input.nextDouble();
							
							System.out.print("Input x coordinate of second point: ");
							double xCoordinate2 = input.nextDouble();
							
							System.out.print("Input y coordinate of second point: ");
							double yCoordinate2 = input.nextDouble();
							
							double distanceAnswer = Compute.CoordinateDistanceCalculate(xCoordinate1, xCoordinate2, yCoordinate1, yCoordinate2);
							double slopeAnswer = Compute.SlopeCalculate(xCoordinate1, xCoordinate2, yCoordinate1, yCoordinate2);
							
							System.out.println("Distance between 2 points: " + distanceAnswer);
							System.out.println("Slope: " + slopeAnswer);
							
							System.out.print("Keep using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("g")) {
						
						while(true) {
							System.out.println("""
									what function do you want to use?
									(a): sin
									(b): cos
									(c): tan
									(d): arcsin
									(e): arccos
									(f): arctan""");
							System.out.print("-> ");
							String function = input.next();
							
							if(function.equals("a")){
								System.out.print("sin of what angle (in degrees): ");
								double sinIn = input.nextDouble();
								double sinAns = Compute.sinDeg(sinIn);
								System.out.println("sin(" + sinIn + ") = " + sinAns);
							}else if(function.equals("b")){
								System.out.print("cos of what angle (in degrees): ");
								double cosIn = input.nextDouble();
								double cosAns = Compute.cosDeg(cosIn);
								System.out.println("cos(" + cosIn + ") = " + cosAns);
							}else if(function.equals("c")){
								System.out.print("tan of what angle (in degrees): ");
								double tanIn = input.nextDouble();
								double tanAns = Compute.tanDeg(tanIn);
								System.out.println("tan(" + tanIn + ") = " + tanAns);
							}else if(function.equals("d")){
								System.out.print("arcsin of what (as a decimal): ");
								double arcsinIn = input.nextDouble();
								double arcsinAns = Compute.arcsin(arcsinIn);
								System.out.println("arcsin(" + arcsinIn + ") = " + arcsinAns);
							}else if(function.equals("e")){
								System.out.print("arccos of what (as a decimal): ");
								double arccosIn = input.nextDouble();
								double arccosAns = Compute.arccos(arccosIn);
								System.out.println("arccos(" + arccosIn + ") = " + arccosAns);
							}else if(function.equals("f")){
								System.out.print("arctan of what (as a decimal): ");
								double arctanIn = input.nextDouble();
								double arctanAns = Compute.arctan(arctanIn);
								System.out.println("arctan(" + arctanIn + ") = " + arctanAns);
							}else{
								System.out.println("unknown input \"" + function + "\"");
							}

							System.out.print("Keep using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("h")) {
						double answer;
						
						while(true) {
							System.out.println("""
									Select one:
									(a) Calculate for hypotenuse with 2 legs
									(b) Calculate for leg with 1 leg and hypotenuse
									Input your answer as \"a\" or \"b\"""");
							System.out.print("-> ");
							String choice = input.next().toLowerCase();
							
							if(choice.contains("a")) {
								System.out.print("Leg 1 = ");
								double leg1 = input.nextDouble();
								
								System.out.print("Leg 2 = ");
								double leg2 = input.nextDouble();
								
								answer = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
								
								if(leg1 == 0 || leg2 == 0) {
									System.out.println("Triangle lengths cannot be 0");
									break CalculationExit;
									
								}
								
								System.out.println("Hypotenuse length: " + answer);
								
							}else if(choice.contains("b")) {
								System.out.print("Leg 1 = ");
								double leg1 = input.nextDouble();
								
								System.out.print("Hypotenuse = ");
								double hypotenuse = input.nextDouble();
								
								answer = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(leg1, 2));
								
								if(leg1 == 0 || hypotenuse == 0) {
									System.out.println("Triangle lengths cannot be 0");
									break CalculationExit;
									
								}
								
								System.out.println("Leg length: " + answer);
								
							}else {
								System.out.println("Invalid input");
								break CalculationExit;
							}
							
							System.out.print("Keep using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("i")){
						
						while(true) {
							System.out.println("""
									Choose one:
									(a) Common log
									(b) Natural log
									(c) Custom log """);
							System.out.print("-> ");
							String selection = input.next();
							
							if(selection.contains("a") || selection.contains("b")) {
								System.out.println("Input a number");
								System.out.print("log");
								double logNumber = input.nextDouble();
								
								if(selection.contains("a")) {
									double commonLogAnswer = Math.log10(logNumber);
									System.out.println("= " + commonLogAnswer);
								}else {
									double naturalLogAnswer = Math.log(logNumber);
									System.out.println("= " + naturalLogAnswer);
								}
							}else if(selection.contains("c")) {
								System.out.print("base: ");
								double base = input.nextDouble();
								System.out.println("log_" + base + " of?");
								System.out.print("-> ");
								double logNumber2 = input.nextDouble();
								double customLogAnswer = Compute.logbx(base, logNumber2);
								System.out.println("log_"+ base + " of " + logNumber2 + " = " + customLogAnswer);
							}else {
								System.out.println("Invalid input");
								break CalculationExit;
							}
							
							System.out.print("Keep using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("j")) {
						while(true) {
							System.out.print("Enter an integer to be prime factorized: ");
							int factorizeNumber = input.nextInt();
							
							if(factorizeNumber > 1) {
								System.out.println("Prime factorization: ");
								Compute.PrimeFactorize(factorizeNumber);
								
							}else {
								System.out.println("Invalid input");
								
							}
							
							System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("k")) {
						while(true) {
							final byte MONTHSINYEAR = 12;
							final byte PERCENTAGE = 100;
							
							System.out.println("Loan Amount ($1k - $10m): ");
							double mortgageValue = input.nextInt();
							
							if(mortgageValue < 1000 || mortgageValue > 10000000) {
								while(mortgageValue < 1000 || mortgageValue > 10000000) {
									
									if(mortgageValue < 1000) {
										System.out.println("Loan amount too low.\n");
									}else {
										System.out.println("Loan amount too high.\n");
									}
									
									System.out.println("Loan Amount ($1k - $10m): ");
									mortgageValue = input.nextDouble();
								}
							}
							
							System.out.println("Annual Interest Rate Percentage (1 - 30): ");
							float annualInterestRate = input.nextFloat();
							
							if(annualInterestRate < 1 || annualInterestRate > 30) {
								while(annualInterestRate < 1 || annualInterestRate > 30) {
									
									if(annualInterestRate < 1) {
										System.out.println("Annual interest rate too low.\n");
									}else {
										System.out.println("Annual interest rate too high.\n");
									}
									
									System.out.println("Annual Interest Rate Percentage (1 - 30): ");
									annualInterestRate = input.nextFloat();
								}
							}
							
							System.out.println("Number of Years (1 - 30): ");
							float years = input.nextFloat();
							
							if(years < 1 || years > 30) {
								while(years < 1 || years > 30) {
									
									if(years < 1) {
										System.out.println("Loan duration too short.\n");
									}else {
										System.out.println("Loan duration too long.\n");
									}
									
									System.out.println("Number of Years (1 - 30): ");
									years = input.nextFloat();
								}
							}
							
							float period = years * MONTHSINYEAR;
							double monthlyInterestRate = annualInterestRate/PERCENTAGE/MONTHSINYEAR;
							double mortgage = mortgageValue * (monthlyInterestRate * pow(1+monthlyInterestRate, period)) / (pow(1+monthlyInterestRate, period)-1);
							String mortgageDollars = NumberFormat.getCurrencyInstance().format(mortgage);
							System.out.println("Mortgage Per Month: " + mortgageDollars);
							
							System.out.println("\nContinue Using? (input \"back\" to go back to selecting a calculator)?\n");
							System.out.print("-> ");
							String continueUsing = input.next().toLowerCase();
							
							while(true) {
								if(continueUsing.equals("yes") || continueUsing.equals("no") || continueUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No\n");
								System.out.print("-> ");
								continueUsing = input.next().toLowerCase();
								
							}
							
							if(continueUsing.equals("no")) {
								break CalculationExit;
								
							}else if(continueUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("l")) {
							while(true) {
								System.out.print("input first integer of modulus statement: ");
								int num1 = input.nextInt();
								System.out.print("\bmod ");
								int num2 = input.nextInt();
								
								int iLimit = num2 - 1;
								int test = 0;
								int answer = 0;
								
								SolutionFound:
								for(int i = 0; i < iLimit; i++) {
									test = (num1*i)%num2;
									answer = i;
									
									if(test == 1) {
										break SolutionFound;
										
									}
									
								}

								System.out.println("The inverse of " + num1 + " mod(" + num2 + ") is " + answer);
								
								System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
								String keepUsing = input.next().toLowerCase();
								
								while(true) {
									if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
										break;
									}
									
									System.out.println("Acceptable answers: Yes, No, Back");
									System.out.print("-> ");
									keepUsing = input.next().toLowerCase();
									
								}
								
								if(keepUsing.contains("no")) {
									break CalculationExit;
									
								}else if(keepUsing.contains("back")) {
									break ResetChoice;
									
								}
							}
						
					}else if(calculatorChoice.equals("m")) {
						while(true) {
							System.out.print("Input number of degrees in angle: ");
							double angleDegrees = input.nextInt();
							
							double sinValue = sin(angleDegrees);
							double cosValue = cos(angleDegrees);
							double tanValue = tan(angleDegrees);
							
							System.out.println("sin(" + angleDegrees + ") = " + sinValue);
							System.out.println("cos(" + angleDegrees + ") = " + cosValue);
							System.out.println("tan(" + angleDegrees + ") = " + tanValue);
							
							System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("n")) {
						while(true) {
					        System.out.print("Enter the number of rows of matrix A: ");
					        int rows1 = input.nextInt();
					        System.out.print("Enter number of columns of matrix A: ");
					        int columns1 = input.nextInt();
					        
					        System.out.print("Enter the number of rows of matrix B: ");
					        int rows2 = input.nextInt();
					        System.out.print("Enter number of columns of matrix B: ");
					        int columns2 = input.nextInt();

					        System.out.println();
					        System.out.println("Enter matrix A");
					        System.out.println("""
					        		Example: 
					        		1 2 3
					        		4 5 6
					        		""");
					        int[][] a = Compute.readMatrix(rows1, columns1);

					        System.out.println("Enter matrix B");
					        int[][] b = Compute.readMatrix(rows2, columns2);

					        System.out.println("\nA + B =");
					        if(rows1 == rows2 && columns1 == columns2) {
					        	int[][] sum = Compute.sumMatrix(a, b);
						        Compute.printMatrix(sum);
					        	
					        }else {
					        	System.out.println("Undefined");
					        	
					        }
					        
					        System.out.println("\nA - B =");
					        if(rows1 == rows2 && columns1 == columns2) {
					        	int[][] difference1 = Compute.subtractMatrix(a, b);
						        Compute.printMatrix(difference1);
					        	
					        }else {
					        	System.out.println("Undefined");
					        	
					        }

					        System.out.println("\nA * B =");
					        if(columns1 == rows2) {
					        	int[][] multiplication = Compute.multiplyMatrix(a, b, rows1, columns1, columns2);
					        	Compute.printMatrix(multiplication);
					        	
					        }else {
					        	System.out.println("Undefined");
					        	
					        }
					        
					        System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
							
						}
						
					}else if(calculatorChoice.equals("o")) {
						while(true) {
							System.out.println("""
									Choose one:
									(a) Permutation
									(b) Combination
									""");
							System.out.print("-> ");
							String pick = input.next().toLowerCase();
							
							while(true) {
								if(pick.equals("a") || pick.equals("b")) {
									break;
								}
								System.out.println("Acceptable answers: a, b");
								System.out.print("-> ");
								pick = input.next().toLowerCase();
								
							}
							
							if(pick.contains("a")) {
								System.out.print("Enter first number: ");
								int num1 = input.nextInt();
								System.out.print("Enter second number: ");
								int num2 = input.nextInt();
								double answer = Compute.permutation(num1, num2);
								System.out.println(num1 + "p" + num2 + " = " + answer);
								
							}else {
								System.out.print("Enter first number: ");
								int num1 = input.nextInt();
								System.out.print("Enter second number: ");
								int num2 = input.nextInt();
								double permutation = Compute.permutation(num1, num2);
								double factorialOfNum2 = Compute.FactorialCalculate(num2);
								double answer = permutation/factorialOfNum2;
								if(answer < 1) {
									answer = 0;	
								}
								System.out.println(num1 + "c" + num2 + " = " + answer);
								
							}
							
							 System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
								String keepUsing = input.next().toLowerCase();
								
								while(true) {
									if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
										break;
									}
									
									System.out.println("Acceptable answers: Yes, No, Back");
									System.out.print("-> ");
									keepUsing = input.next().toLowerCase();
									
								}
								
								if(keepUsing.contains("no")) {
									break CalculationExit;
									
								}else if(keepUsing.contains("back")) {
									break ResetChoice;
									
								}
														
						}
						
					}else if(calculatorChoice.equals("p")){
						System.out.print("input distance in cm: ");
						double distance = input.nextDouble();
						
						System.out.print("input distance traveled in 1 rotation of wheel: ");
						double rotationDistance = input.nextDouble();
						
						double rotations = distance/rotationDistance;
						double degrees = rotations * 360;
						
						System.out.println("number of rotations/seconds needed: " + rotations);
						System.out.println("number of degrees turned needed: " + degrees);
						
						 System.out.print("\nKeep Using? (input \"back\" to go back to selecting a calculator): ");
							String keepUsing = input.next().toLowerCase();
							
							while(true) {
								if(keepUsing.equals("yes") || keepUsing.equals("no") || keepUsing.equals("back")) {
									break;
								}
								
								System.out.println("Acceptable answers: Yes, No, Back");
								System.out.print("-> ");
								keepUsing = input.next().toLowerCase();
								
							}
							
							if(keepUsing.contains("no")) {
								break CalculationExit;
								
							}else if(keepUsing.contains("back")) {
								break ResetChoice;
								
							}
						
					}
					
					else {
						System.out.println("Invalid selection\n");
						break ResetChoice;
						
					}
					
				}
				
			}
		System.out.println("Program Terminated\n");
		input.close();
	}

}
