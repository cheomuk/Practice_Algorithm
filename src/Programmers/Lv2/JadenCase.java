package Programmers.Lv2;

public class JadenCase {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean capitalize = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append(c);
                capitalize = true; // 공백 다음은 대문자로 시작
            } else if (capitalize) {
                result.append(Character.toUpperCase(c));
                capitalize = false; // 첫 문자를 대문자로 변환 후 소문자로 전환
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}

