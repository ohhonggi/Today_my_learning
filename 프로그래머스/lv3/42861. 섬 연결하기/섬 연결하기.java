import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution {
    /*
        임의의 정점부터, 다른 모든 정점까지의 최소 비용을 구해야함
        Union-find 적용
        -> costs의 각 정점간 비용 정보를 정리하는 과정에서, 트리 형식 구축
        
        (costs의 i번째 원소의 정보를 정점 A와 정점 B 사이의 비용 C를 A->B=C라 정의)
        1. B의 부모로 A를 정의하며, A->B=C로 정의
            1) B의 부모가 이미 존재하는 경우 (A`->B=C`)
            -> C`과 C를 비교하여 더 작은 비용의 부모를 설정
        2. costs의 전체 내용을 저장
        3. parent가 null인 정점을 루트로 하여, 모든 정점까지의 비용 합산
        -> 가장 적은 비용으로 통행 가능
    */
    
    
    // int[] parent;
    // HashMap<Integer,Integer>[] child;
    class Path{
        int dst;
        int cost;
        
        public Path(int d, int c){
            this.dst = d;
            this.cost = c;
        }
    }
    
    LinkedList<Path>[] paths;
    public int solution(int n, int[][] costs) {
        // parent = new int[n];
        // child = new HashMap[n];
        paths = new LinkedList[n];
        
        for (int i = 0; i<n; i++){
            // child[i] = new HashMap<>(100);
            // child[i].put(i, 0);
            // parent[i] = i;
            paths[i] = new LinkedList<>();
        }
        
        for (int i = 0; i<costs.length; i++){
            paths[costs[i][0]].add(new Path(costs[i][1], costs[i][2]));
            paths[costs[i][1]].add(new Path(costs[i][0], costs[i][2]));
            // union(costs[i][0], costs[i][1], costs[i][2]);
        }
                
        // int root = 0;
        // for (int i = 0; i<n; i++){
        //     if (parent[i] == i){
        //         root = i;
        //         break;
        //     }
        // }
        // System.out.println(Arrays.toString(parent));
        // System.out.println("root: " + root + "\n"+child[root]);
        // return buildPath(root);
        return dijkstra();
    }
    public int dijkstra(){
        PriorityQueue<Path> queue = 
            new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        int result = 0;
        boolean[] visited = new boolean[paths.length];
        visited[0] = true;
        queue.addAll(paths[0]);
        
        while(!queue.isEmpty()){
            Path p = queue.remove();
            if (!visited[p.dst]){
                visited[p.dst] = true;
                result += p.cost;
                
                for (Path path : paths[p.dst]){
                    if (!visited[path.dst]){
                        queue.add(path);
                    }
                }
            }
        }
        
        return result;
    }
    
//     public void union(int a, int b, int cost){
//         int ap = find(a);
//         int bp = find(b);
        
//         int aCost = child[ap].get(a);
//         int bCost = child[bp].get(b);
        
//         if (ap == bp){
//             if (aCost + cost <= bCost){
//                 child[ap].put(b, cost);
//             } else if (bCost + cost <= aCost){
//                 child[bp].put(a, cost);
//             }
//         } else {
//             parent[bp] = ap;
//             child[ap].putAll(child[bp]);
//             child[ap].put(bp, cost);
//         }
//     }
    
//     public int find(int index){
//         if (index == parent[index]){
//             return index;
//         }
//         return parent[index] = find(parent[index]);
//     }
    
//     public int buildPath(int index){
//         int result = 0;
//         HashMap<Integer,Integer> ch = child[index];
//         for (Entry<Integer,Integer> c : ch.entrySet()){
//             result += c.getValue();
//         }
//         return result;
//     }
    
}