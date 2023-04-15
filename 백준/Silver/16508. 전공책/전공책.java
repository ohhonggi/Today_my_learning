import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] prices;
    static int n,wordL,min = Integer.MAX_VALUE;
    static String word;
    /*
     * 1. k번째 글자가 n개의 공책 중, 해당 책 이름에 포함되는 경우
     *  - 이전 글자들이 해당 책에 포함되어 있는 경우 가격 측정 x
     *  - 이전 글자들이 해당 책에 포함되어 있지 않은 경우 가격 +
     * 2. n번째 글자까지 탐색하여, 모든 글자가 포함되어 있는 경우 가격 계산
     *
     */
    static boolean[] visited;
    static int[][] bookCharCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        n = Integer.parseInt(br.readLine());
        prices = new int[n];
        wordL = word.length();
        visited = new boolean[n];
        bookCharCount = new int[n][26];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            prices[i] = Integer.parseInt(split[0]);
            for (char c : split[1].toCharArray()) {
                bookCharCount[i][c-'A']++;
            }
        }

        dfs(0,0,0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static int dfs(int depth, int price, int count){
        if (depth == wordL){
            if (count == depth)
                return price;
            else
                return Integer.MAX_VALUE;
        }

        int c = word.charAt(depth) - 'A';
        for (int i = 0; i < n; i++) {
            if (bookCharCount[i][c] > 0){
                bookCharCount[i][c]--;
                if (visited[i]) {
                    min = Math.min(min, dfs(depth+1,price, count+1));
                } else{
                    visited[i] = true;
                    min = Math.min(min, dfs(depth+1,price + prices[i], count+1));
                    visited[i] = false;
                }
                bookCharCount[i][c]++;
            }
        }

        return min;
    }
}