package algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class Algorithm061 {
    /**
     * 로또의 최고 순위와 최저 순위
     * 1 ~ 45 숫자 중 6개를 찍어서 맞히는 로또
     * 1등 : 6개  일치
     * 2등 : 5개   ``
     * 3등 : 4개   ``
     * 4등 : 3개   ``
     * 5등 : 2개   ``
     * 6등(낙첨) : 그 외
     * <p>
     * 로또 번호의 일부를 알 수 없는 번호인 0으로 표기
     * 순서 상관없이 순위를 결정함
     * 최고 순위와 최저 순위를 배열에 담아 반환하는 함수를 만들어라.
     */
    public static void main(String[] args) {
        int[] lottos = {1, 2, 3, 4, 5, 6};
        int[] win_nums = {7, 8, 9, 10, 11, 12};
        int[] answer = {};

        HashSet<Integer> winSet = new HashSet<>();
        for (int i = 0; i < win_nums.length; i++) {
            winSet.add(win_nums[i]);
        }


        int count = 0;
        int zeroCount = 0;
        for (int num : lottos) {
            if (winSet.contains(num)) {
                count++;
            }
            if (num == 0) {
                zeroCount++;
            }
        }

        int minRank = 7 - count;
        int maxRank = minRank - zeroCount;
        minRank = minRank > 6 ? 6 : minRank;    // 7등도 6등처리
        maxRank = maxRank > 6 ? 6 : maxRank;    // 7등도 6등처리
        answer = new int[]{maxRank, minRank};

        System.out.println(Arrays.toString(answer));




    }
}
