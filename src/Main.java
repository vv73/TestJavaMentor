import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while(!input.equals("stop")) {
			Expression exp = Parser.parse(input);
			System.out.println(exp.eval());
			input = in.nextLine();
		}
	}
}
