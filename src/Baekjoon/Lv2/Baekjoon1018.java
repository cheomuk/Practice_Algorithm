package Baekjoon.Lv2;

import java.io.*;

public class Baekjoon1018 {
    public static void main(String[] args) throws IOException { // 다시 한번 풀어봐야 할 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArray = br.readLine().split(" ");
        int row = Integer.parseInt(strArray[0]);
        int col = Integer.parseInt(strArray[1]);
        String[] strArr = new String[row];

        for (int i = 0; i < row; i++) {
            strArr[i] = br.readLine();
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                int count = solution(i, j, strArr);
                if (sol > count) {
                    sol = count;
                }
            }
        }

        System.out.println(sol);
        br.close();
    }

    public static int solution(int row, int col, String[] strArr) {
        String[] board = {"BWBWBWBW", "WBWBWBWB"};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int startRow = row + i;
            for (int j = 0; j < 8; j++) {
                int startCol = col + j;
                if (strArr[startRow].charAt(startCol) != board[startRow % 2].charAt(j)) {
                    count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }
}
