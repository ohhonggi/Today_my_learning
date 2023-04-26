import java.util.HashSet;

class Solution {
    // boolean[] visited;
    // String[] split;
    // int numL;
    HashSet<Integer> pnums = new HashSet<Integer>();
    
    public int solution(String numbers) {
        // split = numbers.split("");
        // numL = numbers.length();
        // visited = new boolean[numL];
        int result = 0;
        permutation("", numbers);
        
        while (pnums.iterator().hasNext()){
            int num = pnums.iterator().next();
            pnums.remove(num);
            if (num == 2)
                result++;
            else if (num%2 != 0 && isPrimeNumber(num)){
                result++;
            }
        }
        return result;
    }
    
    public void permutation(String prefix, String numS){
        int n = numS.length();
        
        if (!prefix.equals("")){
            pnums.add(Integer.parseInt(prefix));
        }
        
        for (int i = 0; i<n; i++){
            permutation(prefix + numS.charAt(i), numS.substring(0, i) + numS.substring(i+1, n));
        }
    }
    
//     public void dfs(int depth, int index, String number){
//         if (depth == numL){
//             System.out.println(number);
//             return;
//         }
//         else{
//             if (!pnums.contains(Integer.parseInt(number)) 
//                 && isPrimeNumber(Integer.parseInt(number))){
//                 pnums.add(Integer.parseInt(number));
//             }

//             visited[index] = true;
//             for (int i = 0; i< numL; i++){
//                 if (!visited[i])
//                     dfs(depth+1, i, number + split[i]);
//             }
//             visited[index] = false;
//         }
//     }
    
    public boolean isPrimeNumber(int n){
        if (n == 0 || n == 1){
            return false;
        } else {
            for (int i = 3; i<= (int) Math.sqrt(n); i+=2){
                if (n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}