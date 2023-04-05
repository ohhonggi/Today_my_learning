import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n, k;
    static String [] numList;
    static Set<String> numSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        numList = new String[n];
        boolean[] visited = new boolean[n];
        numSet = new HashSet();

        for (int i = 0; i < n; i++) {
            numList[i] = sc.next();
        }
        cal(visited,0,"");
        System.out.println(numSet.size());
    }

    public static void cal(boolean[] visited, int depth, String card) {
        if (depth == k) {
            if (!numSet.contains(card)) {
                numSet.add(card);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cal(visited, depth+1, card+numList[i]);
                cal(visited, depth+1, card+numList[i]);
                visited[i] = false;
            }
        }
    }
}