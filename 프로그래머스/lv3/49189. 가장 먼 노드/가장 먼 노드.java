// import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {    
    /*
        1. 각 node에 대한 간선정보 저장
        2. 1번 Node를 stack에 넣고, 다음 과정을 반복
        3. stack의 top을 제거하고, top과 연결된 node중 방문하지 않은 노드를 stack에 push
        4. stack이 비어있지 않은 경우, 3번으로 돌아가 반복
        5. 전체 탐색이 끝난 경우, 
    */
    class Edge{
        int dst;
        int cost;
        
        public Edge(int d, int c){
            dst = d;
            cost = c;
        }
    }
    int[] distance;
    LinkedList<Integer>[] edges;
    public int solution(int n, int[][] edge) {
        distance = new int[n+1];
        edges = new LinkedList[n+1];
        for (int i = 1; i<=n; i++){
            edges[i] = new LinkedList();
        }
        
        for (int[] e : edge){
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        
        bfs(n);
        
        Arrays.sort(distance);
        int max = distance[n];
        int result = 1;
        for (int i = n-1; i>=1; i--){
            if (max == distance[i]){
                result++;
            }
        }
        
        return result;
    }
   
    
    public void bfs(int n){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(
            (a,b) -> a.cost-b.cost);
        queue.add(new Edge(1, 0));
        
        while (!queue.isEmpty()){
            Edge e = queue.remove();
            if (!visited[e.dst]){
                visited[e.dst] = true;
                distance[e.dst] = e.cost;
                for (int node : edges[e.dst]){
                    if (!visited[node]){
                        queue.add(new Edge(node, e.cost+1));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}