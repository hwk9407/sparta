package algorithm.algo052_algo079;

public class Algorithm060 {
    /**
     * 기사단원의 무기
     * 각 기사에게 1번 ~ number까지 번호가 지정되어 있다.
     * 기사들은 무기점에서 무기를 구매하려한다.
     * 기사 번호의 약수 개수에 대항하는 공격력을 가진 무기를 구매하려한다.
     * 공격력은 협약기관에서 정한 무기공격력을 넘기면 power의 공격력을 가진 무기를 강매한다.
     * 모든 기사의 무기의 공격력을 더한 값을 반환하는 함수를 만들라.
     */
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int damage = countDivisors(i);
            if (damage > limit) answer += power;
            else answer += damage;
        }
        System.out.println(answer);

    }

    // 약수의 갯수를 구하는 메서드
    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // 나누어 떨어지면 약수
            if (n % i == 0) {
                // 중복된 약수는 한 개만 추가
                if (n / i == i) {
                    count++;
                // 그 외 모든 경우의 수는 두 개 추가
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
