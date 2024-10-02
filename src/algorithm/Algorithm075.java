package algorithm;

public class Algorithm075 {
    /**
     * 최댓값과 최솟값
     * 문자열 s에는 공백으로 구분된 숫자들이 저장되어있다.
     * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수를 만들라
     */

    public static void main(String[] args) {
        String s = "-1 -1";
        String answer = "";

        String[] split = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String numString : split) {
            min = Math.min(Integer.parseInt(numString), min);
            max = Math.max(Integer.parseInt(numString), max);
        }
        answer = min + " " + max;
        System.out.println("answer = " + answer);
    }
}
