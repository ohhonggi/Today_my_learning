class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        char[] nums = {'4', '1', '2'};

        while (n >= 1){
            sb.append(nums[n%3]);
            n = (n-1)/3;
        }
        return sb.reverse().toString();
    }
    
}