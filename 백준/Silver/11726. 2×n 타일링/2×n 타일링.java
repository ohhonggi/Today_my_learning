import java.util.Scanner;

class Main {
	static int [] field;
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		field = new int[n+2];
		java.util.Arrays.fill(field,-1);
		field[1] = 1;
		field[2] = 2;
        System.out.println(Calculate(n));
        scan.close();
    }
	public static int Calculate(int i){
		if (field[i] != -1)
		  return field[i];

		field[i] = (Calculate(i-1)+Calculate(i-2))%10007;
		return field[i];
	}
}