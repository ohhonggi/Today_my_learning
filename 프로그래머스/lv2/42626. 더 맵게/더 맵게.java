import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    /*
        1. 정렬하여 PriorityQueue에 삽입
        2. k 스코빌보다 낮은 음식에 대해 mix진행
        3. queue의 head의 원소가 k스코빌보다 같거나 큰 경우 종료
        
    */
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(
            Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        
        while (queue.peek() < K && queue.size() > 1){
            Integer f1 = queue.remove();
            Integer f2 = queue.remove();
            queue.add(f1 + (f2*2));
            answer++;
        }
        if (queue.peek() < K){
            return -1;
        } else{
            return answer;
        }
    }
}
