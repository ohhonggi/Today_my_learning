class Solution {
    boolean[] v;
    public int solution(int n, int[] stations, int w) {
        /*
            아파트의 시작부터 끝까지 다음을 반복
            - 현재 위치에 전파가 도달하지 않은 경우
        */
        // v = new boolean[n+1];
        int answer = 0, sl = stations.length;
        int index = stations[0]-w-1;
        
        while (index >=1){
            index -= (2*w + 1);
            answer++;
        }
        index = stations[0]+w+1;
        
        for (int i = 1; i<sl; i++){
            while (index < stations[i]-w){
                index += (2*w + 1);
                answer++;
            }
            index = stations[i]+w+1;
        }
        
        while (index <= n){
            index += (2*w + 1);
            answer++;
        }

        return answer;
    }
}