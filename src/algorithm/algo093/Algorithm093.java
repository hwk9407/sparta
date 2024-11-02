package algorithm.algo093;

import java.util.Stack;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int cnt = 0;
        // 완전 탐색 dfs 에 필요한 Stack 3개
        Stack<Integer> maxCount = new Stack<>();
        Stack<Integer> currentK = new Stack();
        Stack<boolean[]> visited = new Stack<>();

        // 초기 설정
        maxCount.push(cnt);
        currentK.push(k);
        visited.push(new boolean[dungeons.length]);

        while (!currentK.isEmpty()) {
            int curk = currentK.pop();
            int count = maxCount.pop();
            boolean[] visitFlag = visited.pop();

            cnt = Math.max(cnt, count);

            for (int i = 0; i < dungeons.length; i++) {
                if (!visitFlag[i] && curk >= dungeons[i][0]) {
                    visitFlag[i] = true;

                    maxCount.push(count + 1);
                    currentK.push(curk - dungeons[i][1]);
                    visited.push(visitFlag.clone());

                    visitFlag[i] = false; // 백트래킹
                }
            }
        }
        return cnt;
    }
}

public class Algorithm093 {
    /**
     * 피로도
     *
     * XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
     * 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
     * "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며,
     * "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
     * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며,
     * 던전을 탐험한 후에는 피로도 20이 소모됩니다.
     *
     * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
     * 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
     * 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
     *
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
        int k = 80;
        int[][] dungeons = {{80, 20}, {50,40}, {30, 10}};

        System.out.println(solution.solution(k, dungeons));
    }
}
