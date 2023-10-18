import java.util.Stack;
import java.util.Arrays;

class Solution {
    /*
        x,y에 대해, 겹치는 구간이 나오는 경우, 
        두 직사각형에 대해 다음을 반복
        
        1. 해당 좌표를 기준으로 상하좌우 탐색
        2. 좌표가 두 직사각형에 모두 포함된 경우, 지나온 좌표의 경우 제외
        3. 포함되지 않은 좌표인 경우, dfs탐색 진행.
    */
    boolean[][] visited;
    int[][] xy = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int ix, iy, answer;
    int[][] rect; 
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        visited = new boolean[51][51];
        ix = itemX;
        iy = itemY;
        
        Stack<int[]> stack = new Stack();
        answer = Integer.MAX_VALUE;
        rect = rectangle;
        
        dfs(characterX, characterY, 0);
        // queue 원소 = {x좌표, y좌표, 이동 거리}
//         stack.push(new int[]{characterX, characterY, 0});
        
//         while (!stack.isEmpty()){
//             int[] pos = stack.pop();
            
//             if (pos[0] == itemX && pos[1] == itemY){
//                 answer = Math.min(answer, pos[2]);
//                 continue;
//             }
            
//             visited[pos[0]][pos[1]] = true;
            
//             for (int i = 0; i<4; i++){
//                 int nx = pos[0] + xy[i][0];
//                 int ny = pos[1] + xy[i][1];
                
//                 if (!(isOutBound(nx, ny) || visited[nx][ny] 
//                       || inboundRectangle(rectangle, nx, ny))){                    
//                     for (int[] r : rectangle){
//                         if (isInLine(r, nx, ny) && isInLine(r, pos[0], pos[1])){
//                             stack.push(new int[]{nx, ny, pos[2]+1});
//                         }
//                     }
//                 }
//             }            
//         }        
        return answer;
    }
    
    public void dfs(int x, int y, int depth){
        if (x == ix && y == iy){
            answer = Math.min(answer, depth);
            return;
        }
        
        visited[x][y] = true;

        for (int i = 0; i<4; i++){
            int nx = x + xy[i][0];
            int ny = y + xy[i][1];

            if (!(isOutBound(nx, ny) || visited[nx][ny] 
                  || inboundRectangle(rect, nx - xy[i][0]*0.1, ny- xy[i][1]*0.1))){
                for (int[] r : rect){
                    if (isInLine(r, nx, ny) && isInLine(r, x, y)){
                        dfs(nx, ny, depth+1);
                    }
                }
            }
        }            
        
    }
    
    public boolean isInLine(int[] r, int x, int y){
        if (((r[0] <= x && x <= r[2]) && (y == r[1] || y == r[3]))
               || ((r[1] <= y && y <= r[3]) && (x == r[0] || x == r[2])))
            return true;
        else
            return false;
    }
    
    public boolean inboundRectangle(int[][] rectangle, double x, double y){
        for (int[] r : rectangle){
            if (isInbound(r, x, y)){                
                return true;
            }
        }
        return false;
    }
    
    public boolean isInbound(int[] r, double x, double y){
        if ((r[0] < x && x < r[2]) && (r[1] < y && y < r[3]))
            return true;
        else
            return false;
    }
    
    public boolean isOutBound(int x, int y){
        if (x < 0 || y < 0 || x > 50 || y > 50)
            return true;
        else
            return false;
    }
}