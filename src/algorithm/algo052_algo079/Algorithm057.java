package algorithm.algo052_algo079;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithm057 {
    /**
     * 모의고사
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
     * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
     * <p>
     * 배열의 길이와 조회하려는 인덱스값이 같으면 0을 조회하게끔 로직을 짜야함.
     */
    public static void main(String[] args) {
        int[] answer = {};

        int[] answers = {1, 2, 3, 4, 5};

        int[][] giveUpPattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        List<Integer> score = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giveUpPattern[0][i % giveUpPattern[0].length]) score.set(0, score.get(0) + 1);
            if (answers[i] == giveUpPattern[1][i % giveUpPattern[1].length]) score.set(1, score.get(1) + 1);
            if (answers[i] == giveUpPattern[2][i % giveUpPattern[2].length]) score.set(2, score.get(2) + 1);
        }

        int maxScore = Collections.max(score);

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < score.size(); i++) {
            if (score.get(i) == maxScore) answerList.add(i + 1);
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
