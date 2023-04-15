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
    static int[] wordChars;
    static int[][] bookChars;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        n = Integer.parseInt(br.readLine());
        prices = new int[n];
        wordL = word.length();
        wordChars = new int[26];
        bookChars = new int[n][26];

        for (char c : word.toCharArray()) {
            wordChars[c-'A']++;
        }
        
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            prices[i] = Integer.parseInt(split[0]);
            for (char c : split[1].toCharArray()) {
                bookChars[i][c-'A']++;
            }
        }

        dfs(-1,0,0);
        System.out.println( min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int depth, int price, int count){
        if (count == wordL){
            min = Math.min(min, price);
            return;
        }
        if (depth == n)
            return;

        for (int i = depth+1; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (wordChars[j] > 0 && bookChars[i][j] > 0){
                    if (wordChars[j] >= bookChars[i][j]){
                        cnt += bookChars[i][j];
                    } else {
                        cnt += wordChars[j];
                    }
                }
                wordChars[j] -= bookChars[i][j];
            }
            dfs(i, price + prices[i], count + cnt);
            for (int j = 0; j<26; j++){
                wordChars[j] += bookChars[i][j];
            }
        }
    }
}