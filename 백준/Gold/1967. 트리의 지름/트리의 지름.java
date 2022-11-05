import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<int[]>[] graph;
    static boolean[] visited;
    static int maxWeight;
    public static void main(String[] args) throws IOException {
        /*
            트리의 각 간선에 가중치가 존재할 때,
            두 노드 사이의 가중치값이
            가장 큰 경우를 트리의 지름이라고 칭한다.
            이 때, 트리의 지름을 구하자.

            n - 노드의 개수 ( 1 ≤ n ≤ 10,000 )
            루트노드는 항상 1, 가중치는 100보다 크지 않은 정수

            1. DFS를 이용하여 루트 노드로부터 리프 노드까지의 가중치의 합을
            구할 수 있다.
            2. 1~n까지 모든 노드에 대해 DFS를 진행하게 되면, 트리의 지름을
            구할 수 있다.
            -> 루트 노드는 어떤 노드든 가능할 수 있다는 것을 깨닫기.

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
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[node1].add(new int[]{node2, weight});
            graph[node2].add(new int[]{node1, weight});
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            DFS(i, 0);
        }
        DFS(1,0);

        System.out.println(maxWeight);
    }

    /*
        w - 탐색해오면서 얻은 가중치
        DFS 탐색을 진행하면서 루트로부터 리프노드까지의 가중치의 합을 구해 weight에 저장
     */
    static void DFS(int index, int w) {
        visited[index] = true;

        List<int[]> lines = graph[index];
        for (int i = 0; i < lines.size(); i++) {
            int[] node = lines.get(i);
            if (!visited[node[0]]) {
                // 가중치 계산
                maxWeight = Math.max(maxWeight, w + node[1]);
                DFS(node[0],w + node[1]);
            }
        }
    }
}