package Programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

public class EnglishEnding {

    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        int[] answer = new int[2];

        int turn = 1;
        int player = 1;
        String prevWord = "";

        for (String word : words) {
            if (usedWords.contains(word) || (turn > 1 && !word.startsWith(prevWord.substring(prevWord.length() - 1)))) {
                answer[0] = player;
                answer[1] = (turn + n - 1) / n;
                return answer;
            }

            usedWords.add(word);
            prevWord = word;
            turn++;
            player = (player % n) + 1;
        }

        return answer;
    }
}
