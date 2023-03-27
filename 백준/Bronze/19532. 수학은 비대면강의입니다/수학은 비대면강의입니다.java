import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         *  연립방정식
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);
        int d = Integer.parseInt(nums[3]);
        int e = Integer.parseInt(nums[4]);
        int f = Integer.parseInt(nums[5]);
        int x = 0,y = 0;

        if (a == 0 || d == 0) {
            if (a == 0 && d == 0) {
                x = c * e - f * b;
            } else {
                x = (c * e - f * b) / (a * e - d * b);
            }

            if (b == 0){
                if (e != 0)
                    y = (f - d * x) / e;
            } else {
                y = (c - a * x) / b;
            }
        } else {
            if (b == 0 && e == 0) {
                y = c * d - f * a;
            } else {
                y = (c * d - f * a) / (b * d - e * a);
            }

            if (a == 0){
                if (d != 0)
                    x = (f - e * y) / d;
            } else {
                x = (c - b * y) / a;
            }
        }
        System.out.println(x + " " + y);
    }
}