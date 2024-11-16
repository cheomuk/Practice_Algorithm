package Programmers.Lv2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int totalTiles = brown + yellow; // 전체 타일 수

        // 1. 가로 길이(width)는 세로 길이(height)보다 크거나 같아야 함.
        for (int width = 3; width <= totalTiles; width++) {
            if (totalTiles % width != 0) continue; // 나누어 떨어지지 않으면 스킵
            int height = totalTiles / width; // 세로 길이

            // 2. 가로가 세로보다 크거나 같아야 한다는 조건 추가
            if (width < height) continue;

            // 3. 갈색 타일과 노란색 타일 개수 조건 확인
            int border = 2 * (width + height) - 4; // 테두리 타일 개수
            if (border == brown && (width - 2) * (height - 2) == yellow) {
                return new int[]{width, height}; // 조건 만족 시 [가로, 세로] 반환
            }
        }

        return new int[0]; // 조건을 만족하는 경우가 없을 때 (예외 처리)
    }
}
