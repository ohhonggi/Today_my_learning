import java.util.Arrays;

class Solution {
    /*
        심사관마다 심사시간이 다름.
        모든 사람이 심사를 받는데 걸리는 최소시간 구하기
        심사대가 비어있는 경우, 바로 심사를 받을 수 있음 (소요시간 x)
        
        1 <= n <= 10^9
        1 <= t <= 10^9
        1 <= table <= 10^6
        long으로 해결 가능 (10^18 < 2^64)
        
    */
    public long solution(int n, int[] times) {
        long result = Long.MAX_VALUE;
        long num = 0;
        
        Arrays.sort(times);

        long start = times[0];
        long end = (long) times[times.length-1]*(long) n;
        long mid;
        
        while (start <= end){
            num = 0;
            mid = (start+end)/2;
            
            for (int t : times){
                num += mid/t;
            }
            
            if (num >= n){
                result = Math.min(result, mid);
                end = mid-1;
            } else {
                start = mid+1;
            }
            
        }
        
        return result;
    }
}