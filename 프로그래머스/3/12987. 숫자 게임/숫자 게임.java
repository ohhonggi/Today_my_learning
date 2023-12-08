import java.util.Arrays;

class Solution {
    /*
        최소 비기거나, 이기는 수를 구해야 함.
        1. A,B를 정렬
        2. A와 B의 끝 인덱스부터 A와 B 비교 진행
            - B의 원소가 더 큰 경우, 승점을 더하고 B의 비교 인덱스 감소
            - A의 원소가 더 큰 경우, A의 인덱스 감소
        
    */
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        
        for (int i = A.length-1, j = B.length-1; i>=0; i--){
            if (A[i] < B[j]){
                answer++;
                j--;
            }
        }
        return answer;
    }
}
