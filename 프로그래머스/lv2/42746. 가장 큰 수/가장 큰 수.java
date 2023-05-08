import java.util.*;
class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        int numL = numbers.length;
        String[] numberI = new String[numL];

        Arrays.setAll(numberI, i -> String.valueOf(numbers[i]));
        Arrays.sort(numberI, (a, b) -> {
            if (a.length() == b.length())
                return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
            else
                return a.length() < b.length() ? compareTwoArray(a,b) : -compareTwoArray(b,a);
        });

        for (int i = numberI.length-1; i>=0; i--)
            answer += numberI[i];
        
        // 모든 원소가 0인 경우
        if (answer.charAt(0) == '0')
            return "0";
        else
            return answer;
    }

    public int compareTwoArray(String s1, String s2){
        int index = 0;
        int s1L = s1.length();
        int s2L = s2.length();
        
        while (index < s2L){
            if (Character.compare(s1.charAt(index % s1L), s2.charAt(index)) != 0)
                return Character.compare(s1.charAt(index % s1L), s2.charAt(index));
            index++;
        }
        return Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
    }

}