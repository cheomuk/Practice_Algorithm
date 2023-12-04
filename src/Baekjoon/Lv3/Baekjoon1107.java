package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1107 {

    public static void main(String[] args) throws IOException { // 브루트 포스 문제. 다시 풀어볼 것!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int target = Integer.parseInt(br.readLine());

        int error_cnt = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];
        if (error_cnt !=0){
            stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < error_cnt; i++) {
                arr[Integer.parseInt(stk.nextToken())] = true;
            }
        }

        System.out.println(solution(target, arr));
    }
    private static int solution(int target, boolean[] arr) {

        // 100부터 순차적으로 갔을때
        int count = Math.abs(target -100);
        for (int i = 0 ; i <= 999999 ; i++){

            int press_cnt = getlen(i,arr);
            if (press_cnt == -1){
                continue;
            }
            int total_cnt = press_cnt + Math.abs(target - i);
            count = Math.min(count, total_cnt);
        }


        return count;
    }


    //해당 i에 대해 갈 수 있다면, 자릿수 반환, 없다면 0 반환
    private static int getlen(int i, boolean[] arr){
        int result = 0;

        //i : 0 인데 고장난경우
        if (i == 0) {
            if (arr[0]) {
                return -1;
            }
            return 1;
        }

        while (i != 0){
            if (arr[i % 10]) {
                return -1;
            } else {
                result++;
                i/=10;
            }
        }

        return result;
    }
}
