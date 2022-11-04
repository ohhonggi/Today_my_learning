import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int [] field, dump; 
  public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			field = new int[n+1];
			dump = new int[n+1];

			String [] line = br.readLine().split(" ");
			for (int i =0; i<n; i++)
				field[i] = Integer.parseInt(line[i]);
			int max = dump[0] = field[0];

			for (int i=1; i<n; i++){
				dump[i] = Math.max(dump[i-1]+field[i],field[i]);
				if (max < dump[i]){
					max = dump[i];
				}
			}
			System.out.println(max);
		}
		catch( IOException e){
			e.printStackTrace();
		}
  }
}