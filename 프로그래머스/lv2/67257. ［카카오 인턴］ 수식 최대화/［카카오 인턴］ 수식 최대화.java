import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    /*
        음수 최대 vs 양수 최대값 구해서 최대값 -> 우승 최대 금액
        
        1. 사칙연산자 우선순위를 만들기
        2. 우선순위가 가장 높은 연산자에 대해서 해당 과정 진행
        3. 원소가 숫자인경우 push
        4. 원소가 사칙연산인 경우, 우선순위가 
    */
    char[][] priorities = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '+', '*'}
                          , {'-', '*', '+'}, {'*', '-', '+'}, {'*', '+', '-'}};
    public long solution(String expression) {
        long max = 0;
        for (char[] priority : priorities){
            LinkedList<String> list = makeSplitedExpressionList(expression);
            max = Math.max(max, calculate(list, priority));
        }
        return max;
    }
    
    public LinkedList<String> makeSplitedExpressionList(String expression){
        LinkedList<String> list = new LinkedList();
        char[] chars = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            if (!(c == '+' || c == '-' || c == '*')){
                sb.append(c);
            } else {
                list.add(sb.toString());
                list.add(String.valueOf(c));
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        return list;
    }
    
    public long calculate(LinkedList<String> list, char[] priority){
        long result = 0;
        for (int i = 0; i<3; i++){
            int index = 0;
            int size = list.size();
            while (index++ < size){
                String e = list.remove();
                if (!e.equals(String.valueOf(priority[i]))){
                    list.add(e);
                } else {
                    long num1 = Long.parseLong(list.removeLast());
                    long num2 = Long.parseLong(list.remove());
                    index++;
                    list.add(calOperation(num1, e, num2));
                }
            }
        }
        return Math.abs(Long.parseLong(list.remove()));
    }
    
    public String calOperation(long n1, String e, long n2){
        switch(e){
            case "+":
                return String.valueOf(n1 + n2);
            case "-":
                return String.valueOf(n1 - n2);
            default:
                return String.valueOf(n1 * n2);
        }
    }
    
}