import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int [] field,sequence;
	static int length = 1;
  public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		  int n = Integer.parseInt(br.readLine());
		  field = new int[n+1];
		  sequence = new int[n+1];
		  String [] line = br.readLine().split(" ");

		  for (int i = 1; i<=n; i++){
			field[i] = Integer.parseInt(line[i-1]);
		  }
		  sequence[1] = field[1];
		  for (int i =2; i<=n; i++){
            if (sequence[length] > field[i]){  // LDS의 마지막 값보다 현재값이 작은 경우
              sequence[++length] = field[i];
            }
            else{	// LDS의 마지막 값보다 현재값이 큰 경우
              for (int k=length; k>=1; k--){	// 
                if (sequence[k] == field[i])
                  break;
                else if (sequence[k] > field[i]){
                  sequence[k+1] = field[i];
                  break;
                }
				else if (k==1){		// 최장길이수열의 최소값보다 현재값이 큰 경우
					sequence[k] = field[i];
				}
              }
            }
	      }
          System.out.println(length);
		  br.close();
    	}
		catch(IOException e){
			e.printStackTrace();
		}
  }
}