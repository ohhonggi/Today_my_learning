import java.util.*;

class Solution {
    boolean[][] isVisited;
    int rl,cl;
    int[][] drdc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int min = Integer.MAX_VALUE;
    Queue<int []> child = new LinkedList();
    
    public int solution(int[][] maps) {
        rl = maps.length;
        cl = maps[0].length;
        isVisited = new boolean[rl][cl];
        
        for (int i = 0; i< rl; i++){
            for (int j = 0; j<cl; j++){
                if (maps[i][j] != 1)
                    isVisited[i][j] = true;
            }
        }
        
        int result = bfs(0,0,0);
        
        if (min != Integer.MAX_VALUE)
            return result;
        else
            return -1;
    }

    public int bfs(int rowI, int columnI, int depth){
        child.add(new int[]{0,0,1});
        
        while(!child.isEmpty()){
            int[] c = child.remove();
            if (isVisited[c[0]][c[1]]){
                continue;
            }else {
                // System.out.println("row: "+ c[0] + " column: "+ c[1]);
                // System.out.println("depth: "+ c[2]);
                
                if (c[0] == rl-1 && c[1] == cl-1){
                    min = Math.min(min, c[2]);
                    continue;
                }
                
                isVisited[c[0]][c[1]] = true;
                for (int[] direction : drdc) {
                    rowI = c[0] + direction[0];
                    columnI = c[1] + direction[1];
                    if (checkIndex(rowI, columnI)){
                        child.add(new int[]{rowI, columnI, c[2] + 1});
                    }
                }
            }
        }
        
        return min;
    }
    
//     public int dfs(int rowI, int columnI, int depth){
//         if (isVisited[rowI][columnI])
//             return -1;
//         else if (rowI == rl-1 && columnI == cl-1){
//             min = Math.min(depth+1, min);
//             return min;
//         }
        
//         // System.out.println("row: "+ rowI + " column: "+ columnI);
//         // System.out.println("depth: "+ depth);
        
//         int result = -1;
//         isVisited[rowI][columnI] = true;
//         for (int[] move : drdc){
            
//             if (!checkIndex(rowI+ move[0], columnI+ move[1]))
//                 continue;
            
//             result = dfs(rowI + move[0], columnI + move[1], depth+1);
//             if (result != -1){
//                 min = Math.min(min, result);
//             }
//         }
//         isVisited[rowI][columnI] = false;
        
//         return min;
//     }
    
    public boolean checkIndex(int rowI, int columnI){
        if (rowI < 0 || rowI >=rl || columnI < 0 || columnI >= cl)
            return false;
        else
            return true;
    }
}