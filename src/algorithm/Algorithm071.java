package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Algorithm071 {
    /**
     * 개인정보 수집 유효기간
     * 1~n번으로 분류되는 개인정보 n개가 있습니다.
     * 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
     * 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
     *
     *  A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면
     *  해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
     *  (모든 달은 28일까지 있다고 가정)
     *
     *  today는 "YYYY.MM.DD" 형태로 오늘 날짜
     *  terms은 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열
     *  privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열
     *  날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어짐
     *
     *  파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어짐
     */

    public static void main(String[] args) {
        int[] answer = {};
        String today = "2010.06.17";
        String[] terms = {"A 23"};
        String[] privacies = {"2009.01.19 A", "2000.01.05 A"};


        // terms를 사용하기 좋은 HashMap으로 저장
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] str = term.split(" ");
            termMap.put(str[0], Integer.valueOf(str[1]));
        }


        List<Integer> answerList = new ArrayList<>();

        // privacies를 for문 돌려서 각 문자열을 순회하고
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            // 각 문자열을 공백으로 먼저 나누기
            String[] str = privacy.split(" ");
            StringBuilder dateSb = new StringBuilder(str[0]);
            int month = Integer.parseInt(dateSb.toString().split("\\.")[1]);
            int year = Integer.parseInt(dateSb.toString().split("\\.")[0]);
            month += termMap.get(str[1]);
            if (month > 12) {
                year = year + (month / 12);
                month %= 12;

                // 12월인 경우 다음해 0월로 연산되니 조건문 추가
                if (month == 0) {
                    year--;
                    month = 12;
                }
            }
            String yearMonth = year + "." + ((month < 10) ? "0" + month : month);
            dateSb.replace(0, 7, yearMonth);
            if (isExpiration(today, dateSb.toString())) {
                answerList.add(i + 1);
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));

    }

    // 날짜 String을 파라미터로 입력받고 만료 날짜가 오늘 날짜 기준으로 만료됐는지 boolean 반환
    // 오늘 날짜     만료 날짜
    // 2021.05.02 < 2022.05.02 false 만료안됨
    // 2022.04.02 < 2022.05.02 false
    // 2022.05.01 < 2022.05.02 false
    // 2022.05.02 >= 2022.05.02 true
    private static boolean isExpiration(String today, String target){
        String[] toDate = today.split("\\.");
        String[] targetDate =  target.split("\\.");

        // 년도 비교
        if (Integer.parseInt(toDate[0]) < Integer.parseInt(targetDate[0])) {
            return false;
        } else if (toDate[0].equals(targetDate[0])) {
            // 월 비교
            if (Integer.parseInt(toDate[1]) < Integer.parseInt(targetDate[1])) {
                return false;
            }
            else if (toDate[1].equals(targetDate[1])) {
                // 일 비교
                if (Integer.parseInt(toDate[2]) < Integer.parseInt(targetDate[2])) {
                    return false;
                }
            }
        }

        return true;
    }
}
