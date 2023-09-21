class Solution {
    /*
        대각선을 포함하는 모든 정사각형을 제외. how?
        
        최대공약수를 사용한 풀이..
        
    */
    public long solution(int w, int h) {
        long ww = w;
        long hh = h;
        long answer = ww*hh;
        
        long maxD = gcd(ww,hh);
        long sum = ww/maxD + hh/maxD - 1;
        long except = sum * maxD;
        
        return answer - except ;
    }
    
    public long gcd(long a, long b){
        if (a < b){
            long temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}