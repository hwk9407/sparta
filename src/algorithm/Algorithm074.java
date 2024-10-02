package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Algorithm074 {
    /**
     * 신고 결과 받기
     * 신고는 같은 사람이 같은 사람을 여러 번 가능 하나 한번만 인정
     * 누적횟수에 도달하면 정지리스트에 올라가고
     * 신고자들에게 본인이 신고한 유저 중 몇명이 정지되었는지 알려준다.
     */

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // 유저 리스트
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; // 신고 기록
        int k = 2; // 최소 누적 신고 횟수

        int[] answer = new int[id_list.length];

        HashMap<Integer, HashSet<Integer>> reportHashMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportHashMap.put(i, new HashSet<>());
        }

        for (String reportId : report) {
            String[] str = reportId.split(" ");
            // str[0] 신고한 유저, str[1] 신고받은 유저
            int[] id = new int[str.length];

            for (int i = 0; i < id_list.length; i++) {
                if (str[0].equals(id_list[i])) {
                    id[0] = i;
                } else if (str[1].equals(id_list[i])) {
                    id[1] = i;
                }
                if (id[0] != 0 && id[1] != 0) break;
            }
            reportHashMap.get(id[0]).add(id[1]);
        }

        int[] reportResult = new int[id_list.length];
        ArrayList<Integer> benIds = new ArrayList<>();
        for (HashSet<Integer> id : reportHashMap.values()) {
            for (Integer i : id) {
                reportResult[i]++;
                if (reportResult[i] == k) benIds.add(i);
            }
        }


        // 유저가 k이상의 신고를 누적받은 애들이 map의 set에 들어있으면 answer 배열에 더해줌
        for (int benId : benIds) {
            for (int i = 0; i < reportResult.length; i++) {
                if (reportHashMap.get(i).contains(benId)) answer[i]++;

            }
        }



//        System.out.println(Arrays.toString(answer));
    }
}

