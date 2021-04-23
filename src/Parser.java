/*
 * Парсер простейших выражений
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
     public static Expression parse(String str) {
    	 String numregex = "(\\d+|[IVXLCDM]+)";
    	 String regex = "^\\s*" + numregex + "\\s*" + "([+-/*])"+ "\\s*" + numregex + "\\s*$";
    	 Pattern p = Pattern.compile(regex);
    	 Matcher m = p.matcher(str);
    	 m.find();
    	 if (Converter.isRoman(m.group(1)) && Converter.isRoman(m.group(3)) || !Converter.isRoman(m.group(1)) && !Converter.isRoman(m.group(3)))
    		 return new Expression(new Number(m.group(1)), m.group(2), new Number(m.group(3)));
    	 return null;
    	 
     } 
}
