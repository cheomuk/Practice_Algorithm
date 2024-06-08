package Programmers.Lv2;

public class FindNumberOfDecimalsInBaseK {

    public int solution(int n, int k) {
        String str = Integer.toString(n, k);
        char[] charArray = str.toCharArray();

        int count = 0;
        String pn = "";

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                if (!pn.equals("") && isPrime(Long.parseLong(pn))) {
                    count++;
                }

                pn = "";
            } else {
                pn = pn + charArray[i];
            }

            if (i == charArray.length - 1 && !pn.equals("")) {
                if (isPrime(Long.parseLong(pn))) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
