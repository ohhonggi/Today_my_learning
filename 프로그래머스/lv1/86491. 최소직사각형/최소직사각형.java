import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int sizesL = sizes.length;
        int maxW = 0, maxH = 0;
        for (int i = 0; i<sizesL; i++){
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        int w = 0, h = 0;
        for (int i = 0; i<sizesL; i++){
            if (sizes[i][0] < sizes[i][1] && maxW >= sizes[i][1] && maxH > sizes[i][0])
                h = Math.max(h, sizes[i][0]);
            else
                h = Math.max(h, sizes[i][1]);
        }
        answer = maxW * h;
        
        for (int i = 0; i<sizesL; i++){
            if (sizes[i][0] > sizes[i][1] && maxH >= sizes[i][0] && maxW > sizes[i][1])
                w = Math.max(w, sizes[i][1]);
            else
                w = Math.max(w, sizes[i][0]);
        }
        answer = Math.min(answer, w * maxH);
        
        return answer;
    }
}