class Solution {
    int sL;
    public int solution(String s) {
        /*
            1개 이상 단위로 문자열을 압축하여 표현한 문자열 중, 가장 짧은 것의 길이를 return
            
            1. n개 이상 단위로 문자열 압축
            2. 문자열 길이 대소비교
            
            시간복잡도 : 10^3 길이 -> n^2logn까지 가능
            - 완탐 -> n + n/2 + n/3 .. n/n < n^2
            
        */
        int answer = Integer.MAX_VALUE;
        sL = s.length();
        
        for (int i = 1; i <= sL; i++){
            answer = Math.min(answer, compressString(s, i));
        }
        return answer;
    }
    
    public int compressString(String s, int digit){
        int index = 0;
        while (index + digit <= s.length()){
            String pattern = s.substring(index, index + digit);
            String[] removedStringInfo = removeDuplicatePattern(s, pattern, index);
            if (s.equals(removedStringInfo[0]))
                index += digit;
            else{
                s = removedStringInfo[0];
                index += digit + removedStringInfo[1].length();
            }
        }
        // System.out.println(s);
        return s.length();
    }
    
    public String[] removeDuplicatePattern(String s, String pattern, int index){
        int patternCount = 1;
        int digit = pattern.length();
        // System.out.println("pattern: "+pattern);
        
        for (int i = index; i + 2*digit <= s.length(); ){
            String comparedPattern = s.substring(i + digit, i + 2*digit);
                
            if (pattern.equals(comparedPattern)){
                s = s.substring(0, i) + s.substring(i+digit);
                patternCount++;
            }else{
                break;
            }
        }
        
        if (patternCount == 1)
            return new String[]{s, String.valueOf(patternCount)};
        else{
            // System.out.println("removedPattern :" + s.substring(0, index) + patternCount + 
            //                    s.substring(index, s.length()));
            return new String[]{s.substring(0, index) + patternCount + 
                               s.substring(index, s.length()), String.valueOf(patternCount)};
        }
    }
    
    
}