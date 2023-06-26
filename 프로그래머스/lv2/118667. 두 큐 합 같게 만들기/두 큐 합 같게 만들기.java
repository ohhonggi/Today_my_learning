import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

class Solution {
    int qL;
    Long goal;
    public int solution(int[] queue1, int[] queue2) {
        /*
            1. 두 큐의 합을 구해, 목표값을 구합니다.
            2. 각 큐의 합이 목표값이 될 때 까지 반복
            3. 두 과정을 반복, 합이 같으면 종료
        */
        Long q1s = 0L, q2s = 0L;
        qL = queue1.length;
        Queue<Long> q1 = new LinkedList<Long>();
        Queue<Long> q2 = new LinkedList<Long>();
        
        for (int i = 0; i<qL; i++){
            q1s += (long) queue1[i];
            q1.add((long) queue1[i]);
            q2s += (long) queue2[i];
            q2.add((long) queue2[i]);
        }

        if ((q1s + q2s) % 2 == 1)
            return -1;
        else
            goal = (q1s + q2s)/2;
        
        return calculateCount(q1, q2, q1s, q2s);
    }
    
    public int calculateCount(Queue<Long> q1, Queue<Long> q2, Long q1s, Long q2s){
        int count = 0;
        
        while (true){
            if (count == qL*4){
                return -1;
            } else {
                if (q1s > q2s || q2.isEmpty()){
                    Long e = q1.poll();
                    q2.add(e);
                    q1s -= e;
                    q2s += e;
                } else if (q1s < q2s || q1.isEmpty()){
                    Long e = q2.poll();
                    q1.add(e);
                    q2s -= e;
                    q1s += e;
                } else {
                    return count;
                }
                count++;
            }
        }
    }
        
}