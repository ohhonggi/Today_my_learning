class Solution {
    /*
        1 - 1
        4 - 11
        13 - 111
        39 - 444
        40 - 1111
    */
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n >= 1){
            int divided = n%3;
            if (divided == 0){
                sb.append('4');
                n--;
            } else {
                sb.append(divided);
            }
            n /= 3;
        }
        return sb.reverse().toString();
    }
    
}