package algorithm.algo052_algo079;

public class Algorithm059 {
    /**
     * 덧칠하기
     */
    public static void main(String[] args) {
        int n = 10; // 벽 총 길이
        int m = 4; // 페인트 롤러 크기
        int[] section = {1, 5, 6, 7, 8};
        int answer = 0;

        int paintRange = 0;

        for (int i : section) {
            if (paintRange != 0 && i < paintRange) continue;
            else {
                paintRange = i + m;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
