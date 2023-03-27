import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();   // 총 사람 수
        int t = sc.nextInt();
        int signal = sc.nextInt();  // 0 - 뻔, 1 - 데기
        int cycle = 2;              // 뻔, 데기 반복 cycle 수
        int index = -1;             // t번째 signal을 외치는 사람의 위치
        int count = 0;

        while (count < t) {
            // 4번의 반복
            for (int k = 0; k < 4 && count < t; k++) {
                if (k%2 == signal){
                    count++;
                }
                index++;
            }

            if (count < t) {
                // cycle번 째에서 t번의 반복이 종료되는 경우
                if (count + cycle >= t){
                    if (signal == 0) {
                        index += (t - count);
                    } else {
                        index += (cycle + t - count);
                    }
                    break;
                } else{
                    index += cycle*2;
                    count += cycle;
                }
            } else break;

            cycle++;
        }

        System.out.println(index%total);

    }

}