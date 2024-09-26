package algorithm;

import java.util.HashSet;

public class Algorithm067 {
    /**
     * 둘만의 암호
     * 문자열 s, skip
     * 자연수 index
     * 규칙에 따라 문자열을 만들려 한다.
     * s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔준다.
     * index 만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아간다.
     * skip에 있는 알파벳은 제외하고 건너뛴다.
     */

    public static void main(String[] args) {
        String s = "aukksz";
        String skip = "wbqd";
        int index = 5;
        String answer = "";
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> skipSet = new HashSet();
        for (char c : skip.toCharArray()) {
            skipSet.add((int) c);
        }

        // s의 각 문자들을 char타입으로 순회한다
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            // System.out.println(indexRange[0] + " ~ " + indexRange[1]);
            int[] indexRange = {c, c + index};
            int cnt = countSkip(skipSet, indexRange[0], indexRange[1]);
            c += index + cnt;
            c = charRangeInt(c);
            sb.append(c);

        }
        answer = sb.toString();

        System.out.println(answer);

    }

    // set 객체에 min ~ max 사이의 값이 몇 개 있는지 반환하는 메서드
    // count가 0이 될 때까지 반복
    public static int countSkip(HashSet<Integer> set, int min, int max) {
        int count = 0;

        min = charRangeInt(min);
        max = charRangeInt(max);

        for (int num : set) {
            if (max < min) {
                if (num >= min && num <= 122 || num >= 97 && num <= max) {
                    count++;
                }
            } else {
                if (num >= min && num <= max) {
                    count++;
                }
            }
        }
        System.out.println("countSkip반환값 : " + count);
        if (count == 0) return 0;
        return count + countSkip(set, max + 1, max + count);
    }

    // 122 초과한 int값을 범위로 넣어주는 메서드
    public static char charRangeInt(int i) {
        if (i > 122) {
            return (char) charRangeInt(i - 26);
        } else {
            return (char) i;
        }
    }
}
