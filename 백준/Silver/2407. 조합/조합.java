import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new BigInteger[101][101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger result = combination(n, m);

        System.out.println(result);
    }

    static BigInteger combination(int n, int m) {
        if (dp[n][m] != null) {
            return dp[n][m];
        }
        if (n == m || m == 0) {
            return dp[n][m] = new BigInteger("1");
        }

        return dp[n][m] = combination(n - 1, m - 1).
            add(combination(n-1, m ));
    }

}