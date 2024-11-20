package Programmers.Lv2;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        int printOrder = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Document current = queue.poll();

            boolean hasHigherPriority = false;
            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                printOrder++;
                if (current.index == location) {
                    return printOrder;
                }
            }
        }

        return -1;
    }

    private static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
