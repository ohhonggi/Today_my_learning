import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

class Solution {
    /*
        1. 임의의 항공에서, 다른 항공으로 갈 수 있는 방법 저장 (항공권 존재 여부)
        2. dfs탐색 후 모든 티켓을 사용한 경우의 수 저장
    */
    LinkedList<String> result;
    public String[] solution(String[][] tickets) {
        HashMap<String, LinkedList<String>> road = new HashMap(10000);
        
        for (String[] t : tickets){
            if (road.containsKey(t[0])){
                road.get(t[0]).add(t[1]);
            } else {
                LinkedList<String> r = new LinkedList();
                r.add(t[1]);
                road.put(t[0], r);
            }
        }
        
        dfs(road, new LinkedList(List.of("ICN")), "ICN");
        return result.toArray(new String[result.size()]);
    }
    
    public void dfs(HashMap<String, LinkedList<String>> road, LinkedList<String> r, String airport){
        if (!road.containsKey(airport)){
            if (road.isEmpty()){
                if (result == null){
                    result = new LinkedList(r);
                } else {
                    int rl = r.size();
                    for (int i = 0; i<rl; i++){
                        int compare = result.get(i).compareTo(r.get(i));
                        if (compare == 0){
                            continue;
                        } else if (compare > 0){
                            result = new LinkedList(r);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            return;
        }
        
        LinkedList<String> ticket = road.get(airport);
        int tl = ticket.size();
        
        if (tl == 1){
            String t = ticket.remove();
            r.add(t);
            road.remove(airport);

            dfs(road, r, t);

            ticket.add(t);
            r.remove(r.size()-1);
            road.put(airport, ticket);
            
        } else {
            for (int i = 0; i<tl; i++){
                String t = ticket.remove(i);
                r.add(t);
                dfs(road, r, t);
                
                ticket.add(i, t);
                r.remove(r.size()-1);
            }
        }
        
    }
    
}