package Programmers.Lv2;

import java.util.PriorityQueue;

public class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if (max > 0) {
                pq.offer(max - 1);
                n--;
            }
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
