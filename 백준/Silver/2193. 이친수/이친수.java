import java.util.Scanner;

class Main {
	static long [] field;
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		field = new long[n+2];
		java.util.Arrays.fill(field,-1);
		field[1] = field[2] = 1;
		System.out.println(Calculate(n));
	}
	static long Calculate(int n){
		if (field[n] != -1)
			return field[n];
		
		field[n] = Calculate(n-1) + Calculate(n-2);
		return field[n];
	}
}