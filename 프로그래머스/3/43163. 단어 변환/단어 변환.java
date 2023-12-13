import java.util.Arrays;
class Solution {
    /*
        i번째 글자만 target과 같은 
    */
    String[] wd;
    int cnt, wl, wdl;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        cnt = Integer.MAX_VALUE;
        wl = begin.length();
        wdl = words.length;
        visited = new boolean[wdl];
        
        Arrays.sort(words);
        wd = words;

        bfs(begin.toCharArray(), target.toCharArray(), 0);
        
        return cnt != Integer.MAX_VALUE ? cnt : 0;
    }
    
    public void bfs(char[] b, char[] t, int depth){
        if (Arrays.equals(b,t)){
            cnt = Math.min(cnt, depth);
            return;
        }
        
        for (int i = 0; i<wl; i++){
            for (int j = 0; j<wdl; j++){
                if (!visited[j]){
                    char bi = b[i];
                    b[i] = wd[j].charAt(i);
                    if (String.valueOf(b).equals(wd[j])){
                        visited[j] = true;
                        bfs(b, t, depth+1);
                        visited[j] = false;
                    }
                    b[i] = bi;
                }
            }
        }
        
    }
}