package algorithm.algo094;

class Solution {
    public int solution(int[] numbers, int target) {


        int result = dfs(numbers, target, 0, 0);

        return result;
    }

    private int dfs (int[] numbers, int target, int sumCount, int index) {

        // index 가 넘어갈 시 최종 종료
        if (index == numbers.length) {
            return sumCount == target ? 1 : 0;
        }

        // 더하는 경우와 빼는 경우
        int add = dfs(numbers, target, sumCount + numbers[index], index + 1);
        int sub = dfs(numbers, target, sumCount - numbers[index], index + 1);

        // 두 가지 경우의 수를 합하여 반환
        return add + sub;
    }
}


public class Algorithm094 {
    /**
     * <h1>타겟 넘버</h1>
     * <p>
     * n개의 음이 아닌 정수들이 있습니다.<br>
     * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
     * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.<br>
     * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
     * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록
     * solution 함수를 작성해주세요.
     * <p>
     * <h1>제한사항</h1>
     * <p>
     * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.<br>
     * 각 숫자는 1 이상 50 이하인 자연수입니다.<br>
     * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
     */
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, target));
    }
}
