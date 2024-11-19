package Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>(); // 원하는 상품과 개수를 매핑

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 10일 연속으로 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            // 10일간의 할인 상품 개수를 세어 Map에 저장
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            // 원하는 상품과 개수가 모두 맞는지 확인
            if (isSatisfied(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    // 원하는 상품과 개수가 할인에서 충족되는지 확인
    private boolean isSatisfied(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String key : wantMap.keySet()) {
            if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}

