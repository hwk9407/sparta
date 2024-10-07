package algorithm;

public class Algorithm078 {
    /**
     * 피보나치 수
     *
     * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
     * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
     */

    public static void main(String[] args) {
        int n = 6; // n >= 2
        int answer = 0;

        int twiceBefore = 0;
        int justBefore = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            current = (twiceBefore + justBefore) % 1234567;
            twiceBefore = justBefore;
            justBefore = current;
        }
        answer = current;
        System.out.println("answer = " + answer);
    }
}
