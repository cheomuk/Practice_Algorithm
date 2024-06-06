package Programmers.Lv2;

public class FibonacciNumbers {

    public int solution(int n) {
        int mod = 1234567;
        int[] fibo = new int[n+1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % mod;
        }

        return fibo[n];
    }
}
