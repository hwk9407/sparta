package algorithm.algo095;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 설명<br>
 * 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
 * <p>
 * - 0P0처럼 소수 양쪽에 0이 있는 경우<br>
 * - P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우<br>
 * - 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우<br>
 * - P처럼 소수 양쪽에 아무것도 없는 경우<br>
 * - 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.<br>
 *   - 예를 들어, 101은 P가 될 수 없습니다.<br>
 * 예를 들어, 437674을 3진수로 바꾸면 211020101011입니다.
 * 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다.
 * (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.)
 * 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
 * <p>
 * 정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 */
class Solution {
    public int solution(int n, int k) {

        // 1. 정수 n을 k진수로 변환
        String kDecimalNum = Integer.toString(n, k);
        // 2. 덩어리를 나눔. 소수면 primeCount 1추가
        /*List<Long> numberGroup = Arrays.stream(kDecimalNum.split("0"))
                .filter(str -> !str.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());*/
        String[] kDecimalSplitString = kDecimalNum.split("0");
        List<Long> numberGroup = new ArrayList<>();
        for (int i = 0; i < kDecimalSplitString.length; i++) {
            if (kDecimalSplitString[i].isEmpty()) continue;
            numberGroup.add(Long.parseLong(kDecimalSplitString[i]));
        }

        // 3. 나눠진 10진수 리스트 요소들이 소수인 경우 primeCount + 1
        int primeCount = 0;
        for (Long num : numberGroup) {
            if (isPrimeNumber(num)) primeCount++;
        }

        return primeCount;
    }

    private boolean isPrimeNumber(Long num) {
        if (num < 2) return false;

        // 2를 제외한 짝수는 소수가 아님
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        // 제곱근까지 나누어 떨어지는 수는 소수가 아님
        long sqrt = (long)Math.sqrt(num) + 1;
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }

        // 위 조건을 모두 만족하는 수는 소수임
        return true;
    }
}

public class Algorithm095 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(437674, 3)); // expected: 3
        System.out.println(solution.solution(110011, 10)); // expected: 2
    }
}
