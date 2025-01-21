package algorithm.practice002;

import java.util.Arrays;

public class Practice002 {
    private int[][] moves;
    private int moveIndex; // 이동 횟수

    public static void main(String[] args) {
        int n = 3;
        Practice002 solution = new Practice002();
        int[][] result = solution.solution(n);
        System.out.println("result = " + Arrays.deepToString(result));

    }

    public int[][] solution(int n) {
        int totalMoves = (int) Math.pow(2, n) - 1;

        this.moves = new int[totalMoves][2]; // 이동 기록을 위한 배열
        this.moveIndex = 0; // 초기 이동 인덱스

        moveDisks(n, 1, 3, 2);

        return moves;
    }

    private void moveDisks(int n, int from, int to, int temp) {
        if (n == 1) {
            moves[moveIndex][0] = from;
            moves[moveIndex][1] = to;
            moveIndex++; // 다음 이동 인덱스 증가
            return;
        }

        moveDisks(n - 1, from, temp, to);
        moves[moveIndex][0] = from;
        moves[moveIndex][1] = to;
        moveIndex++; // 다음 이동 인덱스 증가

        moveDisks(n - 1, temp, to, from);
    }
}