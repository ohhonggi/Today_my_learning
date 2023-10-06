import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

class Solution {
    /*
        응답완료시간 기준으로 정렬 -> 응답 시작시작시간은 다를 수 있다.
        응답시작시간 = 응답완료시간 - 처리시간 + 0.001
    */
    int ll;
    public int solution(String[] lines) throws ParseException {
        ll = lines.length;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long[] start = new long[ll];
        long[] end = new long[ll];
         
        for (int i = 0; i<ll; i++){
            String[] split = lines[i].split(" |s");
            Date d = sdf.parse(split[0]+" "+split[1]);
            long t = (long) (Double.parseDouble(split[2]) * 1000);
            start[i] = d.getTime() - t + 1;
            end[i] = d.getTime();
        }
        
        Arrays.sort(start);
        long std = start[0];
        int max = 1;
        int lastIndex = 0;
        
        while (lastIndex < ll && std + 999 >= start[lastIndex++]);
        
        while (std <= end[ll-1]){
            int result = 0;
            for (int i = 0; i<ll; i++){
                if (!(std + 999 < start[i] || std > end[i])){
                    result++;
                } else if (std + 999 < start[i]){
                    break;
                }
            }
            max = Math.max(max, result);
            std++;
            while (std + 999 < start[lastIndex-1]){
                std++;
            }
            
            if (lastIndex < ll-1)
                lastIndex++;
        }
        
        return max;
    }
}