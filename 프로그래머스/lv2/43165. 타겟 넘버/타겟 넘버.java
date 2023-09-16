import java.util.Arrays;
class Solution {
    int[] nums;
    int t, result;
    public int solution(int[] numbers, int target) {
        
        result = 0;
        nums = numbers;
        t = target;
        dfs(0, 0);
        return result;
    }
    
    public void dfs(int depth, int number){
        if (depth == nums.length){
            if (number == t){
                result++;
            }
            return;
        }
        
        dfs(depth + 1, number + nums[depth]);
        dfs(depth + 1, number - nums[depth]);
    }
}