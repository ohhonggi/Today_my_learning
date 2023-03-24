import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
            1. 선택 절차 : 동전 종류 중 하나를 선택
            2. 적절성 검사
                - 동전 개수가 최소가 되는 조건인지
            3. 해답 : 가치의 합이 k인지 판단하고, 아닐 경우 1번으로 돌아와 반복

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 동전 종류
        int k = Integer.parseInt(input[1]); // 가치의 합
        int sum = k;
        int result = Integer.MAX_VALUE;

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            sum = k;
            for (int j = i; j >= 0; j--) {
                count += sum/coin[j];
                sum = sum%coin[j];
                if (sum == 0) break;
            }
            result = Math.min(result, count);
        }

        System.out.println(result);
        br.close();
    }
}