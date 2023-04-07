import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int arr[] = new int[num];
        int strike[] = new int[num];
        int ball[] = new int[num];
        int count = 0;

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=123; i<=987; i++) {
            int st_t =0;
            int b_t = 0;
            int check = 0;

            if(i/100 == i/10%10)continue;
            else if(i/10%10 == i%10) continue;
            else if(i/100 == i%10) continue;

            if(i/10%10 == 0) continue;
            if(i%10 == 0) continue;

            for(int j=0; j<strike.length; j++) {
                st_t = 0;
                b_t = 0;
                if(arr[j]/100 == i/100) {
                    st_t++;
                }
                else {
                    if(arr[j]/10%10 ==i/100) {
                        b_t++;
                    }
                    else if(arr[j]%10 == i/100) {
                        b_t++;
                    }
                }
                if(arr[j]/10%10== i/10%10) {
                    st_t++;
                }
                else {
                    if(arr[j]/100 ==i/10%10) {
                        b_t++;
                    }
                    else if(arr[j]%10 == i/10%10) {
                        b_t++;
                    }
                }
                if(arr[j]%10 == i%10) {
                    st_t++;
                }

                else {
                    if(arr[j]/100 ==i%10) {
                        b_t++;
                    }
                    else if(arr[j]/10%10 == i%10) {
                        b_t++;
                    }
                }

                if(strike[j]!=st_t || ball[j]!=b_t) {
                    break;
                }
                check++;
                if(check == num) {
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}