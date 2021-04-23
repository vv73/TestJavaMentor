/*
 * Число
 */
public class Number {
	int num, den = 1;
	boolean isRoman;
	
	public Number() {}
	
	public Number(int val) {
		num = val;
	}
	
	public Number(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public Number(String str) {
		if (Converter.isRoman(str)) {
			this.num = Converter.romanToNumber(str);
		    this.isRoman = true;
		}
		else {
			this.num = Integer.valueOf(str);
		}
	}

	@Override
	public String toString() {
		if (isRoman) return Converter.romanFromNumber(num);
		return num + "";
	}
	
	public Number add(Number other) {
		Number res = new Number(num + other.num);
		res.isRoman = isRoman;
		return res;
	}
	
	public Number subtruct(Number other) {
		Number res = new Number(num - other.num);
		res.isRoman = isRoman;
		return res;
	}
	
	public Number multiply(Number other) {
		Number res = new Number(num * other.num);
		res.isRoman = isRoman;
		return res;
	}
	
	public Number divide(Number other) {
		Number res = new Number(num / other.num);
		res.isRoman = isRoman;
		return res;
	}
	
	
	
	
}
