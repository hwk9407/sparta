package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Algorithm072 {
    /**
     * 달리기 경주
     * 문자열 배열 players : 선수들의 이름이 1등부터 현재 등수 순서대로 담김
     * 문자열 배열 callings : 해설진이 부른 이름을 담김
     *
     * 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
     */

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = {};

        // 선수들의 이름, 순위가 담겨있는 Map 생성
        HashMap<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }


        // callings 를 순서대로 순회한다.
        for (String calledPlayer : callings) {
            int callRank = rankMap.get(calledPlayer);
            if (callRank != 0) {

                rankMap.put(calledPlayer, callRank - 1);
                rankMap.put(players[callRank - 1], callRank);

                // 바로 앞 선수와 등수 교체
                String tempString = players[callRank - 1];
                players[callRank - 1] = players[callRank];
                players[callRank] = tempString;
            }
        }

        answer = players;

        System.out.println(Arrays.toString(answer));


    }
}
