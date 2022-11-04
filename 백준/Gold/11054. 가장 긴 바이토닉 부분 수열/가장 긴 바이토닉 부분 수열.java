import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] dpLIS;
    static int[] dpLDS;
    static int[] e;
    public static void main(String[] args) throws IOException {

        /*
            수열 A가 주어졌을 때, S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을
            만족한다면, 그 수열을 바이토닉 수열이라하며, 임의의 수열의 부분 수열 중
            가장 긴 바이토닉 수열 구하기
            ex) {10, 20, 30, 25, 20}과 {10, 20, 30, 40},
             {50, 40, 25, 10} 은 바이토닉 수열

            n - 수열의 크기 ( 1 <= n <= 1,000)
            e - 수열을 이루는 원소 ( 1 <= e <= 1,000)

            dp[n] - n번째 수열의 가장 긴 부분 바이토닉 수열의 길이
            e[] - 수열 정보

            왼쪽에서 오른쪽으로 가는 LIS 즉, 최장 증가 부분 수열과,
            오른쪽에서 왼쪽으로 가는 LDS 즉, 최장 감소 부분 수열을 구해
            둘의 합을 구한다.

            ~
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        e = new int[n+1];
        dpLIS = new int[n+1];
        dpLDS = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <=n; i++) {
            e[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dpLIS, -1);
        Arrays.fill(dpLDS, -1);

        calMaxLDS(1);
        calMaxLIS(n);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dpLIS[i] + dpLDS[i] -1);
        }
        System.out.println(max);

    }

    public static int calMaxLDS(int index) {
        if (dpLDS[index] == -1) {
            dpLDS[index] = 1;

            for (int i = index + 1; i < dpLDS.length; i++) {
                if (e[i] < e[index]) {
                    dpLDS[index] = Math.max(calMaxLDS(i) + 1,
                            dpLDS[index]);
                } else{
                    calMaxLDS(i);
                }
            }
        }
        return dpLDS[index];
    }

    public static int calMaxLIS(int index) {
        if (dpLIS[index] == -1) {
            dpLIS[index] = 1;
            for (int i = index - 1; i > 0; i--) {
                if (e[index] > e[i]) {
                    dpLIS[index] = Math.max(calMaxLIS(i) + 1,
                            dpLIS[index]);
                } else {
                    calMaxLIS(i);
                }
            }
        }
        return dpLIS[index];
    }
}