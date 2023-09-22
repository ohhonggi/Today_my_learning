import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        int index = 0;
        stack.push(chars[index++]);
        while (index < chars.length){
            if (stack.isEmpty()){
                stack.push(chars[index++]);
            } else {
                if (stack.peek() == chars[index]){
                    stack.pop();
                } else {
                    stack.push(chars[index]);
                }
                index++;
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}