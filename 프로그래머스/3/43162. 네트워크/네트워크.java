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
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cp){
        for (int i = 0; i<cl; i++){
            if (!visited[i] && cps[cp][i] == 1){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}