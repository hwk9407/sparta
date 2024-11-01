package algorithm.algo093;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[][] dungeons) {

        // 현재 피로도 k, 갈 수 있는 던전들 dungeons
        // 먼저 각 요소를 가져옴
        // 만약 요소가 피로도가 높아. 그럼 가져오기
        //

        return 0;
    }
}

public class Algorithm093 {
    /**
     * 피로도
     * 최소 필요 피로도와 소모 피로도가 있다.
     * 하루에 한 번씩 탐험할 수 있는데, 유저가 탐험할수 있는 최대 던전 수를 Retrun 하라
     * <p>
     * 제한사항
     * k는 1 이상 5,000 이하인 자연수입니다.
     * dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
     * dungeons의 가로(열) 길이는 2 입니다.
     * dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
     * "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
     * "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
     * 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 78;
        int[][] dungeons = {{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}};
        System.out.println(solution.solution(k, dungeons));
    }
}
