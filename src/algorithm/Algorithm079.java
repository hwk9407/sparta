package algorithm;

public class Algorithm079 {
    /**
     * 079. 카펫
     * brown : 갈색 격자의 수
     * yellow : 노란색 격자의 수
     *
     *
     * 두 개가 주어질 때, 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하라.
     * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
     */

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        int[] answer = new int[2];

        int sum = brown + yellow;


        for (int i = (int) Math.sqrt(sum); i > 0 ; i--) {
            if (sum % i == 0 && ((sum / i) - 2) * (i - 2) == yellow) {
                answer[0] = sum / i;
                answer[1] = i;
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
