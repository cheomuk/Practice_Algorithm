package Programmers.Lv2;

import java.util.*;

public class ParkingFeeSettlement {

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> totalTimeMap = new HashMap<>();
        Set<String> carSet = new HashSet<>();

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];

        for (String record : records) {
            String[] arr = record.split(" ");

            String time = arr[0];
            String carNumber = arr[1];
            String type = arr[2];

            carSet.add(carNumber);

            if (type.equals("IN")) {
                map.put(carNumber, convertTimeToMin(time));
            } else {
                int inTime = map.remove(carNumber);
                int duration = convertTimeToMin(time) - inTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + duration);
            }
        }

        for (String carNumber : map.keySet()) {
            int inTime = map.get(carNumber);
            int duration = 1439 - inTime;
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + duration);
        }

        List<String> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        int[] answer = new int[sortedCars.size()];

        for (int i = 0; i < sortedCars.size(); i++) {
            String carNumber = sortedCars.get(i);
            int totalTime = totalTimeMap.get(carNumber);

            if (totalTime <= defaultTime) {
                answer[i] = defaultFee;
            } else {
                answer[i] = defaultFee + (int) Math.ceil((double) (totalTime - defaultTime) / extraTime) * extraFee;
            }
        }

        return answer;
    }

    public int convertTimeToMin(String time) {
        String[] timeArr = time.split(":");

        int hour = Integer.parseInt(timeArr[0]) * 60;
        int min = Integer.parseInt(timeArr[1]);

        return hour + min;
    }
}
