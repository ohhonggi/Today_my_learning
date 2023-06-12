import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        /*
            주식의 가격이 같거나 상승 기간 계산
            prices의 길이 100,000 -> 최대 nlogn
            stack에 저장되는 원소 -> 인덱스, 주식가격            
        */
        int pricesL = prices.length;
        int[] answer = new int[pricesL];
        
        Stack<Integer> stock = new Stack<Integer>();
        
        for (int i = 0; i<pricesL; i++){
            
            // stack의 저장된 원소 중, 가격이 떨어진 주식을 찾아 기록 및 제거
            
            while (!stock.isEmpty() && prices[i] < prices[stock.peek()]){
                int sI = stock.pop();
                answer[sI] = i - sI;
            }
            stock.push(i);
        }
        
        // queue에 남은 원소 -> 끝까지 가격이 떨어지지 않은 주식들
        while (!stock.isEmpty()){
            int sI = stock.pop();
            answer[sI] = pricesL - 1 - sI;
        }
        
        return answer;
    }
}