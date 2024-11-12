package Programmers.Lv2;

public class NextBigNumber {
    public int solution(int n) {
        int countOfOnes = Integer.bitCount(n);

        int nextNumber = n + 1;
        while (Integer.bitCount(nextNumber) != countOfOnes) {
            nextNumber++;
        }

        return nextNumber;
    }
}

