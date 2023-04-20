import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        Map<String, Integer> pt = new HashMap<String, Integer>();
        
        for (String p : participant)
            pt.put(p, pt.getOrDefault(p, 0) + 1);
                
        for (String c : completion)
            pt.put(c, pt.get(c) - 1);
        
        for (String p : pt.keySet())
            if (pt.get(p) != 0)
                answer = p;
        
        return answer;
    }
}