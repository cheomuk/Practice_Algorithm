package Programmers.Lv2;

import java.util.*;

public class JumpingAndTeleportation {

    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                // 순간 이동
                n /= 2;
            } else {
                // 점프
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}
