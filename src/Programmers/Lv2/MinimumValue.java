package Programmers.Lv2;

import java.util.Arrays;

public class MinimumValue {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - i - 1];
        }

        return answer;
    }
}
