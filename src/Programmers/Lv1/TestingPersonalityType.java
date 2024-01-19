package Programmers.Lv1;

import java.util.*;

class TestingPersonalityType {

    HashMap<String, Integer> option = new HashMap<>();
    String[] list = {"T", "R", "C", "F", "M", "J", "A", "N"};

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (int i = 0; i < 8; i++) {
            option.put(list[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String[] arr = survey[i].split("");
            calculateSurvey(arr, choices[i]);
        }

        for (int i = 0; i < option.size(); i += 2) {
            if (option.get(list[i]) > option.get(list[i + 1])) {
                answer += list[i];
            } else if (option.get(list[i]) == option.get(list[i + 1])) {
                int comparisonResult = list[i].compareTo(list[i + 1]);
                if (comparisonResult < 0) {
                    answer += list[i];
                } else {
                    answer += list[i + 1];
                }
            } else {
                answer += list[i + 1];
            }
        }

        return answer;
    }

    public void calculateSurvey(String[] arr, int choice) {
        if (choice < 4) {
            option.put(arr[0], option.get(arr[0]) + getValue(choice));
        } else if (choice > 4) {
            option.put(arr[1], option.get(arr[1]) + getValue(choice));
        }
    }

    public int getValue(int choice) {
        int value = 0;
        switch (choice) {
            case 1:
            case 7:
                value = 3;
                break;
            case 2:
            case 6:
                value = 2;
                break;
            case 3:
            case 5:
                value = 1;
                break;
            case 4:
                break;
        }

        return value;
    }
}
