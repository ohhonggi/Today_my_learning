import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    /*
        특정 방의 경우 방문하기 전 방문해야 할 방이 존재하며, 이러한 규칙을 모두 지키며 모든 방을
        탐험이 가능한지. (0번 방부터 탐험 시작)
        
        주의사항
        - 먼저 방문해야 할 방이 겹치는 경우는 x
        - 임의의 서로 다른 두 방 사이의 최단경로는 딱 한 가지 -> cycle이 존재하지 않음
        
        1. 각 방마다 연결 가능한 통로 정보, order 정보를 정리하여 저장
        2. 0번방을 queue에 삽입 후 탐사 진행
        3. queue의 head를 제거하여 연결된 방을 탐색
            1) 해당 방이 order에 포함된 방인 경우([A,B]중 A에 속할 때),
            두 방을 연결 짓는 최초 부모를 찾아 queue에 삽입
            2) 해당 방이 order에 포함되지 않는 방(전제조건 x)인 경우, 방문 표시 및 queue 삽입
        4. queue가 빌 때 까지 3번 반복

    */
    LinkedList<Integer>[] paths;
    int[] orderInfo;
    Queue<Integer> queue;
    HashMap<Integer, Integer> findOrder;
    HashSet<Integer> waitRoom;
    int[] degree;
    public boolean solution(int n, int[][] path, int[][] order) {
        paths = new LinkedList[n];
        queue = new LinkedList();
        waitRoom = new HashSet();
        orderInfo = new int[n];
        findOrder = new HashMap<Integer, Integer>();
        degree = new int[n];
        
        // 리스트 초기화
        for (int i = 0; i<n; i++){
            paths[i] = new LinkedList();
        }

        // 각 방마다 연결 가능한 통로 정보 정리
        for (int[] p : path){
            paths[p[0]].add(p[1]);
            paths[p[1]].add(p[0]);
        }
        
        sortDegree();
        
        // order 정보 정리
        for (int[] o : order){
            orderInfo[o[1]] = o[0];
            findOrder.put(o[0], o[1]);
            
            // 0번방을 탐험하기 위해 다른 방을 방문해야하는 조건이 존재하는 경우 -> 탐험 불가
            if (o[1] == 0)
                return false;
        }
        
        exploration(n);
        
        return findOrder.isEmpty();
    }
    
    // 진입차수 정리 (0번 방이 root이므로, 0번 방을 기준으로 depth당 +1)
    public void sortDegree(){
        queue.add(0);
        
        while (!queue.isEmpty()){
            int i = queue.remove();
            LinkedList<Integer> path = paths[i];
            
            for (int p : path){
                if (p != 0 && degree[p] == 0){
                    degree[p] = degree[i] + 1;
                    queue.add(p);
                } 
            }
        }
    }
    
    // 탐사 진행
    public void exploration(int n){
        queue.add(0);
        
        while (!queue.isEmpty()){
            int room = queue.remove();
            
            // 먼저 방문해야할 방이 없는 경우
            if (orderInfo[room] == 0){
                Integer o = findOrder.remove(room);
                
                // 해당 방을 방문함으로써 방문할 수 있는 방이 생기는 경우
                if (o != null){ 
                    orderInfo[o] = 0;
                    if (waitRoom.remove(o)){
                        queue.add(o);
                    }
                    // int commonPath = findCommonPath(o, room);
                    // if (commonPath >= 0)
                    //     queue.add(commonPath);
                }

                LinkedList<Integer> rooms = paths[room];
                for (int r : rooms){
                    if (degree[room] < degree[r]){
                        queue.add(r);
                    }
                }
            } else {
                waitRoom.add(room);
            }
        }
    }
    
    // 4. 두 방을 연결 짓는 방을 찾아 반환
    public int findCommonPath(int p1, int p2){
        int p1C = p1;
        while (p1 != p2) {
            if (orderInfo[p1] != 0){
                return -1;
            }
            if (degree[p1] < degree[p2]){
                LinkedList<Integer> path = paths[p2];
                for (int p : path){
                    if (degree[p2] > degree[p]){
                        p2 = p;
                        break;
                    }
                }
            } else {
                LinkedList<Integer> path = paths[p1];
                for (int p : path){
                    if (degree[p1] > degree[p]){
                        p1C = p1;
                        p1 = p;
                        break;
                    }
                }
            }
        }
        return p1C;
    }
}