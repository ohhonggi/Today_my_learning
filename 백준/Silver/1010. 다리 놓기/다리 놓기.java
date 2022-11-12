import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int leftSite = Integer.parseInt(st.nextToken());
            int rightSite = Integer.parseInt(st.nextToken());
            dp = new BigInteger[rightSite + 1];
            dp[0] = dp[1] = new BigInteger("1");
            for (int j = 2; j <= rightSite;  j++) {
                dp[j] = dp[j - 1].multiply(new BigInteger(String.valueOf(j)));
            }
            BigInteger result = dp[rightSite].divide(dp[leftSite].multiply(dp[rightSite-leftSite]));
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

}