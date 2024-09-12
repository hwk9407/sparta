package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Algorithm056 {
    /**
     * 과일 장수
     * 사과의 최대 점수 k (최하 점수 1)
     * 한 상자에 m개씩 담아 포장
     * 한 상자에 담긴 사과중 가장 점수가 낮은 사과 p
     * 상자의 가격은 p * m (최하 점수 사과가 가격을 결정한다.)
     * <p>
     * 최대 이익을 내기 위해서
     * 내림차순 정렬
     */
    public static void main(String[] args) {
        int k = 3;
        int m = 4;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        int answer = 0;

        List<Integer> arrList = new ArrayList<Integer>();
        for (int i : score) {
            arrList.add(i);
        }
        arrList.sort((o1, o2) -> o2 - o1);  // 내림 차순으로 정렬
        for (int i = 0; i < arrList.size(); i += m) {
            if (i + m - 1 >= arrList.size()) {
                break;
            }
            System.out.println(m + " * arrList.get(" + (m + m - 1) + ") = " + m * arrList.get(i + m - 1));

            answer += m * arrList.get(i + m - 1);
            System.out.println("현재까지 answer : " + answer);
        }

        System.out.println("최종 answer : " + answer);


    }
}
