import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        dp = new int[31][31];

        for (int i = 0; i <= 30; i++) {
            dp[0][i] = dp[i][i] = 1;
        }

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int leftSite = Integer.parseInt(st.nextToken());
            int rightSite = Integer.parseInt(st.nextToken());
            int result = combination(leftSite, rightSite);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    static int combination(int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        return dp[left][right] = combination(left - 1, right - 1) +
            combination(left, right - 1);
    }

}