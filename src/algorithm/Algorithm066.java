package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm066 {
    /**
     * 대충 만든 자판
     * 휴대폰 자판은 같은 버튼에 다른 문자가 할당될 수 있다.
     * 아무렇게나 만든 휴대폰 자판이 있다. (1 ~ 100개)
     * 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있다.
     * 같은 문자가 자판 전체에 여러 번 할당된 경우도 있다.
     * 키 하나에 같은 문자가 여러 번 할당된 경우도 있다.
     * 이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지를 구하라
     * <p>
     * keymap과 targets의 원소는 알파벳 대문자로만 이루어져 있습니다.
     * <p>
     * 단, 목표 문자열을 작성할 수 없을 때는 -1을 저장
     */

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","DG", "AABB"};

        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();


        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            answerList.add(i, 0);

            char[] chars = target.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                boolean foundFlag = false;
                int minIndex = 0;

                for (String key : keymap) {
                    // 만약 문자를 찾았다면
                    if (key.indexOf(chars[j]) != -1) {
                        // 원래 찾은 인덱스와 새로 찾은 것과 비교해서 더 작은것을 대입
                        minIndex = foundFlag ? Math.min(minIndex, key.indexOf(chars[j]) + 1) : key.indexOf(chars[j]) + 1;
                        foundFlag = true;
                    }
                }

                // keymap을 다 돌았는데도 못찾은 경우는 -1 반환
                if (!foundFlag) {
                    answerList.set(i, -1);
                    break;
                }

                answerList.set(i, answerList.get(i) + minIndex);
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));

    }
}
