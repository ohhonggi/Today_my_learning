import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
            블랙잭 : 카드의 합이 21을 넘지 않는 한도 내에서 카드 합을 최대한 크게 만드는 게임
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 카드 개수
        int m = Integer.parseInt(input[1]); // 카드의 합

        int[] cards = new int[n];
        int maxSum = 0;
        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cards);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (m >= sum) {
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}