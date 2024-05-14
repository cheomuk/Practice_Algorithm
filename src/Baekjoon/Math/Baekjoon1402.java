package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1402 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // Test Case
        // 9 4
        // 9를 소인수 분해하면 3 x 3 -> 3 + 3 = 6 이므로 6으로 변환 가능
        // 2 + 3 = 5 -> 1 + 4 or 5 x 1 -> 4 로 변환 가능
        // 즉, 1과 -1 을 사용하면 실수는 전부 구현 가능하므로 yes를 출력한다.
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println("yes");
        }
    }
}
