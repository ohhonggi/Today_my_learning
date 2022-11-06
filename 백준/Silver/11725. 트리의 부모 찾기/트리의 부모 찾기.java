import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static Integer[] parents;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /*
            루트 없는 트리가 주어지고, 루트가 1일때 각 노드의 부모를 구하는 프로그램

            n - 노드의 개수 ( 2 ≤ n ≤ 100,000 )

            1. BFS를 통해 각 노드의 부모를 구하기.

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        parents = new Integer[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to].add(from);
            graph[from].add(to);
        }
        BFS();
        for (int i = 2; i <= parents.length-1; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
    }

    static void BFS() {
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            List<Integer> child = graph[node];

            for (int i = 0; i < child.size(); i++) {
                Integer ch = child.get(i);
                if (!visited[ch]) {
                    visited[ch] = true;
                    parents[ch] = node;

                    queue.add(ch);
                }
            }
        }
    }
}