package Programmers.Lv1;

public class PressKeypad {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 키패드 좌표 설정
        int[][] keypad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1} // *, 0, #
        };

        // 초기 위치 설정
        int[] leftPos = {3, 0}; // '*'의 위치
        int[] rightPos = {3, 2}; // '#'의 위치

        // 숫자별 위치 설정
        int[][] numPos = new int[10][2];
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] != -1) {
                    numPos[keypad[i][j]][0] = i;
                    numPos[keypad[i][j]][1] = j;
                }
            }
        }

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftPos = numPos[number];
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightPos = numPos[number];
            } else {
                int leftDist = Math.abs(leftPos[0] - numPos[number][0]) + Math.abs(leftPos[1] - numPos[number][1]);
                int rightDist = Math.abs(rightPos[0] - numPos[number][0]) + Math.abs(rightPos[1] - numPos[number][1]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = numPos[number];
                } else if (rightDist < leftDist) {
                    answer.append("R");
                    rightPos = numPos[number];
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        rightPos = numPos[number];
                    } else {
                        answer.append("L");
                        leftPos = numPos[number];
                    }
                }
            }
        }

        return answer.toString();
    }

    public void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(this.solution(numbers, hand));
    }
}
