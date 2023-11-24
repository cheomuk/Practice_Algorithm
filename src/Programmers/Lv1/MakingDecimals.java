package Programmers.Lv1;

import java.util.*;

public class MakingDecimals {   // 소수 만들기 - Summer/Winter Coding(~2018)
    public int solution(int[] nums) {
        int answer = 0;

        List<List<Integer>> allCombinations = generateAllCombinations(nums);

        for (List<Integer> combination : allCombinations) {
            if (isPrime(calculateSum(combination))) {
                answer++;
            }
        }

        return answer;
    }

    public static List<List<Integer>> generateAllCombinations(int[] nums) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack(nums, allCombinations, currentCombination, 0);

        return allCombinations;
    }

    public static void backtrack(int[] nums, List<List<Integer>> allCombinations, List<Integer> currentCombination, int startIndex) {
        if (currentCombination.size() == 3) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            currentCombination.add(nums[i]);
            backtrack(nums, allCombinations, currentCombination, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static int calculateSum(List<Integer> combination) {
        int sum = 0;
        for (int num : combination) {
            sum += num;
        }
        return sum;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for(int i = 2; i < num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
