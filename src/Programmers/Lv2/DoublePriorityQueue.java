package Programmers.Lv2;

import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            char command = parts[0].charAt(0);
            int value = Integer.parseInt(parts[1]);

            if (command == 'I') {
                minQueue.offer(value);
                maxQueue.offer(value);
            } else if (command == 'D') {
                if (minQueue.isEmpty() && maxQueue.isEmpty()) {
                    continue;
                }

                if (value == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        if (minQueue.isEmpty() && maxQueue.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {maxQueue.peek(), minQueue.peek()};
        }
    }
}
