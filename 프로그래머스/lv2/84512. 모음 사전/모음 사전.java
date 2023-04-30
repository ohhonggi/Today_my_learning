import java.util.*;
class Solution {
    /*
        재귀 함수를 사용한 풀이 고안
        1 ~ 5^5개 사전 
        해당 단어보다 앞선 단어들의 개수 파악 -> 해당 단어의 순서
        
    */
    
    char[] alpa = new char[]{'A','E','I','O','U'};
    int wordL;
    int[] wordI;
    int[] dict;
    public int solution(String word) {
        wordL = word.length();
        wordI = new int[5];
        dict = new int[]{-1,-1,-1,-1,-1};
        int count = 0;
        
        // while (count < 5){
        //     if (!word.equals(dictToString())){
        //         dict[count++] = 0;
        //     } else{
        //         return count;
        //     }
        // }
        
        count = countAlpabet(count, word);
        return count;
    }
    
    // i번째 알파벳보다 
    public int countAlpabet(int count, String word){
        String s = dictToString().substring(0, wordL);
        if (word.equals(s)){
            return count;
        }
        else{
            nextOrder();
            return countAlpabet(count+1, word);
        }
    }
    
    public void nextOrder(){
        for (int i = 0; i<alpa.length; i++)
            if (dict[i]<0){
                dict[i]++;
                break;
            } else if (i == alpa.length-1){
                if (dict[4] == 4){
                    dict[4] = -1;
                    if (dict[3] == 4){
                        dict[3] = -1;
                        if (dict[2] == 4){
                            dict[2] = -1;
                            if (dict[1] == 4){
                                dict[0]++;
                                dict[1] = -1;
                            } else{
                                dict[1]++;
                            }
                        } else
                            dict[2]++;
                    } else
                        dict[3]++;
                } else
                    dict[4]++;
            }
    }
    
    public String dictToString(){
        String s = "";
        for (int i = 0; i< dict.length; i++){
            if (dict[i] != -1){
                s += alpa[dict[i]];
            }else
                s += " ";
        }
        return s;
    }
    
    public void print(int count, String word){
        System.out.print(dictToString() +" ");
        System.out.println("count: "+count);
        System.out.println(word);
    }
}