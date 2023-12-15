import java.util.Arrays;
class Solution {
    int sl;
    int[] st;
    int[] dp;
    public int solution(int sticker[]) {
        sl = sticker.length;
        int answer = 0;
        
        if (sl < 4){
            for (int i = 0; i<sl; i++){
                answer = Math.max(answer, sticker[i]);
            }
            return answer;
        } else {
            st = sticker;
            dp = new int[sl];
            dp[0] = st[0];
            dp[1] = st[1];
            answer = calMax(sl-2);
            
            dp = new int[sl];
            dp[0] = 0;
            dp[1] = st[1];
            answer = Math.max(answer, calMax(sl-1));
            
            return answer;
        }
    }
    
    public int calMax(int index){
        if (dp[index] != 0  || index == 0){
            return dp[index];
        }
        
        dp[index] = calMax(index-2) + st[index];
        dp[index] = Math.max(dp[index], calMax(index-1));
        if (index >= 3)
            dp[index] = Math.max(dp[index], calMax(index-3)+st[index]);

        return dp[index];
    }
}