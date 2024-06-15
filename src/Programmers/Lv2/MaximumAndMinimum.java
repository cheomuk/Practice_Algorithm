package Programmers.Lv2;

import java.util.Arrays;

public class MaximumAndMinimum {

    public String solution(String s) {
        // 문자열을 공백 기준으로 분리하여 정수 배열로 변환
        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 최댓값과 최솟값 찾기
        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();

        return min + " " + max;
    }
}
