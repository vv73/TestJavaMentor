/*
 * Число
 */
public class Number {
	int num;
	boolean isRoman;

	public Number() {
	}

	public Number(int val) {
		num = val;
	}

	public Number(int num, int den) {
		this.num = num;
	}

	public Number(String str) {
		if (Converter.isRoman(str)) {
			this.num = Converter.romanToNumber(str);
			this.isRoman = true;
		} else {
			this.num = Integer.valueOf(str);
		}
	}

	@Override
	public String toString() {
		if (isRoman) {
			if (num > 0)
				return Converter.romanFromNumber(num);
			else
				return "Negative or zero Roman number";
		}
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
