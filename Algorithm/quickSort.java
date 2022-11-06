package Algorithm;

import java.io.*;
import java.util.*;

/*
    input format
    ex)
    5
    1 3 2 4 5
 */

class quickSort {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            arr[i] = node;
        }
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
    public static void sort(int[] a) {
        m_pivot_sort(a, 0, a.length - 1);
    }

    /**
     *  중간 피벗 선택 방식
     * @param a		정렬할 배열
     * @param lo	현재 부분배열의 왼쪽
     * @param hi	현재 부분배열의 오른쪽
     */
    private static void m_pivot_sort(int[] a, int lo, int hi) {

        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        m_pivot_sort(a, lo, pivot);
        m_pivot_sort(a, pivot + 1, hi);
    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param a		정렬 할 배열
     * @param left	현재 배열의 가장 왼쪽 부분
     * @param right	현재 배열의 가장 오른쪽 부분
     * @return		최종적으로 위치한 피벗의 위치(hi)를 반환
     */
    private static int partition(int[] a, int left, int right) {

        // lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작.
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정


        while(true) {
            do {
                lo++;
            } while(a[lo] < pivot);

            do {
                hi--;
            } while(a[hi] > pivot && lo <= hi);

            if(lo >= hi) {
                return hi;
            }
            swap(a, lo, hi);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

// ref - https://st-lab.tistory.com/250