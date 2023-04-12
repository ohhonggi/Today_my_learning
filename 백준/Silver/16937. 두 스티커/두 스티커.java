import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     * h x w 크기 모눈종이, 스티커 n개 (1 <= n <= 100)
     * 모눈종이에 스티커 2개 붙여서 최댓값 구하기 (겹치지 않도록)
     * 모든 스티커 조합을 구하여 붙여진 넓이의 최댓값 구할 수 있음 (스티커를 90도 회전이 가능) -> 완탐
     */
    static int[][] stk;
    static int h,w,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        h = Integer.parseInt(split[0]);
        w = Integer.parseInt(split[1]);
        n = Integer.parseInt(br.readLine());
        int max = 0;
        stk = new int[n][2];

        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            stk[i][0] = Integer.parseInt(split[0]);
            stk[i][1] = Integer.parseInt(split[1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int w1=0, w2=0, h1=0, h2=0;
                    switch (k){
                        case 0:
                            w1 = stk[i][0];
                            h1 = stk[i][1];
                            w2 = stk[j][0];
                            h2 = stk[j][1];
                            break;
                        case 1:
                            w1 = stk[i][0];
                            h1 = stk[i][1];
                            w2 = stk[j][1];
                            h2 = stk[j][0];
                            break;
                        case 2:
                            w1 = stk[i][1];
                            h1 = stk[i][0];
                            w2 = stk[j][0];
                            h2 = stk[j][1];
                            break;
                        case 3:
                            w1 = stk[i][1];
                            h1 = stk[i][0];
                            w2 = stk[j][1];
                            h2 = stk[j][0];
                            break;
                    }
                    if (checkMaxHeight(w1,h1,w2,h2) || checkMaxWidth(w1,h1,w2,h2))
                        max = Math.max(max, (stk[i][0] * stk[i][1]) + (stk[j][0] * stk[j][1]));
                }
            }
        }
        System.out.println(max);
    }

    public static boolean checkMaxHeight(int w1, int h1, int w2, int h2) {
        if (w1 + w2 <= w && Math.max(h1,h2) <= h)
            return true;
        else
            return false;
    }

    public static boolean checkMaxWidth(int w1, int h1, int w2, int h2) {
        if (h1 + h2 <= h && Math.max(w1,w2) <= w)
            return true;
        else
            return false;
    }
}