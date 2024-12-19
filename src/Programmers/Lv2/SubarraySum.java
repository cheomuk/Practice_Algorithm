package Programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

public class SubarraySum {

    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        // 배열을 2배로 늘려 원형 배열처럼 접근 가능하도록 설정
        int[] extendedElements = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extendedElements[i] = elements[i % n];
        }

        // 모든 길이에 대해 부분합 계산
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += extendedElements[start + k];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
