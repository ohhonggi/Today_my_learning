import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
        최단 거리가 아닌, 특정 지점까지의 경우의 수를 구할 경우 bfs보다 dfs가 유용함.
        dp[i][j] = 현재 위치까지 가능한 모든 경로의 경우의 수

     */
    static int[][] xy = {{1,0},{0,1},{-1,0},{0,-1}};
    static int width, height;
    static int[][] dp, map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input = br.readLine().split(" ");
        width = Integer.parseInt(input[0]);
        height = Integer.parseInt(input[1]);
        dp = new int[width][height];
        map = new int[width][height];

        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }

    private static int dfs(int x, int y) {
        if (x == width-1 && y == height-1){
            return 1;
        }
        if (dp[x][y] == -1){
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + xy[i][0];
                int ny = y + xy[i][1];
                if (!outOfRange(nx, ny) && map[nx][ny] < map[x][y]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }

    private static boolean outOfRange(int x, int y){
        return x < 0 || y < 0 || x == width || y == height;
    }
}