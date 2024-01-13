package Programmers.Lv1;

class NewIdRecommendation {

    public String solution(String new_id) {
        String lowerCase = new_id.toLowerCase();

        lowerCase = lowerCase.replaceAll("[^a-z0-9\\-_.]", "");
        lowerCase = lowerCase.replaceAll("\\.{2,}", ".");
        lowerCase = lowerCase.replaceAll("^\\.|\\.$", "");

        if (lowerCase.equals("")) {
            lowerCase = "a";
        }

        lowerCase = lowerCase.length() > 15 ? lowerCase.substring(0, 15) : lowerCase;

        if (lowerCase.length() < 3) {
            String lastChar = lowerCase.substring(lowerCase.length() - 1);
            for (int i = 0; lowerCase.length() + i <= 3; i++) {
                lowerCase += lastChar;
            }
        }

        lowerCase = lowerCase.replaceAll("\\.{2,}", ".");
        lowerCase = lowerCase.replaceAll("^\\.|\\.$", "");

        return lowerCase;
    }
}
