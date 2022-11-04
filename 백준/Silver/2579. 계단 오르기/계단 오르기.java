import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	static int [] field, MaxSum; 
    public static void main(String [] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			field = new int[n+1];
			MaxSum = new int[n+1];

			for (int i =1; i<=n; i++)
				field[i] = Integer.parseInt(br.readLine());	// 임의의 수열 저장.
			java.util.Arrays.fill(MaxSum,-1);
			MaxSum[0] = 0;
			MaxSum[1] = field[1];
			if (n>1){
				MaxSum[2] = field[1] + field[2];
			}
			System.out.println(stair(n));
		}
		catch( IOException e){
			e.printStackTrace();
		}
    }
	static int stair(int index){	// 3개의 계단을 연속으로 밟는 경우를 방지해야함.
		if (MaxSum[index] != -1)
			return MaxSum[index];
        
		MaxSum[index] = Math.max((stair(index-2)+field[index]),(stair(index-3)+field[index-1]+field[index]));
		return MaxSum[index];
	}
}