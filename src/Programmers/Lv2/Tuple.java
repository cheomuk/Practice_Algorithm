package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tuple {
    public int[] solution(String s) {
        // 문자열 처리
        s = s.substring(2, s.length() - 2);
        String[] elements = s.split("\\},\\{");

        // 원소 개수 순으로 정렬
        Arrays.sort(elements, (a, b) -> a.length() - b.length());
        // 집합 처리
        List<Integer> result = new ArrayList<>();

        for (String element : elements) {
            String[] nums = element.split(",");

            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (!result.contains(n)) {
                    result.add(n);
                }
            }
        }

        // 결과 배열에 저장
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
