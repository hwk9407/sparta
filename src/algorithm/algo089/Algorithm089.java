package algorithm.algo089;


import java.util.Arrays;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 바나나3 사과2 밥2 돈까스2 냄비1
        // 치킨x 사과x 사과o 바나나o 밥o 사과 돈까스 바나나 돈까스 밥 냄비 바나나> 사과 바나나

        for (int i = 0; i < discount.length - 9; i++) {
            // 10회 연속으로 품목이 있는 경우만 answer++
            Boolean tenComboFlag = false;
            int[] wantNumber = Arrays.copyOf(number, number.length);
            for (int j = i; j < i + 10; j++) {
                tenComboFlag = false;

                // 할인 제품과 내가 원하는 목록이 있는지 검사
                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        tenComboFlag = true;

                        wantNumber[k]--;
                        if (wantNumber[k] < 0) tenComboFlag = false;

                        break;
                        // 수량이 0보다 크지않거나 할인항목이 원하는게 없을경우 탈출.)
                    }
                }
                if (!tenComboFlag) break;
            }
            if (tenComboFlag) answer++;
        }

        return answer;
    }
}

public class Algorithm089 {
    /**
     * 할인 행사
     * 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여
     * 할인을 하루에 한 가지 제품만하고, 한 개만 구매가능
     * 10일 연속으로 일치할 경우 회원가입 할 때 모두 할인 받을 수 있는 날짜의 총 일수를 반환하라.
     * want = 원하는 제품
     * number = 원하는 수량
     * discount = 날짜별 할인 일정
     * <p>
     * <제한사항>
     * 1 ≤ want의 길이 = number의 길이 ≤ 10
     * 1 ≤ number의 원소 ≤ 10
     * number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
     * 10 ≤ discount의 길이 ≤ 100,000
     * want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
     * 1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number = new int[]{3, 2, 2, 2, 1};
        String[] discount = new String[]{"apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana", "chicken", "apple"};
        System.out.println(solution.solution(want, number, discount));
    }
}
