package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1783 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);   // 세로
        M = Integer.parseInt(arr[1]);   // 가로

        find();

        System.out.println(sb);
        br.close();
    }

    // 1. 2칸 위, 1칸 오른쪽
    // 2. 1칸 위, 2칸 오른쪽
    // 3. 1칸 아래, 2칸 오른쪽
    // 4. 2칸 아래, 1칸 오른쪽
    private static void find() {

        int result = 0;

        if (N == 1) {
            // N이 1이면 이동 불가 (시작 지점만)
            result = 1;
        } else if (N == 2) {
            // N이 2일 땐, 2번, 3번 방향으로만 움직일 수 있음
            // 절대 네 방향으로 다 움직일 수 없어서 최댓값은 4
            result = Math.min((M + 1) / 2, 4);
        } else if (N >= 3) {
            // M = 7 부터 네 방향 다 이동 가능
            // 네 방향 다 이동한 후에는 y값이 1씩 증가하는 1번, 4번 이동을 반복
            // 즉, M - 2개의 칸을 갈 수 있음
            if (M < 7) {
                result = Math.min(M, 4);
            } else {
                result = M - 2;
            }
        }

        sb.append(result);
    }
}
