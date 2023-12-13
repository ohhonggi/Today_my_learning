class Solution {
    int[][] cps;
    int cl;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        cps = computers;
        cl = n;
        
        visited = new boolean[n];
        
        for (int i = 0; i<n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cp){
        visited[cp] = true;
        for (int i = 0; i<cl; i++){
            if (!visited[i] && cps[cp][i] == 1){
                dfs(i);
            }
        }
    }
}