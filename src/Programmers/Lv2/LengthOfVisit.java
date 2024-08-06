package Programmers.Lv2;

import java.util.*;

public class LengthOfVisit {

    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        int nowY=0;
        int nowX=0;
        int prevY=0;
        int prevX=0;

        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);

            switch(ch) {
                case 'U' : nowY--;break;
                case 'D' : nowY++;break;
                case 'R' : nowX++;break;
                case 'L' : nowX--;break;
            }

            if (nowY < -5 || nowX < -5 || nowY > 5 || nowX > 5) {
                nowY=prevY;
                nowX=prevX;
                continue;
            }

            int[][] arr = {{nowY, nowX}, {prevY, prevX}};
            Arrays.sort(arr, (arr1, arr2) -> {
                if (arr1[0] > arr2[0]) {
                    return 1;
                } else if (arr1[0] == arr2[0]) {
                    if (arr1[1] > arr2[1]) {
                        return 1;
                    }
                }

                return -1;
            });

            set.add(arr[0][0] + " " + arr[0][1] + " " + arr[1][0] + " " + arr[1][1]);

            prevY=nowY;
            prevX=nowX;
        }

        return set.size();
    }
}
