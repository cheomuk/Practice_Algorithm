package Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothingMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothingMap.put(type, clothingMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        for (int count : clothingMap.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}