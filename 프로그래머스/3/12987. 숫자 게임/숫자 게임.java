import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    /*
        최소 비기거나, 이기는 수를 구해야 함.
        
        list 변환 후, bs를 통해 현재 A팀의 숫자보다 최소로 큰 수 찾기 (없을 경우, 맨 앞 원소 배정)
        
    */
    List<Integer> blist;
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        blist = Arrays.stream(B).boxed().collect(Collectors.toList());
        int answer = 0;
        for (int a : A){
            answer += bs(a);
        }
        return answer;
    }
    
    public int bs(int n1){
        int left = 0;
        int bsize = blist.size();
        int right = bsize-1;
        
        while (left <= right){
            int mid = (left+right)/2;
            int midn = blist.get(mid);
            if (n1 < midn){
                right = mid-1;
            } else if (n1 > midn){
                left = mid+1;
            } else {
                left = mid;
                break;
            }
        }
        
        int index = left == bsize ? bsize-1 : left;
                
        if (blist.get(index) > n1){
            blist.remove(index);
            return 1;
        } else if (blist.get(index) == n1) {
            for (int i = index; i<bsize; i++){
                if (blist.get(i) > n1){
                    index = i;
                    break;
                } else if (i == bsize-1){
                    blist.remove(index);
                    return 0;
                }
            }
            blist.remove(index);
            return 1;
        } else {
            blist.remove(index);
            return 0;
        }
    }
}
