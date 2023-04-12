import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     * dp[n] = n일까지 상담했을 때, 얻을 수 있는 최대 수익 구하기
     * dp[n] = Math.max(dp[k]+price[k], dp[n]) ( 1<= k <= n )
     */
    static int[] time, price, dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n+2];
        price = new int[n+2];
        dp = new int[n+2];
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            time[i] = Integer.parseInt(split[0]);
            price[i] = Integer.parseInt(split[1]);
        }

        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j <= i; j++) {
                if (time[j]+j <= i){
                    dp[i] = Math.max(dp[i], dp[j] + price[j]);
                }
            }
        }
        System.out.println(dp[n+1]);
    }
}