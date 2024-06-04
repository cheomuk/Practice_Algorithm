package Programmers.Lv3;

public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] max = new int[triangle.length][triangle.length];
        max[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    max[i][j] = max[i - 1][j] + triangle[i][j];
                }

                if (j > 0 && j < triangle[i].length - 1) {
                    max[i][j] = Math.max(max[i - 1][j] + triangle[i][j],
                            max[i - 1][j - 1] + triangle[i][j]);
                }

                if (j == triangle[i].length - 1) {
                    max[i][j] = max[i - 1][j - 1] + triangle[i][j];
                }
            }
        }

        for (int value : max[triangle.length - 1]) {
            answer = Math.max(value, answer);
        }

        return answer;
    }
}
