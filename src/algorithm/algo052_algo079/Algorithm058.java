package algorithm.algo052_algo079;


import java.util.ArrayList;
import java.util.List;

public class Algorithm058 {
    /**
     * 소수 만들기
     * 주어진 숫자중 택3 해서 더했을 대 소수가 되는 경우의 갯수를 구하기
     * <p>
     * 소수 판별
     * 에라토스테네스의 체 이용하기
     * 2부터 N까지 나열한다.
     *
     */
    public static void main(String[] args) {
        int[] nums = {3, 40, 100};
        int answer = 0;

        int max = 0;

        List<Integer> sumList = new ArrayList<>();


        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    max = Math.max(max, sum);
                    sumList.add(sum);
                }
            }
        }

        boolean[] isPrimeArray;
        isPrimeArray = isNotPrimeNumber(max);

        for (Integer sum : sumList) {
            if (!isPrimeArray[sum]) answer++;
        }

        System.out.println(answer);

    }

    // 에라토스테네스의 체 의 방법을 이용한 소수 판별
    public static boolean[] isNotPrimeNumber(int maxNum) {
        if (maxNum == 0) {
            return new boolean[]{true};
        }

        // 0과 1은 소수가 아니다.
        boolean[] primeNumbers = new boolean[maxNum + 1];
        primeNumbers[0] = true;
        primeNumbers[1] = true;

        // 제곱근 이상값까지 순회 불필요
        for (int i = 2; i <= Math.sqrt(maxNum); i++) {

            // 이미 소수가 아닌 수는 스킵
            if (primeNumbers[i]) continue;

            /*
              i = 2일 때
              j = 2 * 2 = 4    4 + 2 = 2 * 3 = 6           6 + 2 = 8 ...

              i = 3일 때
              j = 3 * 3 = 9    9 + 3 = 3 * 4 = 12          12 + 3 = 15 ...

              i = 4일 때
              j = 4 * 4 = 16   16 + 4 = 4 * 5 = 20         20 + 4 = 4 * 6 = 24 ...

              초기값을 j = i * 2로 하지않고 i * i로 하는 이유는 이미 이전 단계에서 순회를 돌았기 때문이다.
             */
            for (int j = i * i; j < maxNum + 1; j += i) primeNumbers[j] = true;

        }
        // false : 소수       true : 소수 아님
        return primeNumbers;
    }
}
