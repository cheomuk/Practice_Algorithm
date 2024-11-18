package Programmers.Lv2;

public class NLCM {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }

        return lcm;
    }

    // 최소공배수 계산
    private int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    // 유클리드 호제법
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
