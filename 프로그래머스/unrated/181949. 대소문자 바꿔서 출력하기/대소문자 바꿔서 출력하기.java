import java.util.Scanner;
import java.lang.Character;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        for (char c : a.toCharArray()){
            if ('a' <= c && c <= 'z'){
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        System.out.println(sb);
    }
}