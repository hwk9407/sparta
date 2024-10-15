package algorithm.algo086;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length; // 어떤 과학자가 발표한 논문 n편

        int maxH = 0;
        int max = Arrays.stream(citations).max().getAsInt();

        for (int i = 1; i <= max; i++) {
            int countH = 0; // 인용된 논문 횟수
            int restCountH = 0; // 나머지 논문 횟수
            for (int j = 0; j < n; j++) {
                if (i <= citations[j]) countH++;
                else restCountH++;
            }
            // h의 값은 인용된 논문 횟수보다 크면서, 나머지 논문 인용 횟수 이하인 경우만!
            // 더이상 할 필요 없는 순간은 h값이
            if (i <= countH && i >= restCountH) maxH = Math.max(maxH, i);
            else if (countH < restCountH) break;
        }

        return maxH;
    }
}

public class Algorithm086 {
    /**
     * H-Index
     * 어떤 과학자가 발표한 논문 n편 중,
     * h번 이상 인용된 논문이 h편 이상이고
     * 나머지 논문이 h번 이하 인용되었다면
     * h의 최댓값이 이 과학자의 H-Index
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution.solution(citations));
    }
}
