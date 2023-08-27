import java.util.ArrayList;
class Solution {
    /*
        dp[트리의 높이][원소의 위치]
        높이 h에 해당하는 경로 중, 거쳐간 숫자의 합이 가장 큰 값 구하기
        dp[h][i] = Math.max(dp[h-1][i-1],dp[h-1][i+1]) + triangle[h][i]
    */
    
    // ArrayList<Integer>[] dp;
    int[][] dp;
    int height;
    public int solution(int[][] triangle) {
        height = triangle.length;
        // dp = new ArrayList[height];
        dp = new int[height][height];
        
        // for(int i = 0; i<height; i++){
        //     dp[i] = new ArrayList<>(i+1);
        // }
        
        // dp[0].add(triangle[0][0]);        
        dp[0][0] = triangle[0][0];        
        for (int i = 1; i<height; i++){
            for (int j = 0; j<=i; j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    // dp[i].add(dp[i-1].get(j) + triangle[i][j]);
                } else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    // dp[i].add(dp[i-1].get(j-1) + triangle[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                    // dp[i].add(Math.max(dp[i-1].get(j-1), dp[i-1].get(j)) + triangle[i][j]);
                }
            }
        }
        int answer = 0;
        // for (int i : dp[height-1]){
        //     answer = Math.max(answer, i);
        // }
        for (int i = 0; i<height; i++){
            answer = Math.max(answer, dp[height-1][i]);
        }
        return answer;
    }
}