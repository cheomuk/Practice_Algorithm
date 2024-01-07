package Programmers.Lv1;

import java.util.*;

class CraneClawMachineGame {    // 크레인 인형뽑기 게임 - 2019 카카오 개발자 겨울 인턴십

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> basket = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            list.add(convertArray(board, i));
        }

        for (int i : moves) {
            answer = insertBasket(list.get(i - 1), basket, answer);
        }

        return answer;
    }

    public ArrayList<Integer> convertArray(int[][] board, int index) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = board.length; i > 0; i--) {
            arr.add(board[i - 1][index]);
        }

        return arr;
    }

    public int insertBasket(ArrayList<Integer> list, ArrayList<Integer> basket, int answer) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int doll = list.get(i);
            if (doll != 0) {
                list.remove(i); // 인형을 뽑았으므로 리스트에서 제거
                if (!basket.isEmpty() && basket.get(basket.size() - 1) == doll) {
                    // 바구니의 맨 위 인형과 뽑은 인형이 같은 경우
                    basket.remove(basket.size() - 1); // 인형을 터뜨리고 제거
                    answer += 2; // 인형 2개가 터졌으므로 answer에 2를 추가
                } else {
                    basket.add(doll); // 바구니에 인형 추가
                }
                break;
            }
        }

        return answer;
    }
}
