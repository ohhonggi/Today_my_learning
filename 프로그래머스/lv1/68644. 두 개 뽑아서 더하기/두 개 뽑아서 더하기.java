import java.util.HashSet;
import java.util.Arrays;

class Solution {
    // 순열
    int n;
    HashSet<Integer> nums;
    public int[] solution(int[] numbers) {
        n = numbers.length;
        nums = new HashSet<Integer>();
        permutation(numbers);
        int[] answer = nums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    public void permutation(int[] numbers){
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (i != j){
                    nums.add(numbers[i] + numbers[j]);
                }
            }
        }
    }
}