import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        calSequence(0, 0, "");
    }

    private static void calSequence(int index, int bit, String print){
        if (index == m){
            System.out.println(print);
        }

        for (int i = 1; i <= n; i++) {
            if ((bit & (1 << i)) == 0){
                calSequence(index+1, bit | (1 << i), print+i+" ");
            }
        }
    }
}