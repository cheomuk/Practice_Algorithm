package Programmers.Lv2;

public class VowelDictionary {

    public int solution(String word) {
        // 모음 리스트
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        // 각 자리의 가중치
        int[] weights = {781, 156, 31, 6, 1};

        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    result += weights[i] * j + 1;
                    break;
                }
            }
        }

        return result;
    }
}
