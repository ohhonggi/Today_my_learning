using System;

public class Solution
{
    public int solution(string name)
    {
        //모든 자리수가 A가 아니면 순차적으로 입력해도 되지만,
        //A가 있는 경우는 어느쪽 방향으로 이동하는게 더 빠른지 계산해주어야한다.
        //일단 문자를 변환하기 위한 조작수는 먼저 구해준 후
        //커서이동을 어떻게 해야 모든 구간을 다 통과할 수 있는지는 재귀함수를 통해 계산하자

        bool[] isNeedChange = new bool[name.Length];//변환이 필요한 배열 위치 저장

        int answer = 0;
        for (int i = 0; i < name.Length; i++)
        {
            //문자별로 아스키값 차이를 뽑아서 더하고 빼줌
            if (((int)name[i] - (int)'A') > (int)'Z' - (int)name[i])
                answer += (int)'Z' - (int)name[i] + 1;//Z로 바꾸는 1번 조작 추가
            else
                answer += (int)name[i] - (int)'A';

            //A인 경우는 변환이 완료되었다고 보면 된다.
            if (name[i] == 'A')
                isNeedChange[i] = false;
            else
                isNeedChange[i] = true;
        }

        //커서이동 조작 계산
        //첫번째는 변환완료 됐다고 가정한다(이동하지 않고 바로 변환 가능하므로)
        isNeedChange[0] = false;
        answer += CountAllRoute(0, isNeedChange);

        return answer;
    }

    public bool isChangeComplete(bool[] isNeedChange)
    {
        foreach (bool isNeed in isNeedChange)
        {
            if (isNeed)
            {
                return false;
            }
        }
        return true;
    }

    public int CountAllRoute(int idx, bool[] isNeedChange)
    {
        //모두 완료면 이동이 끝난 거다
        if (isChangeComplete(isNeedChange))
            return 0;

        //좌측으로 갈 경우 
        int left_idx = (idx - 1 < 0) ? idx - 1 + isNeedChange.Length : idx - 1, left_cnt = 1;
        while (!isNeedChange[left_idx])
        {
            left_idx = (left_idx - 1 < 0) ? left_idx - 1 + isNeedChange.Length : left_idx - 1;
            left_cnt++;
        }
        bool[] leftIsNeedChange = (bool[])isNeedChange.Clone();
        leftIsNeedChange[left_idx] = false;

        //우측으로 갈 경우
        int right_idx = (idx + 1 > isNeedChange.Length - 1) ? idx + 1 - isNeedChange.Length : idx + 1, right_cnt = 1;
        while (!isNeedChange[right_idx])
        {
            right_idx = (right_idx + 1 > isNeedChange.Length - 1) ? right_idx + 1 - isNeedChange.Length : right_idx + 1;
            right_cnt++;
        }
        bool[] rightIsNeedChange = (bool[])isNeedChange.Clone();
        rightIsNeedChange[right_idx] = false;

        //둘중 낮은 것을 리턴함
        if (left_cnt + CountAllRoute(left_idx, leftIsNeedChange) < right_cnt + CountAllRoute(right_idx, rightIsNeedChange))
            return left_cnt + CountAllRoute(left_idx, leftIsNeedChange);
        else
            return right_cnt + CountAllRoute(right_idx, rightIsNeedChange);
    }
}
