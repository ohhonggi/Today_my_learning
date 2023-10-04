import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    /*
        주어진 N을 가지고 만들 수 있는 사칙연산 경우의 수
        1. () + N
        2. NN (N 이어붙이기)
        3. () / N
        4. () - N
        5. () * N
        
        - 현재 depth에서 만들어진 수에 대해, 1부터 depth까지 다음 과정 반복
        1. dp[i][j]가 0이 아닌 수들에 대해, 
        1. depth + i가 8보다 큰 경우 종료
        - 사용한 N의 개수(depth) = dp의 row
        
    */
    int[][] dp;
    int dpL, std, goal;
    LinkedList<Integer>[] list;
    public int solution(int N, int number) {
        list = new LinkedList[9];
        for (int i = 1; i<9; i++){
            list[i] = new LinkedList();
        }
        
        dpL = 32000*10+N;
        dp = new int[9][dpL+1];
        goal = number;
        std = N;
        
        for (int i = 1; i<9 && dp[i][goal] == 0; i++){
            makeNum(N, i);
        }
        
        for (int i = 1; i<9; i++){
            if (dp[i][number]>0){
                return i;
            }
        }
        return -1;
    }
    
    public void nextOperation(int n1, int n2, int depth){
        makeNum(n1+n2, depth);
        makeNum(n1*n2, depth);
        makeNum(n1-n2, depth);
        makeNum(n2-n1, depth);
        makeNum(n1/n2, depth);
        makeNum(n2/n1, depth);
    }
    
    public void makeNum(int n, int depth){
        if (depth > 8 || n < 1 || n > dpL || dp[depth][goal] > 0){
            return;
        }
        
        dp[depth][n]++;
        list[depth].add(n);
        
        for (int i = 1; i<8; i++){
            if (i + depth > 8) {
                break;
            }
            
            for (int j : list[i]){
                nextOperation(n, j, i+depth);
            }
        }
        makeNum(n*10+std, depth+1);
    }
}