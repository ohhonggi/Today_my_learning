import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();     // 1<= n < 10^6

        int[] count = new int[num + 2];

        for (int i = 2; i <= num; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1);
            }
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1);
            }
        }

        System.out.println(count[num]);
    }
}
