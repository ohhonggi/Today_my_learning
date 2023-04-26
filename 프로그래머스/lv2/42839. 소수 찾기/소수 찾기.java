import java.util.HashSet;

class Solution {
    boolean[] visited;
    String[] split;
    int numL;
    int[] isPrime;
    HashSet<Integer> pnums = new HashSet<Integer>();
    
    public int solution(String numbers) {
        split = numbers.split("");
        numL = numbers.length();
        visited = new boolean[numL];
        isPrime = new int[(int)Math.pow(10,(numL+1))];
        isPrime[0] = isPrime[1] = -1;

        for (int i = 0; i< split.length; i++){
            dfs(0, i, split[i]);
        }
        return pnums.size();
    }
    
    public void dfs(int depth, int index, String number){
        if (depth == numL){
            System.out.println(number);
            return;
        }
        else{
            if (!pnums.contains(Integer.parseInt(number)) 
                && isPrimeNumber(Integer.parseInt(number))){
                pnums.add(Integer.parseInt(number));
            }

            visited[index] = true;
            for (int i = 0; i< numL; i++){
                if (!visited[i])
                    dfs(depth+1, i, number + split[i]);
            }
            visited[index] = false;
        }
    }
    
    public boolean isPrimeNumber(int number){
        if (isPrime[number] < 0)
            return false;
        else if (isPrime[number] == 1){
            return true;
        } else {
            for (int i = 2; i<number; i++){
                if (number % i == 0){
                    isPrime[number] = -1;
                    return false;
                }
            }
            isPrime[number] = 1;
            return true;
        }
    }
}