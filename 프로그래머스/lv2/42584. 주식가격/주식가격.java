import java.util.*;
class Solution {
    List<int[]> stock;
    public int[] solution(int[] prices) {
        /*
            주식의 가격이 같거나 상승 기간 계산
            
            prices의 길이 100,000 -> 최대 nlogn
            
            queue에 저장되는 원소 -> 인덱스, 주식가격            
        */
        int pricesL = prices.length;
        int[] answer = new int[pricesL];
        
        stock = new ArrayList<int[]>(pricesL);
        
        for (int i = 0; i<pricesL; i++){
            for (int j = 0; j<stock.size(); j++){
                int[] s = stock.get(j);
                if ( s[1] > prices[i] ){
                    answer[s[0]] = i-s[0];
                    stock.remove(j--);
                }
            }
            stock.add(new int[]{i, prices[i]});
        }
        
        for (int j = 0; j<stock.size(); j++){
            int[] s = stock.get(j);
            answer[s[0]] = pricesL - 1 - s[0];
        }
        
        return answer;
    }
    
    // 정확도 O, 시간초과..
//     public int solution1(int[] prices){
//         int pricesL = prices.length;
//         int[] answer = new int[pricesL];
        
//         stock = new ArrayList<Integer>(pricesL);
//         int removedStockCount = 0;
        
//         for (int i = 0; i<pricesL; i++){
            
//             for (int j = 0; j<i; j++){
//                 if (answer[j] == 0 && stock.get(j) > prices[i])
//                     answer[j] = i-j;
//             }
//             stock.add(prices[i]);
//         }
        
//         for (int i = 0; i<pricesL; i++){
//             if (answer[i] == 0)
//                 answer[i] = pricesL -1 - i;
//         }
        
//         return answer;
        
//     }
}