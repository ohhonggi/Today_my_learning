import java.util.HashMap;
import java.util.LinkedList;
class Solution {
    HashMap<String, String> nickname;
    public String[] solution(String[] record) {
        LinkedList<String> print = new LinkedList();
        nickname = new HashMap(record.length);
        for (String r : record){
            String[] input = r.split(" ");
            if (input[0].charAt(0) != 'L'){
                nickname.put(input[1], input[2]);
            }
        }
        
        for (String r : record){
            String[] input = r.split(" ");
            String name = nickname.get(input[1]);
            if (input[0].charAt(0) == 'E'){
                print.add(join(name));
            } else if (input[0].charAt(0) == 'L'){
                print.add(exit(name));
            }
        }
        
        String[] answer = print.toArray(new String[print.size()]);
        
        return answer;
    }
    
    public String join(String n){
        return n+"님이 들어왔습니다.";
    }
    
    public String exit(String n){
        return n+"님이 나갔습니다.";
    }
    
}