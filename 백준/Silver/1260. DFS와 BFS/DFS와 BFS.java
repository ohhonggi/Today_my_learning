import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static ArrayList<List<Integer>> graph;
    static boolean[] visited;
    static Queue<List<Integer>> queue;
    public static void main(String[] args) throws IOException {
        /*
            BFS와 DFS 구현하기

            n - 정점의 개수      (1 ≤ N ≤ 1,000)
            m - 간선의 개수      (1 ≤ M ≤ 10,000)
            V - 시작 정점 번호

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        queue = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>()) ;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        DFS(v);
        Arrays.fill(visited, false);
        System.out.println();
        BFS(v);
    }

    static void DFS(int index) {
        visited[index] = true;
        System.out.print(index + " ");

        List<Integer> lines = graph.get(index);
        for (int i = 0; i < lines.size(); i++) {
            int node = lines.get(i);
            if (!visited[node]) DFS(node);
        }
    }

    static void BFS(int index) {
        visited[index] = true;
        System.out.print(index + " ");

        queue.add(graph.get(index));

        while (!queue.isEmpty()) {
            List<Integer> nodes = queue.remove();

            for (int i = 0; i < nodes.size(); i++) {
                Integer node = nodes.get(i);
                if (!visited[node]) {
                    visited[node] = true;
                    System.out.print(node + " ");
                    queue.add(graph.get(node));
                }
            }
        }
    }
}
