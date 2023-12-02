import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {    

    public long solution(int n, int[] works) {
        int wl = works.length;
        Arrays.sort(works);
        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        
        for (int i : works){
            queue.add(i);
        }
        
        while (n > 0 && !queue.isEmpty()){
            int num = queue.remove();
            n--;
            if (num-1 > 0)
                queue.add(num-1);
        }
        
        long answer = 0;
        for (int num : queue){
            answer += (num * num); 
        }
        
        return answer;
    }
}