import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<Node>[] graph;
    static boolean[] visited;
    static int maxWeight;
    static int maxDepthIndex;
    static int maxDepth;
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
        Integer a= 1;
        /*
            트리의 각 간선에 가중치가 존재할 때,
            두 노드 사이의 가중치값이
            가장 큰 경우를 트리의 지름이라고 칭한다.
            이 때, 트리의 지름을 구하자.

            n - 노드의 개수 ( 1 ≤ n ≤ 100,000 )
            가중치는 10,000보다 크지 않은 자연수

            1. DFS를 이용하여 트리의 depth와 maxWeight을 구할 수 있다.
            2. 이 과정에서 가장 큰 depth를 통해 트리의 지름에 해당하는
             한 node를 찾을 수 있다.
            3. 해당 node의 num으로 DFS를 수행하여 트리의 지름을 구할 수 있다.

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1Num = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int node2Num = Integer.parseInt(st.nextToken());
                if (node2Num != -1) {
                    int weight = Integer.parseInt(st.nextToken());
                    Node node1 = new Node(node2Num, weight);
                    graph[node1Num].add(node1);
                    Node node2 = new Node(node1Num, weight);
                    graph[node2Num].add(node2);
                }
            }
        }

        DFS(1, 0,1);

        visited = new boolean[n + 1];
        DFS(maxDepthIndex, 0,1);
        System.out.println(maxWeight);
    }

    static void DFS(int index, int w, int depth) {
        visited[index] = true;

        List<Node> lines = graph[index];
        for (int i = 0; i < lines.size(); i++) {
            Node node = lines.get(i);
            if (!visited[node.num]) {
                // 최대 depth && 지름 계산
                if (maxWeight < w + node.weight) {
                    maxDepthIndex = node.num;
                    maxWeight = w + node.weight;
                }
                DFS(node.num,w + node.weight, depth + 1);
            }
        }
    }
}
