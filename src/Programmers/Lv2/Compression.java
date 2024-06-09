package Programmers.Lv2;
import java.util.*;

public class Compression {

    public static HashMap<String, Integer> map;
    public static List<Integer> nums;

    public int[] solution(String msg) {

        map = new HashMap<>();
        nums = new ArrayList<>();

        String[] strArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (int i = 0; i < strArr.length; i++) {
            map.put(strArr[i], i + 1);
        }

        char[] charArr = msg.toCharArray();
        int index = 27; // 다음 인덱스 번호 (사전의 초기 값 이후)

        for (int i = 0; i < charArr.length; i++) {
            int count = 0;
            String currentStr = "" + charArr[i];

            while (i + count < charArr.length && map.containsKey(currentStr)) {
                count++;
                if (i + count < charArr.length) {
                    currentStr += charArr[i + count];
                }
            }

            // 사전에 없는 문자열을 만났을 때
            if (map.containsKey(currentStr)) {
                nums.add(map.get(currentStr));
            } else {
                nums.add(map.get(currentStr.substring(0, currentStr.length() - 1)));
                map.put(currentStr, index++);
            }

            i += count - 1;
        }

        // 결과를 배열로 변환
        int[] answer = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            answer[i] = nums.get(i);
        }

        return answer;
    }
}
