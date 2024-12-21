package algorithm.algo092;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        // 최대값을 찾기 위한 리스트
        List<Integer> descList = new ArrayList<>();

        // 해당 프로세스를 Queue로 변환
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            descList.add(priorities[i]);
        }

        // descList 내림차순 정렬
        descList.sort(Collections.reverseOrder());

        int answer = 0;
        while (!queue.isEmpty()) {
            Integer removed = queue.poll();
            // 지운 첫번째 queue 요소가 최대값과 다르다면 맨뒤로 이동
            if (!removed.equals(descList.get(answer))) {
                queue.add(removed);
                location--;
                if (location < 0) location = queue.size() - 1;
                continue;
            }
            // 최대값이라면 찾고 있는 요소라면 탈출
            if (location == 0 && removed.equals(descList.get(answer))) {
                answer++;
                break;
            }
            location--;
            answer++;
        }

        System.out.println(answer);
        return answer;
    }
}

public class Algorithm092 {
    // 프로세스2
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        solution.solution(priorities, location);
    }
}
