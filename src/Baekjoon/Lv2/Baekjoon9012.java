package Baekjoon.Lv2;

import java.io.*;
import java.util.Stack;

public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split("");
            stack.clear();
            for (int j = 1; j <= arr.length; j++) {
                if (!stack.empty()) {
                    if (!stack.peek().equals(arr[j - 1])) {
                        stack.pop();
                    } else {
                        stack.push(arr[j - 1]);
                    }
                } else {
                    if (arr[j - 1].equals(")")) {
                        stack.push(arr[j - 1]);
                        break;
                    }

                    stack.push(arr[j - 1]);
                }
            }

            if (stack.empty()) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
