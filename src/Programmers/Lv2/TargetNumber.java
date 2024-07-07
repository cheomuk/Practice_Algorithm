package Programmers.Lv2;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, index + 1, sum + numbers[index], target)
                + dfs(numbers, index + 1, sum - numbers[index], target);
    }
}
