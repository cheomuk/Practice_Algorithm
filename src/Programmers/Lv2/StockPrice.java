package Programmers.Lv2;

import java.util.Stack;

public class StockPrice {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 스택에 있는 인덱스의 가격이 현재 가격보다 크면 스택에서 제거
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        // 스택에 남아 있는 인덱스 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }

        return answer;
    }
}
