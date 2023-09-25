import java.util.LinkedList;
class Solution {
    /*
        1. 현재 우선순위가 가장 높은 기능이 개발완료까지의 날짜 체크
        2. 해당 날짜를 기준으로 완료된 기능 체크 
    */
    int pl;
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> result = new LinkedList();
        int order = 0;
        pl = progresses.length;
        for (int d = 1; order < pl; d++){
            if (progresses[order] + speeds[order] * d >= 100){
                int completed = 0;
                do {
                    completed++;
                    order++;
                }
                while (order < pl && progresses[order] + speeds[order] * d >= 100);
                
                result.add(completed);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}