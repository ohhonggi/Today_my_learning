import java.util.HashSet;

class Solution {
    
    int[][] xy;
    int rowL, colL, max;
    boolean[][] visited;
    int[][] p;
    int[] answer;
    public int[] solution(int m, int n, int[][] picture) {
        xy = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        rowL = m;
        colL = n;
        max = 0;
        visited = new boolean[m][n];
        p = new int[m][n];
        answer = new int[2];
        
        for (int i = 0; i<rowL; i++){
            for (int j = 0; j<colL; j++){
                p[i][j] = picture[i][j];
            }
        }
        
        
        for (int i = 0; i<rowL; i++){
            for (int j = 0; j<colL; j++){
                if (!visited[i][j] && p[i][j] > 0){
                    max = Math.max(dfs(i,j,p[i][j]), max);
                    answer[0]++;
                }
            }
        }
                
        answer[1] = max;
        return answer;
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