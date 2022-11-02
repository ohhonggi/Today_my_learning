import java.util.Scanner;

class Main {
	static int [] field;
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int test;
		field = new int[12];
		java.util.Arrays.fill(field,-1);
		field[1] = 1;
		field[2] = 2;
		field[3] = 4;
		
		for (int i =0; i<n; i++){
			test = scan.nextInt();
			System.out.println(Calculate(test));
		}
  }
	public static int Calculate(int n){
		if (field[n] != -1)
			return field[n];
		
		field[n] = Calculate(n-1) + Calculate(n-2) + Calculate(n-3);
		return field[n];
	}
}