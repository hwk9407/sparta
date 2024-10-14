package algorithm.algo085;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;


        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            result.addAll(sumOfContinuousSequence(elements, i));
        }

        return result.size();
    }

    private Set<Integer> sumOfContinuousSequence(int[] elements, int length) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int index = i;
            int sum = 0;
            int cnt = length;
            while (cnt > 0) {
                sum += elements[index];
                index++;
                cnt--;
                if (index == elements.length) index = 0;
            }
            set.add(sum);
        }

        return set;
    }
}

public class Algorithm085 {
    /**
     * 연속 부분 수열 합의 개수
     * 배열이 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 리턴하라.
     * 원형 수열은 처음과 끝이 이어진 형태.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution.solution(elements));
    }
}
