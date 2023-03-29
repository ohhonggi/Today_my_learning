import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] height = new int[9];
        int sum = 0;
        int hobbit1 = 0, hobbit2 = 0;

        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }
        Arrays.sort(height);

        for(int a = 0; a < height.length-1; a++) {
            for(int b = a+1; b < height.length; b++) {
                if(sum - height[a] - height[b] == 100) {
                    hobbit1 = a;
                    hobbit2 = b;
                    break;
                }
            }
        }

        for(int j = 0; j < height.length; j++) {
            if(j == hobbit1 || j == hobbit2)
                continue;
            System.out.println(height[j]);
        }
        sc.close();
    }
}