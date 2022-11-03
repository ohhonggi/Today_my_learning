
import java.util.Scanner;

class Main {
	static int [][] field;
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		field = new int[n+1][10];
        for (int[] row: field)
		    java.util.Arrays.fill(row,0);
		for (int i =0; i<10; i++)
			field[1][i] = 1;
		
		for (int k=2; k<=n; k++){
			for (int j=0; j<10; j++){
				for (int i =j; i<10; i++){
					field[k][j] = (field[k][j]+field[k-1][i])%10007;
				}
			}
		}
		for (int i=0; i<10; i++)
			sum = (sum+field[n][i])%10007;
        System.out.print(sum);
        scan.close();
	}
}