import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리 {
    public static void main(String[] args) throws IOException {

        /*
         * dp문제
         * 현재 위치 i 이전까지의 돌의 높이보다 높은 돌인 경우 밟을 수 있다.
         * dp[i] = i번째 돌까지 밟았을 때, 밟은 돌의 최대 개수
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 ≤ N ≤ 3×103 인 정수
        int stoneNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 ≤ Ai ≤ 108 인 정수
        int[] stones = new int[stoneNum];
        int[] dp = new int[stoneNum];
        int result = 0;

        Arrays.fill(dp, 1);

        for (int i = 0; i < stoneNum; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < stoneNum; i++) {
            for (int j = 0; j <=i; j++) {
                if (stones[j] < stones[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }


}
