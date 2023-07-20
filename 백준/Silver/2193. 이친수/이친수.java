import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        /*
            이진수 중, 0으로 시작하지 않으며, 1이 두번 연속으로 나타나지 않는 이진수 -> 이천수
            N이 주이질 때, N자리 이천수가 총 몇개인지 구하기 (1 <= N <= 90)

            1 ->1
            2 ->10
            3 ->100 101
            4 ->1000 1001 1010
            5 ->10000 10001 10010 10101 10100
            6 ->100000 100001 100010 100100 100101 101010 101000 101001 8

            자리수가 d일때
            s[d] = s[d-2] * 2 + s[d-3]
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int digitNum = Integer.parseInt(br.readLine());

        long[] count = new long[digitNum + 3];

        count[1] = count[2] = 1;
        count[3] = 2;

        for (int i = 4; i <= digitNum; i++) {
            count[i] = count[i-2]*2 + count[i-3];
        }

        System.out.println(count[digitNum]);
    }

}