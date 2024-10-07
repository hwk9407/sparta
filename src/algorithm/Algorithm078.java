package algorithm;

public class Algorithm078 {
    /**
     * 피보나치 수
     *
     * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
     * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
     */
    private static int[] arr;

    public static void main(String[] args) {
        int n = 3; // n >= 2
        int answer = 0;

        arr = new int[n + 1];
        answer = fibo(n);

        System.out.println("answer = " + answer);

    }

    private static int fibo(int num) {
        if (num == 0) return 0;
        else if (num == 1) return 1;

        // 메모이제이션 알고리즘 기법
        // 이미 계산된 결과를 저장하여 불필요한 계산을 피함
        if (arr[num] != 0) return arr[num];

        return fibo(num - 2) + fibo(num - 1);
    }
}
