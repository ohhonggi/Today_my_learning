import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        /*
         * N의 분해합 : N과 N을 이루는 각 자리수의 합
         * M의 분해합이 N일때, M을 N의 생성자
         * ex) 245의 분해합 256
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 개수
        int result = 0;

        for (int i = 1; i < n; i++) {
            int sum = i;
            for (String part : String.valueOf(i).split("")) {
                sum += Integer.parseInt(part);
            }
            if (sum == n){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}