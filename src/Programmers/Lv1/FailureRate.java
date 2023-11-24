package Programmers.Lv1;

import java.util.*;

public class FailureRate {  // 실패율 - 2019 KAKAO BLIND RECRUITMENT
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        checkDuplication(stages);

        int[] answer = new int[N];
        int length = stages.length;

        return failureRate(answer, length, N);
    }

    public void checkDuplication(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public int[] failureRate(int[] answer, int length, int N) {
        HashMap<Integer, Float> failure = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i)) {
                failure.put(i, (float) map.get(i) / length);
                length -= map.get(i);
            } else {
                failure.put(i, 0f);
            }
        }

        List<Map.Entry<Integer, Float>> list = new ArrayList<>(failure.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int valueCompare = o2.getValue().compareTo(o1.getValue());
            if (valueCompare == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return valueCompare;
        });

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
