package Programmers.Lv1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DartGame {    // [1차] 다트 게임 - 2018 KAKAO BLIND RECRUITMENT

    int[] valueArray;
    int count = 0;

    public int solution(String dartResult) {    // 1S2D*3T
        int answer = 0;

        Matcher m = Pattern.compile("[0-9]+|[a-zA-Z]+|[*#]+").matcher(dartResult);
        List<String> list = new ArrayList<>();

        while (m.find()) {
            list.add(m.group());    // 1, S, 2, D, *, 3, T
        }

        return dartResult(list, answer);
    }

    public int dartResult(List<String> list, int answer) {
        valueArray = new int[list.size()];
        for (String s : list) {
            if (isParsable(s)) {
                valueArray[count++] = Integer.parseInt(s);
            } else {
                switch (s) {
                    case "D":
                        valueArray[count - 1] *= valueArray[count - 1];
                        break;
                    case "T":
                        valueArray[count - 1] *= valueArray[count - 1] * valueArray[count - 1];
                        break;
                    case "*":
                        if (count == 1) {
                            valueArray[0] *= 2;
                        } else {
                            for (int i = count - 1; i > count - 3; i--) {
                                valueArray[i] *= 2;
                            }
                        }
                        break;
                    case "#":
                        valueArray[count - 1] *= -1;
                }
            }
        }

        for (int i : valueArray) {
            answer += i;
        }

        return answer;
    }

    public boolean isParsable(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
