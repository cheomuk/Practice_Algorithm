package Programmers.Lv3;

public class OnTheWayToSchool {

    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n][m];

        // 초기값 설정: 모든 경로의 개수를 0으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
            }
        }

        // 시작점 설정
        dp[0][0] = 1;

        // 물웅덩이 위치 설정
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        // 동적 프로그래밍을 사용하여 경로의 개수 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 물웅덩이는 건너뛰기
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // 위쪽에서 오는 경로 추가
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }

                // 왼쪽에서 오는 경로 추가
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        // 목적지의 경로 개수 반환
        return dp[n - 1][m - 1];
    }
}
