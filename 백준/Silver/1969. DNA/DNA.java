import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] dna = new String[n];
        char[] material = {'A', 'C', 'G', 'T'};
        int distance = 0,
            minCount, curCount;
        char curChar = 0;

        String result="";

        for (int i = 0; i < n; i++) {
            dna[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            minCount = Integer.MAX_VALUE;
            for (int j = 0; j < material.length; j++) {
                curCount = 0;
                for (int k = 0; k < n; k++) {
                    if (material[j] != dna[k].charAt(i)){
                        curCount++;
                    }
                }
                if (minCount > curCount){
                    minCount = curCount;
                    curChar = material[j];
                }
            }
            distance += minCount;
            result += curChar;
        }
        System.out.println(result + "\n" + distance);
    }
}