package Programmers.Lv1;

import java.util.Arrays;

class HighestAndLowestLottoRankings {   // 로또의 최고 순위와 최저 순위 - 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
    int count = 0;
    int zeroNums = 0;
    int[] list = new int[6];

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);

        isZero(lottos);
        return countLottos(win_nums, answer);
    }

    public void isZero(int[] lottos) {  // list = {1, 25, 31, 44}, zeroNums = 2
        for (int i : lottos) {
            if (i == 0) {
                zeroNums++;
            } else {
                list[count++] = i;
            }
        }
    }

    public int[] countLottos(int[] win_nums, int[] answer) {
        int equalsNumCount = 0;
        for (int i : win_nums) {
            for (int j = 0; j < list.length; j++) {
                if (list[j] == i) {
                    equalsNumCount++;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            answer[i] = resultCalculate(equalsNumCount, zeroNums, i);
        }

        return answer;
    }

    public int resultCalculate(int equalsNumCount, int zeroNums, int i) {
        int result = 0;

        if (zeroNums == 0) {
            if (equalsNumCount < 2) {
                result = 6;
            } else {
                result = 6 - equalsNumCount + 1;
            }
        } else {
            if (i == 0) {
                result = 6 - (equalsNumCount + zeroNums) + 1;
            } else if (equalsNumCount == 0) {
                result = 6;
            } else {
                result = 6 - equalsNumCount + 1;
            }
        }

        return result;
    }
}
