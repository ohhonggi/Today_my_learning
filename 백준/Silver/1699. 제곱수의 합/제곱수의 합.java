import java.util.Scanner;

class Main{
	static int [] multiple;
    public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();	// 자연수 N
		multiple = new int[n+1]; // multiple[i] - i를 제곱수의 합으로 나타내는 경우
		
		for (int i = 1; i<=n; i++){
			multiple[i] = i;
			for (int j = 1; j*j<=i; j++)
				multiple[i] = Math.min(multiple[i],multiple[i-j*j]+1);
		}
		System.out.println(multiple[n]);
		scan.close();
    }
}