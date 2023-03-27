import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        int count = 0;
        int h=0,m=0,s=0;

        while (h <= n) {
            if (s == 60){
                s = 0;
                m++;
            }

            if (m == 60){
                m = 0;
                h++;
                if (h > n)
                    break;
            }

            if (hasK(s, k) || hasK(m, k) || hasK(h, k)) {
                count++;
            }
            s++;
        }
        System.out.println(count);
    }

    public static boolean hasK(int num, int k) {
        String numS = String.valueOf(num);
        if (k == 0 && (numS.length() < 2 || numS.contains("0")))
            return true;
        else if (numS.contains(String.valueOf(k)))
            return true;
        else
            return false;
    }
}