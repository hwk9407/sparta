package algorithm.algo083;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int max = Arrays.stream(tangerine).max().orElse(0);
        int[] sizeArr = new int[max + 1];
        for (int i = 1; i <= tangerine.length; i++) {
            sizeArr[tangerine[i - 1]]++;
        }
        sizeArr = Arrays.stream(sizeArr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int cnt = 0;
        for (int i = 0; i < sizeArr.length; i++) {
            k -= sizeArr[i];
            cnt++;

            if (k <= 0 || (i < sizeArr.length - 1 && sizeArr[i + 1] == 0)) break;
        }
        return cnt;
    }
}

public class Algorithm083 {
    /**
     * 귤 고르기
     * 귤 k개를 골라 상자 하나에 담아 판매하려 한다.
     * 담을 때 서로 다른 종류의 수를 최소화하여 담고 싶다.
     * 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하라.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 12;
        int[] targerine = {1, 1, 1, 1, 2, 2, 2, 3}; // 기대값 3

        System.out.println(solution.solution(k, targerine));
    }
}
