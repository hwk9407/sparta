package algorithm.algo082;

// 칸의 수와 끝에 도달하는 방법의 개수의 관계
// 1 -> 1           1
// 2 -> 11 2        2
// 3 -> 111 12 21   3
// 4 -> 1111 112 121 211 22 5
// 5 -> 11111 1112 1121 1211 2111 122 212 221 8
// 6 -> 111111 21111 12111 11211 11121 11112 2211 2121 2112 1221 1212 1122 222 13

class Solution {
    public long solution(int n) {

        if (n <= 2) return n;

        int lastWay = 1;
        int way = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = way;
            way = (way + lastWay) % 1234567;
            lastWay = temp;
        }

        return way % 1234567;
    }
}
public class Algorithm082 {
    /**
     * 082. 멀리 뛰기
     * 효진이는 한 번에 한 칸 또는 두 칸을 뛸 수 있다.
     * 4칸이 있다면 5가지 방법으로 맨 끝칸에 도달 할 수있다.
     * 칸의 수 n이 주어질 때, 끝에 도달하는 방법의 개수를 1234567로 나눈 나머지를 리턴하라.
     */

    public static void main(String[] args) {
        int n = 2000;
        Solution solution = new Solution();

        System.out.println("solution.solution(n) = " + solution.solution(n));

    }
}
