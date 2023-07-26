import java.util.HashSet;

class Solution {
    
    /*
        사람들의 질문사항을 보니 이 문제는 체점 관련하여 전역변수를 solution 안에서
        모두 초기화해야 한다는 에로사항이 있네요..!
    */

    int[][] xy = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};;
    int rowL, colL, max;
    boolean[][] visited;
    int[][] p;
    public int[] solution(int m, int n, int[][] picture) {
        rowL = m;
        colL = n;
        max = 0;
        visited = new boolean[m][n];
        p = picture;
        int areaCount = 0;
                
        for (int i = 0; i<rowL; i++){
            for (int j = 0; j<colL; j++){
                if (!visited[i][j] && p[i][j] > 0){
                    max = Math.max(dfs(i,j,p[i][j]), max);
                    areaCount++;
                }
            }
        }
                
        return new int[]{areaCount, max};
    }
    
    public int dfs(int m, int n, int type){
        if (m < 0 || n < 0 || m == rowL || n == colL || type != p[m][n]){
            return 0;
        }
        
        int area = 0;
        if (!visited[m][n]){
            visited[m][n] = true;
            area++;
            for (int i = 0; i<4; i++){
                area += dfs(m + xy[i][0], n + xy[i][1], type);
            }
        }
        return area;
    }
}