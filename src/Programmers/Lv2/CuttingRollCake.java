package Programmers.Lv2;

import java.util.HashMap;

public class CuttingRollCake {

    public int solution(int[] topping) {
        int answer = 0;

        // 두 개의 HashMap을 사용하여 각 부분의 토핑 종류를 저장
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        // 오른쪽 파트에 모든 토핑을 추가
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        // 왼쪽 파트에 하나씩 추가하며 균형점을 찾기
        for (int t : topping) {
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);

            // 오른쪽 파트에서 해당 토핑 개수 하나 감소
            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t); // 개수가 0이 되면 제거
            }

            // 왼쪽과 오른쪽 파트의 토핑 종류 수가 같다면 정답 카운트 증가
            if (leftMap.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
