import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, max, min;
    static class Path{
        int dst;
        int weight;
        public Path(int d, int w){
            this.dst = d;
            this.weight = w;
        }
    }
    static LinkedList<Path>[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        path = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            path[i] = new LinkedList<>();
        }
        int m = Integer.parseInt(input[1]);
        max = 0;
        min = Integer.MAX_VALUE;
        while (m-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            max = Math.max(w, max);
            min = Math.min(w, min);
            path[a].add(new Path(b, w));
            path[b].add(new Path(a, w));
        }
        input = br.readLine().split(" ");
        int src = Integer.parseInt(input[0]);
        int dst = Integer.parseInt(input[1]);
        int result = 0;
        while (min <= max){
            int mid = (min + max)/2;
            if (bfs(src, dst, mid)) {
                min = mid+1;
                result = mid;
            } else {
                max = mid-1;
            }
        }
        System.out.println(result);
    }

    private static boolean bfs(int src, int dst, int w) {
        boolean[] visited = new boolean[n+1];
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(src, 0));
        visited[src] = true;
        while (!queue.isEmpty()){
            Path p = queue.remove();
            if (p.dst == dst){
                return true;
            }
            for (Path near : path[p.dst]) {
                if (near.weight >= w && !visited[near.dst]){
                    visited[near.dst] = true;
                    queue.add(near);
                }
            }
        }
        return false;
    }
}