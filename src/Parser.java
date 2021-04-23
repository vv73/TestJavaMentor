
/*
 * Парсер простейших выражений
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	public static Expression parse(String str) throws Exception {
		String numregex = "(\\d+|[IVXLCDM]+)";
		String regex = "^\\s*" + numregex + "\\s*" + "([+-/*])" + "\\s*" + numregex + "\\s*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		try {
			m.find();
			if (Converter.isRoman(m.group(1)) && Converter.isRoman(m.group(3))
					|| !Converter.isRoman(m.group(1)) && !Converter.isRoman(m.group(3))) {
				Expression exp = new Expression(new Number(m.group(1)), m.group(2), 
						new Number(m.group(3)));
				if (exp.left.num > 10 || exp.right.num > 10) {
					throw new NumberFormatException("The numbers are too large");
				}
				return exp;
			}
			else {
				throw new NumberFormatException("Arabic and Roman in one expression");
			}
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				throw e;
			}
			throw new Exception("Parsing exception");
		}
	}
}
