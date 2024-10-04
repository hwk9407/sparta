package algorithm;

public class Algorithm077 {
    /**
     * 이진 변환 반복하기
     * 1. 0과 1로 이루어진 문자열 s
     * 2. 0제거 후 만들어진 길이를 2진법으로 표현
     *
     * 1, 2번을 n회 반복 제거한 0의 갯수 m개
     * 반환{n, m}
     */

    public static void main(String[] args) {
        String s = "110010101001";
        int delZero = 0;
        int count = 0;
        while (!s.equals("1")) {
            int size = s.length();
            s = s.replace("0", "");
            delZero += size - s.length();

            s = Integer.toBinaryString(s.length());
            count++;
        }

        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = delZero;

        System.out.println(answer[0] + " " + answer[1]);
    }
}
