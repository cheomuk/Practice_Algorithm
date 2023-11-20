package Programmers.Lv1;

import java.util.*;

public class PracticeTest {     // 모의고사 - 완전탐색
    static int[] m1RepeatValues = {1, 2, 3, 4, 5};
    static int[] m2RepeatValues = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] m3RepeatValues = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer;
        int[] array = new int[3];
        int count = 0;

        int m1RightSum = 0;
        int m2RightSum = 0;
        int m3RightSum = 0;

        for (int i : answers) {
            if (m1RepeatValues[count % 5] == i) {
                m1RightSum++;
            }

            if (m2RepeatValues[count % 8] == i) {
                m2RightSum++;
            }

            if (m3RepeatValues[count % 10] == i) {
                m3RightSum++;
            }

            count++;
        }

        int max = Math.max(m1RightSum, Math.max(m2RightSum, m3RightSum));
        count = 0;

        if (m1RightSum == max) {
            array[count] = 1;
            count++;
        }
        if (m2RightSum == max) {
            array[count] = 2;
            count++;
        }
        if (m3RightSum == max) {
            array[count] = 3;
            count++;
        }

        answer = new int[count];

        for (int i = 0; i < count; i++) {
            answer[i] = array[i];
        }

        return answer;
    }
}
