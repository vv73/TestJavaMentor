/*
 * Простейшее выражение
 */
public class Expression {
	Number left;
	String operation;
	Number right;

	public Expression(Number left, String operation, Number right) {
		this.left = left;
		this.operation = operation;
		this.right = right;
	}

	public Number eval() {

		switch (operation) {

		case "+":
			return left.add(right);

		case "*":
			return left.multiply(right);

		case "/":
			return left.divide(right);

		case "-":
			return left.subtruct(right);
		}
		return null;
	}

}
