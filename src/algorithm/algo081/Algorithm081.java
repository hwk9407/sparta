package algorithm.algo081;
class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int num : arr) {
            int gcd = getGcd(lcm, num);
            lcm = (lcm * num) / gcd;
        }

        return lcm;
    }

    private int getGcd(int a, int b) {
        int bigNum = Math.max(a, b);
        int smallNum = Math.min(a, b);

        int rest = bigNum % smallNum;
        if (rest == 0) {
            return smallNum;
        }

        return getGcd(smallNum, rest);
    }
}
public class Algorithm081 {
    /**
     * N개의 최소공배수
     * 두 수의 최소공배수 : 두 수의 배수 중 공통이 되는 가장 작은 숫자
     * N개의 최소공배수 : N개의 수들의 배수 중 공통이 되는 가장 작은 숫자
     */

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        Solution solution = new Solution();
        System.out.println(solution.solution(arr));

    }
}
