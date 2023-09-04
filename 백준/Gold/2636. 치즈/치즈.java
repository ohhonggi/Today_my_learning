import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        1. 입력에 따라, 정사각형 정보 저장
        2. 치즈 증발 단계 진행
        3. 치즈가 모두 증발한 경우, 종료
     */
    static int height;
    static int width;
    static int cheese;
    static boolean[][] map;
    static int[][] xy = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        map = new boolean[height][width];
        cheese = 0;

        StringTokenizer st;
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                String in = st.nextToken();
                if (in.equals("1")){
                    map[i][j] = true;
                    cheese++;
                }
            }
        }
        int hour = 0, lastCheese = 0;

        while (cheese > 0){
            lastCheese = cheese;
            map = meltCheese();
            hour++;
        }
        System.out.println(hour);
        System.out.println(lastCheese);

    }

    private static boolean[][] meltCheese() {
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i<height; i++){
            visited[i] = map[i].clone();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] && !checkInsideCheese(i, j)){
                    for (int k = 0; k < 4; k++) {
                        int nx = i + xy[k][0];
                        int ny = j + xy[k][1];
                        if (!outOfRange(nx, ny) && !map[nx][ny]){
                            visited[i][j] = false;
                            cheese--;
                            break;
                        }
                    }
                }
            }
        }
        return visited;
    }

    private static boolean checkInsideCheese(int x, int y){
        boolean[][] visited = new boolean[height][width];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()){
            int[] pos = queue.remove();
            if (!visited[pos[0]][pos[1]]) {
                visited[pos[0]][pos[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] + xy[i][0];
                    int ny = pos[1] + xy[i][1];
                    if (outOfRange(nx, ny)){
                        return false;
                    } else if (!map[nx][ny] && !visited[nx][ny]){
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return true;
    }

    private static boolean outOfRange(int x, int y){
        return x == height || x < 0 || y == width || y < 0;
    }

}