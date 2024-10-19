package algorithm.algo088;

import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr2[0].length; col++) {
                for (int index = 0; index < arr1[0].length; index++) {
                    answer[row][col] += arr1[row][index] * arr2[index][col];

                }
            }
        }
        return answer;
    }
}

public class Algorithm088 {
    /**
     * 행렬의 곱셈
     * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하라
     *
     * [제한 조건]
     * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
     * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수
     * 곱할 수 있는 배열만 주어짐
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{3, 3}, {3, 3}};
//        int[][] arr2 = {{1, 4}, {2, 5}, {3, 6}};
        // 기대값: [[14, 32], [32, 77]]
        int[][] answer = solution.solution(arr1, arr2);
        for (int[] ints : answer) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
