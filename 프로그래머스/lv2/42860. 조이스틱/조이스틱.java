import java.lang.Math;

class Solution {
    public int solution(String name) {
        /*
            1. 선택 절차 : 현재 위치에서 조이스틱을 상하 중 한 방향으로 움직여 해당 알파벳을 만듦
            2. 적절성 검사 : 
                - 해당 위치가 알파벳 이름의 해당 위치와 동일한지
                - 조이스틱 조작 횟수가 최솟값인지
            3. 해답 검사 : 알파벳 이름이 완성되었는지 검사
                1. 완성되지 않은 경우, 현재 위치에서 우측의 연속되는 A 개수 계산
                2. 연속되는 A 범위를 제외하고는 모두 이동범위에 해당되므로, 이를 사용하여 좌우 최솟값 계산
                    1. 오른쪽을 우선순위로 최솟값 계산
                    2. 왼쪽을 우선순위로 최솟값 계산
        */
        int result = 0;
        int nameL = name.length();
        char[] tokens = name.toCharArray();
        int row = nameL-1;

        for (int i = 0; i<nameL; i++){
            // i 위치 알파벳의 상하 방향으로의 조작 횟수 계산
            result += Math.min(tokens[i] - 'A', 'Z' - tokens[i] + 1);
            
            int index = i+1;
            
            // i 위치 앞에 연속된 A개수 구하기
            while (index < nameL && tokens[index] =='A')
                index++;
            
            // 오른쪽 방향을 우선순위로 하여 좌우 조작 최솟값 계산
            row = Math.min(row, i * 2 + nameL - index);
            
            // 왼쪽 방향을 우선순위로 하여 좌우 조작 최솟값 계산
            row = Math.min(row, (nameL - index) * 2 + i);
            
        }

        return result + row;
    }
}