import java.util.ArrayList;
class Solution {
    int[] one = {1,2,3,4,5};
    int[] two = {2,1,2,3,2,4,2,5};
    int[] thr = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int oneC = 0, twoC = 0, thrC = 0;
        
        for (int i = 0; i<answers.length; i++){
            if (one[i%5]==answers[i])
                oneC++;
            if (two[i%8]==answers[i])
                twoC++;
            if (thr[i%10]==answers[i])
                thrC++;
        }
        int maxV = Math.max(oneC, Math.max(twoC, thrC));
        ArrayList<Integer> result = new ArrayList<>();
        if (oneC == maxV)
            result.add(1);
        if (twoC == maxV)
            result.add(2);
        if (thrC == maxV)
            result.add(3);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}