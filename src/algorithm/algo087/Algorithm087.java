package algorithm.algo087;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        int index = 0;
        for (long i = left; i < left + answer.length; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);
            answer[index] = Math.max(row + 1, col + 1);
            index++;
        }

        return answer;
    }
}

public class Algorithm087 {
    /**
     * n^2 배열 자르기
     * 정수 n, left, right 주어져서 1차원 배열을 만들려함
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int left = 2;
        int right = 5;
        System.out.println(Arrays.toString(solution.solution(n, left, right)));
    }
}
