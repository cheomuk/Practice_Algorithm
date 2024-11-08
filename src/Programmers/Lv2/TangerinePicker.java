package Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TangerinePicker {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(countMap.values());

        int answer = 0;
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
            answer++;
            if (sum >= k) break;
        }

        return answer;
    }
}
