import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int a = Integer.parseInt(nums[0]);  // 피로도 증가량
        int b = Integer.parseInt(nums[1]);  // 처리량
        int c = Integer.parseInt(nums[2]);  // 피로도 감소량
        int m = Integer.parseInt(nums[3]);  // 최대 피로도 m
        int time = 0;
        int amount = 0;
        int stress = 0;

        while (time < 24) {
            if (stress + a > m) {
                if (stress - c < 0)
                    stress = 0;
                else
                    stress -= c;
            } else {
                stress += a;
                amount += b;
            }
            time++;
        }
        System.out.println(amount);
    }

}