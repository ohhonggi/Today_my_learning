import java.util.Scanner;

public class Main {
	static int [][] field;
    public static void main( String [] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		field = new int[n+1][10];
        for (int[] row: field)
		    java.util.Arrays.fill(row,0);
		for (int i =1; i<10; i++)
			field[1][i] = 1;
		for (int k=2; k<=n; k++){
			for (int j=0; j<10; j++){
				if (j==0)
					field[k][j] = field[k-1][j+1];
				else if (j==9)
					field[k][j] = field[k-1][j-1];
				else
					field[k][j] = (field[k-1][j-1]+field[k-1][j+1])%1000000000;
			}
		}
		for (int i=0; i<10; i++)
			sum = (sum+field[n][i])%1000000000;
        System.out.print(sum);
        scan.close();
	}
}
