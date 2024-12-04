package Programmers.Lv2;

import java.util.*;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployCounts = new ArrayList<>();
        Queue<Integer> workQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int days = (int) Math.ceil((double) remainingWork / speeds[i]);
            workQueue.offer(days);
        }

        while (!workQueue.isEmpty()) {
            int current = workQueue.poll();
            int count = 1;

            while (!workQueue.isEmpty() && workQueue.peek() <= current) {
                workQueue.poll();
                count++;
            }

            deployCounts.add(count);
        }

        return deployCounts.stream().mapToInt(i -> i).toArray();
    }
}
