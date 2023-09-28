import java.util.LinkedList;
import java.util.Arrays;
class Solution {
    public int solution(String str1, String str2) {
        String[] s1 = makeSet(str1);
        String[] s2 = makeSet(str2);
        if (s1.length == 0 && s2.length == 0){
            return 65536;
        } else {
            return s1.length <= s2.length ? jakard(s1,s2) : jakard(s2,s1);
        }
    }
    
    public String[] makeSet(String s){
        char[] st = s.toUpperCase().toCharArray();
        LinkedList<String> sl = new LinkedList();
        int stL = st.length-1;
        for (int i = 0; i<stL; i++){
            String result = String.valueOf(st[i])+st[i+1];
            if (result.matches("[A-Z]{2}")){
                sl.add(result);
            }
        }
        String[] result = sl.toArray(new String[sl.size()]);
        Arrays.sort(result);
        return result;
    }
    
    public int jakard(String[] s1, String[] s2){
        double common = 0;
        for (String s : s1){
            for (int i = 0; i<s2.length; i++){
                if (s.equals(s2[i])){
                    common++;
                    s2[i] = "";
                    break;
                }
            }
        }
        double sum = s1.length + s2.length - common;
        System.out.println(common + "," + sum);
        double result = (common/sum) * 65536;
        return (int) result;
    }
}