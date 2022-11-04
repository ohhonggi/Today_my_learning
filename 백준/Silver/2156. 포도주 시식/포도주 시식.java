import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dp;
    static int[] p;

    public static void main(String[] args) throws IOException {
        /*
            다양한 포도주 잔이 일렬로 놓아져 있으며, 시식의 규칙은 다음과 같다.
            1. 포도주 잔 선택시, 모두 마셔야하며, 원래 위치로 되돌려놓아야 함
            2. 연속으로 놓여 있는 3잔은 마실 수 없음

            가능한 많은 양의 포도주를 맛보기 위해, 1부터 n까지 번호가 붙어 있는
            n개의 포도주을 마시도록 하는 프로그램 (1 <= n <= 10,000 , 0<= p <=1000)
            6 10 13 9 8 1의 경우 -> 1,2,4,5잔 선택을 통해 최대값 33을 만듬.

            dp[n] - 최대값을 계산해가는 table
            p[n] - 포도주 정보가 존재하는 테이블

            1. n번째 잔을 먹지 않는 경우 (dp[n] = dp[n-1])
            2. n번째 잔만 먹는 경우 (dp[n] = dp[n-2] + p[n])
            2. n번째 잔과 n-1번째 잔을 모두 먹는 경우 
                (dp[n] = dp[n-3] + p[n-1] + p[n])

            점화식
            dp[n] = Math.max(( dp[n-3] + p[n-1] + p[n] ),
                    dp[n-2] + p[n] )
            dp[n] = Math.max (dp[n-1], dp[n])

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 포도잔 개수

        dp = new int[n+1];
        p = new int[n+1];

        java.util.Arrays.fill(dp,-1);

        for (int i = 1; i <=n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = p[1];
        System.out.println(calMax(n));

    }

    public static int calMax(int index) {
        if (index <0) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = Math.max(calMax(index - 3) + p[index - 1] + p[index],
                calMax(index - 2) + p[index]);
        dp[index] = Math.max(dp[index], calMax(index - 1));

        return dp[index];
    }
}