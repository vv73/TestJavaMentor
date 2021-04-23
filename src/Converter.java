/*
 * Арабские-римские
 */
import static java.lang.String.join;
import static java.util.Collections.nCopies;

import java.util.*;

public class Converter {
	public static String romanFromNumber(int number) throws NumberFormatException {
		if (number <= 0)
			throw new NumberFormatException("Negative or zero cannot be written in Roman format");
		return join("", nCopies(number, "I")).replace("IIIII", "V").replace("IIII", "IV")
				.replace("VV", "X").replace("VIV", "IX").replace("XXXXX", "L").replace("XXXX", "XL").replace("LL", "C")
				.replace("LXL", "XC").replace("CCCCC", "D").replace("CCCC", "CD").replace("DD", "M")
				.replace("DCD", "CM");
	}

	public static int romanToNumber(String romanNumber) throws NumberFormatException{
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			
			default:
				throw new NumberFormatException("Wrong Roman number format");
			}	
		}
		return decimal;
	}

	public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}
	
	public static boolean isRoman(String str) {
		return str.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");	
	}
	

}

