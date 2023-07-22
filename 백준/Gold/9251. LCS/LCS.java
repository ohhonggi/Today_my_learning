import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    static char[] s1, s2;
    public static void main(String[] args) throws IOException {
        /*
            최장 공통 부분 수열 구하기 (부분 수열은 연속된 값이 아니다!!)
            ex) ACAYKP, CAPCAK의 LCS = ACAK

            2차원 dp 배열 활용, dp[n][m] ( n은 s1, m은 s2의 길이 )

            dp[n][m]의미
            1. s1의 0부터 n까지 m과 비교하여 최대 부분 수열 구하기
            - 같은 문자인 경우 -> 해당 위치 바로 전까지 구한 최대 공통 부분수열에 + 1
            - 다른 문자인 경우 -> Math.max((비교한 위치-1,m), (비교한 위치, m-1))
            2. s2의 0부터 m까지 n과 비교하여 최대 부분 수열 구하기 (1번의 비교와 동일)

            점화식 결론
            if (i < 0 || j < 0)
                return 0
            else if s1.charAt(i) == s2.charAt(j)
                dp[i][j] = Math.max(lcs(i-1, j-1) + 1, dp[i][j])
            else
                dp[i][j] = Math.max(lcs(i, j-1), lcs(i-1, j))
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dp = new int[s1.length+1][s2.length+1];
        System.out.println(lcs(s1.length, s2.length));
    }

    // bottom-up
    public static int lcs(int s1i, int s2i){
        for (int i = 1; i <= s1i; i++) {
            for (int j = 1; j <= s2i; j++) {
                if (s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[s1i][s2i];
    }
}