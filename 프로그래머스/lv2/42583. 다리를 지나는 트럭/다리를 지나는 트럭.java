import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
            모든 트럭은 다리 길이만큼 건너야 한다는 것 = 다리에 올라갈 수 있는 트럭의 최대 개수

            1. 다리에 트럭이 올라갈 수 없는 경우
                - 다리에 올라갈 수 있는 트럭의 개수가 최대
                - 다음 트럭이 올라탈 경우 다리의 무게가 견디지 못하는 경우
                = 다리에 올라간 트럭 중 맨 앞 트럭을 삭제 및 건너는 시간 감소
            2. 다리에 트럭이 올라갈 수 있는 경우 (위 조건과 반대)
                - 대기 트럭의 첫 번째 트럭을 queue에 삽입 ()
        */
        int answer = 1;
        ArrayDeque<Integer> bg = new ArrayDeque<Integer>();
        int bgW = truck_weights[0], index = 1, twL = truck_weights.length;
        int[] times = new int[twL];
        Arrays.fill(times, bridge_length+1);
        bg.add(0);
        times[0]--;
        // printAll(bg, truck_weights,times, answer, bgW, index);
        
        while(index < twL){
            if (bg.size() == bridge_length || 
                (bgW + truck_weights[index] > weight)){
                int firstTruckI = bg.remove();
                int time = times[firstTruckI];
                
                for (int i = firstTruckI; i< index; i++){
                    times[i] -= time;
                }
                bgW -= truck_weights[firstTruckI];
                
                if (bgW + truck_weights[index] <= weight){
                    bg.add(index);
                    times[index]--;
                    bgW += truck_weights[index++];
                }
                answer+= time;
                
            } else {
                bg.add(index);
                bgW += truck_weights[index++];
                
                for (int i = bg.getFirst(); i<index; i++){
                    times[i]--;
                }
                
                if (times[bg.getFirst()] == 0){
                    bgW -= truck_weights[bg.remove()];
                }
                answer++;
            }
            // printAll(bg, truck_weights,times, answer, bgW, index);
            
        }
        
        while (!bg.isEmpty()){
            int firstTI = bg.remove();
            int time = times[firstTI];
            
            for (int i = firstTI; i<twL; i++)
                times[i] -= time;
            answer += time;
            // printAll(bg, truck_weights,times, answer, bgW, firstTI);

        }
        // printAll(bg, truck_weights,times, answer, bgW, index);

        return answer;
    }
    
    public static void printAll(ArrayDeque<Integer> a, int[] truck_weights, int[] time, int as, int bgW, int index){
        System.out.print("bridge trucks :");
        if (!a.isEmpty()){
            for (Object tk : Arrays.asList(a.toArray())){
                System.out.print(truck_weights[(int)tk] +" ");
            }
        }
        System.out.println();
        System.out.print("times :");
        for (int i = 0; i< time.length; i++){
            System.out.print(time[i] +" ");
        }
        System.out.println(as);
        System.out.println("bgW: " + bgW);
        System.out.println("index: " + index);
    }
    
}