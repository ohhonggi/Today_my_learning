import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (a,b) -> a.compareTo(b));
        int pL = phone_book.length;
        for (int i = 0; i<pL-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}