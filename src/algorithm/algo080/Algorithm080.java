package algorithm.algo080;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while (true) {
            round++;
            // a, b 참가자가 만난 경우
            if ((a + 1) / 2 == (b + 1) / 2) {
                break;
            }
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            n /= 2;

        }

        return round;
    }
}

public class Algorithm080 {
    /**
     * 예상 대진표
     * 대회에 N명 참가하고, 1번부터 N번을 차례대로 배정받습니다.
     * 1번 - 2번,     3번 - 4번  ...   N-1번 - N번  참가자끼리 게임하여 승리시 다음 라운드 진출합니다.
     * 다음 라운드 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다.
     * A, B 참가자가 항상 이겼을 때 몇 번째 라운드에 만나는지 return 해주세요.
     * N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
     * A, B : N 이하인 자연수 (단, A ≠ B 입니다.)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 4, 7));
    }
}

