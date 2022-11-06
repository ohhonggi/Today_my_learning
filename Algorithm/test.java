package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class test {
    static List<Node>[] graph;
    static boolean[] visited;

    static class Node{
        private int num;
        private int weight;

        public Node(int num, int weight) {
            super();
            this.num = num;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        visited = new boolean[n + 1];


    }
}
