import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [] field,sequence;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int n = Integer.parseInt(br.readLine());
			int max=0;
			field = new int[n+1];
			sequence = new int[n+1];
			String [] line = br.readLine().split(" ");

			for (int i = 1; i<=n; i++){
				sequence[i] = field[i] = Integer.parseInt(line[i-1]);
		  	}
			max = field[1];
		  	for (int i =1; i<=n; i++){
				for (int j=1; j<i; j++){
					if (field[j]<field[i] && sequence[i] < sequence[j] + field[i]){
						sequence[i] = sequence[j] + field[i];
					}
				}
				if (max < sequence[i])
					max = sequence[i];
		  	}
			System.out.println(max);
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
  }
}
