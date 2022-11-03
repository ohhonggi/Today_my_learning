import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] t;
    static int[][] s;

    public static void main(String[] args) throws IOException {
        /*
            스티커 2n개는 2행 n열로 배치, 스티커 한장을 땔 경우, 상하좌우가 사용불가
            각 스티커에 점수를 매긴 후, 점수의 합이 최대가 되도록 스티커를 제거
            ex ) 50 10 100 20 40
                 30 50 70  10 60  -> 50 50 100 60을 골랐을 때 최대

            테스트 케이스 개수 T, 각 테스트 케이스 첫 줄은 n (1<= n <= 100,000)
            다음 두 줄에는 n개의 정수, 이는 해당 위치에 해당하는 스티커 점수

            a는 행, b는 열 (a < 2)
            S[a,b] 위치의 점수를 골랐을 때의 총합
            1. a가 0일 때
                if S[0][b] > S[0][b-1] + S[1][b]
                    t[0][b] = t[1][b-1] + S[0][b]
                else
                    t[0][b] = t[0][b-1] + S[1][b]
            2. a가 1일 때 (위와 동일)
            ...

            => t[0,n] 과 t[1,n]을 비교하여 max를 구한다.

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); // 수열의 크기

        for (int c = 0; c < tc; c++) {
            int n = Integer.parseInt(br.readLine()); // 수열의 크기

            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            s = new int[2][n+2];
            t = new int[2][n+2];
            
            for (int[] arr : t) {
                java.util.Arrays.fill(arr,-1);
            }

            for (int i = 1; i <=n; i++) {
                s[0][i] = Integer.parseInt(st1.nextToken());
                s[1][i] = Integer.parseInt(st2.nextToken());
            }
            t[0][0] = t[0][1] = 0;
            t[0][1] = s[0][1];
            t[1][1] = s[1][1];

            int max = Math.max(calTotal(1, n ), calTotal(0, n));
            System.out.println(max);
        }

    }

    public static int calTotal(int a, int b) {
        if (t[a][b] != -1) {
            return t[a][b];
        }
        if (a == 0) {
            t[a][b] = Math.max(calTotal(a, b - 1),
                    calTotal(a + 1, b - 1) + s[a][b]);
        } else {
            t[a][b] = Math.max(calTotal(a, b - 1),
                    calTotal(a - 1, b - 1) + s[a][b]);
        }
        return t[a][b];
    }

}