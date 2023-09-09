import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n,m;
    static int[] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        data = new int[m];

        calSequence(0, 0);
        System.out.println(sb);
    }

    private static void calSequence(int index, int bit){
        if (index == m){
            for (int i = 0; i < m; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if ((bit & (1 << i)) == 0){
                data[index] = i;
                calSequence(index+1, bit | (1 << i));
            }
        }
    }
}