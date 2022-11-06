import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[] dist;
    static int length;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node implements Comparable<Node>{
        private int to;
        private int distance; 

        public Node(int to, int weight) {
            this.to = to;
            this.distance = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    /*
     * 최단 경로 알고리즘 -> 하나의 정점에서 다른 정점으로 가는 최단 경로
     *
     * 1. 출발 노드 설정
     * 2. 출발 노드를 기준으로 각 노드의 최소 비용 저장
     * 3. 방문하지 않은 노드 중 가장 비용이 적은 노드 선택
     * 4. 해당 노드를 거쳐 특정 노드로 가는 경우를 고려하여 최소 비용 갱신
     * 5. 3~4 반복.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        length = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dist = new int[length + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));    // graph의 distance는 다음 정점과의 간선 정보
        }

        dijkstra(start);
        for (int i = 1; i < length + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF \n");
            } else {
                sb.append(dist[i] +" \n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.add(new Node(start, dist[start]));   // queue에 들어가는 node는 시작점부터 그 정점까지의 최단거리

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curto = cur.to;
            int curd = cur.distance;    // to까지의 최단 거리

            if (curd > dist[curto]) continue;   // 이미 최단거리인 경우

            // 현재 노드의 child 노드와 연결된 node들의 최단 거리 갱신
            for (Node child : graph.get(curto)) {
                int childTo = child.to;         // child와 연결된 node
                int childDis = child.distance;

                // 각 노드들의 최단 거리 갱신
                if (cur.distance + childDis < dist[childTo]) {
                    dist[childTo] = cur.distance + childDis;
                    pq.add(new Node(childTo, dist[childTo]));
                }

            }
        }
    }
}