package Baekjoon.Lv2;

import java.io.*;
import java.util.Stack;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "push" :
                    stack.push(Integer.parseInt(arr[1]));
                    break;
                case "pop" :
                    if (stack.empty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    if (stack.empty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "top" :
                    if (stack.empty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
