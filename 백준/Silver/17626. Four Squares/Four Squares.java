import java.util.Scanner;

public class Main {

    /*
        자연수 n이 주어질 때, 최소 개수의 제곱수 합 구하기
        0.5 sec (1 <= n <= 50,000)
     */
    static int [] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j*j<=i; j++){
                dp[i] = Math.min(dp[i] ,dp[i-j*j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
