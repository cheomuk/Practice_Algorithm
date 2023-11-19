package Lv1;

import java.util.*;

public class PickTwoAndAdd {

    public class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> sumSet = new HashSet<>();

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    sumSet.add(sum);
                }
            }

            int[] answer = new int[sumSet.size()];
            int index = 0;
            for (int num : sumSet) {
                answer[index++] = num;
            }

            Arrays.sort(answer);

            return answer;
        }
    }
}
