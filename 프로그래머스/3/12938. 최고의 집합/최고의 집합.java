import java.util.LinkedList;
import java.util.Collections;

class Solution {
    /*
        합이 s이면서, 곱이 최대가 되는 중복집합(크기 n)
        
        s를 n으로 나눴을 때, 몫에 따라 다음을 반복
        - 나머지가 없는경우, 몫에 값에 해당하는 n을 몫 개수만큼 리스트에 추가 후 종료
        - 나머지가 있는경우, 몫을 리스트에 추가하고 나머지에 대해 1번을 반복
    */
    public int[] solution(int n, int s) {
        if (n > s){
            return new int[]{-1};
        } else {
            int[] result = new int[n];

            while (n>0){
                int share = s/n;
                if (s%n==0){
                    while (n > 0){
                        result[--n] = share;
                    }
                } else {
                    result[--n] = share+1;
                    s -= (share+1);
                }
            }
            return result;            
        }
    }

}