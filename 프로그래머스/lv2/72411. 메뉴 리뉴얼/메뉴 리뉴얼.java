import java.util.HashMap;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.LinkedList;
class Solution {
    /*
        2 <= g <= 20 / 2 <= n <= 10 / 2 <= m <= 10
        새로 만들 메뉴의 개수 2~m에 대해, 모든 손님이 주문한 메뉴n에 대해 m개를 뽑아 만들 수 있는 조합의 수 계산
        (10C2 + 10C3 + 10C4 + .. 10C10) * 20
        
        1. 각 손님이 만들 수 있는 메뉴 조합을 course의 최대값(2~m개의 메뉴)까지 구해 map에 저장
        2. 만든 조합 map에 대해, 각 새로운 매뉴 개수에 따른 최대 주문 개수에 해당하는 메뉴 조합 구하기
    */
    HashMap<String, Integer> map;
    LinkedList<String> resultS;
    int[] resultN;
    char[] courses;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap((int) Math.pow(10.0, (double) course.length/2));
        resultS = new LinkedList();
        resultN = new int[course[course.length-1]-1];

        for (String order : orders){
            char[] o = order.toCharArray();
            for (int c : course){
                if (c <= o.length){
                    courses = new char[c];
                    combination(0,0,o,c);
                }
            }
        }
        
        LinkedList<Entry<String,Integer>> newCourses = new LinkedList(map.entrySet());
        newCourses.sort((a,b) -> -(a.getValue() - b.getValue()));
            
        for (Entry<String,Integer> newCourse : newCourses){
            String nC = newCourse.getKey();
            if(newCourse.getValue() > 1){
                if (resultN[nC.length()-2] == 0){
                    resultN[nC.length()-2] = newCourse.getValue();
                    resultS.add(nC);
                } else if (resultN[nC.length()-2] == newCourse.getValue()){
                    resultS.add(nC);
                }
            }
        }
        
        String[] result = resultS.toArray(new String[resultS.size()]);
        Arrays.sort(result);
        return result;
    }
    
    public void combination(int index, int bit, char[] order, int cn){
        if (index == cn){
            char[] courseC = Arrays.copyOf(courses, cn);
            Arrays.sort(courseC);
            String course = String.valueOf(courseC);
            map.put(course, map.getOrDefault(course, 0)+1);
            return;
        }
        
        for (int i = 0; i<order.length; i++){
            if ((bit & (1 << i)) == 0){
                courses[index] = order[i];
                combination(index+1, bit |= (1 << i), order, cn);
            }
        }
    }
}