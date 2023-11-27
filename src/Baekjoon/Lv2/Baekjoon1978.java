package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < num; i++) {
            if (isPrime(Integer.parseInt(arr[i]))) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }

    public static boolean isPrime(int num){
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++){
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
