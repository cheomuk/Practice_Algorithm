package Programmers.Lv2;

import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 오름차순으로 정렬
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            // 가장 무거운 사람과 가장 가벼운 사람을 태울 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                // 가장 무거운 사람만 태우는 경우
                right--;
            }

            answer++;
        }

        return answer;
    }
}
