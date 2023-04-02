import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] elements;
    static int n,k;
    static int result;
    public static void main(String[] args) throws IOException {
        /*
         * N보다 작거나 같은 자연수 중에서, 집합 K의 원소로만 구성된 가장 큰 수를 출력하는 프로그램
         * (10 ≤ N ≤ 100,000,000, 1 ≤ K의 원소의 개수 ≤ 3, 1 ≤ K 원소 범위 ≤ 9)
         * 항상 K의 원소로만 구성된 N보다 작거나 같은 자연수를 만들 수 있는 경우만 입력으로 주어짐
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        elements = new int[k];

        for (int i = 0; i < k; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int num) {
        if (num > n) return ;

        if (result <= num) {
            result = num;
        }

        for (int i = k-1; i >= 0; i--) {
            dfs(num * 10 + elements[i]);
        }
    }
}