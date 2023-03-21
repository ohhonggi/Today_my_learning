import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        /*
            1. 빌려줄 수 있는지 여부
                1-1. 자신의 체육복만 가지고 있는 경우 (x)
                1-1. 여벌 체육복과 자신의 체육복을 도난당하지 않은 경우
                1-2. 여벌 체육복과 자신의 체육복을 도난한 경우 (x)
        */
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복 존재, 자신의 체육복을 도난한 경우 (x)
        for (int i = 0; i<reserve.length; i++){
            for (int j = 0; j<lost.length; j++){
                if (reserve[i] == lost[j]){
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        
        for (int i = 0; i<lost.length; i++){
            for (int j = 0; j<reserve.length; j++){                
                if ( Math.abs(lost[i] - reserve[j]) == 1){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}