import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static boolean[] everyNum = new boolean[1000];
    /*
     * 숫자야구, 질문했던 정보들을 토대로 가능한 수의 개수를 계산 (숫자의 자리 수는 겹칠 수 없음!)
     * strike or ball -> 3개의 숫자 중 정답에 해당하는 수
     * 하나의 질문마다 가능한 모든 수를 계산하고, 질문이 추가될 때 마다 소거하기
     *
     * 해답
     *  - 질문했던 수를 기준으로 해답을 찾는 방법 -> 초기 생각했던 방안으로 너무 복잡함
     *  - 가능한 모든 수와 질문했던 수를 비교하여 strike와 ball 개수가 동일한 지 여부를 초점으로 변경
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;
        Arrays.fill(everyNum, true);

        for (int i = 123; i <= 987; i++) {
            String[] split = String.valueOf(i).split("");
            if (split[0].equals(split[1]) || split[1].equals(split[2]) || split[0].equals(split[2]))
                everyNum[i] = false;
            else if (split[0].equals("0") || split[1].equals("0") || split[2].equals("0"))
                everyNum[i] = false;
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            calNum(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }

        for (int i = 123; i <= 987; i++)
            if (everyNum[i])
                result++;

        System.out.println(result);
    }

    public static void calNum(String nums, int strike, int ball) {
        for (int i = 123; i <= 987; i++) {
            if (everyNum[i]) {
                int s = 0, b =0;
                String stringi = String.valueOf(i);

                for (int j = 0; j < 3; j++)
                    if (stringi.contains(nums.charAt(j)+"")){
                        if (stringi.charAt(j) == nums.charAt(j))
                            s++;
                        else
                            b++;
                    }

                if (strike == s && ball == b){
                    everyNum[i] = true;
                } else
                    everyNum[i] =false;
            }
        }
    }
}
