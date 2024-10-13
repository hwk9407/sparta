package algorithm.algo084;

class Solution {
    public int solution(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        // 0부터 x를 순회한다.
        for (int x = 0; x < s.length(); x++) {

            // 괄호 문자열 인지 검사 isBracket(str)
            if (isBracket(sb)) count++;

            // 왼쪽으로 한칸 회전시키는 메서드 leftRotation(str)
            leftRotation(sb);
        }

        return count;
    }

    private void leftRotation(StringBuilder sb) {

        char c = sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(c);
    }

    private boolean isBracket(StringBuilder sb) {

        int index = 0;
        StringBuilder str = new StringBuilder(sb);
        while (str.length() > 0 && index < str.length() - 1) {

            boolean bracketPairFlag =
                    (str.charAt(index) == '(' && str.charAt(index + 1) == ')') ||
                            (str.charAt(index) == '{' && str.charAt(index + 1) == '}') ||
                            (str.charAt(index) == '[' && str.charAt(index + 1) == ']');

            if (!bracketPairFlag) {
                index++;
                continue;
            }

            str.delete(index, index + 2);
            if (index != 0) index--;

        }

        return str.length() == 0;
    }
}

public class Algorithm084 {
    /**
     * 괄호 회전하기
     * (), {}, [] 는 모두 올바른 괄호 문자열이다.
     * A가 괄호 문자열이라면, (A), {A}, [A] 도 올바른 괄호 문자열이다. (= 중첩 인정)
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어질 때
     * s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
     * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하라
     * <p>
     * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
     * 0	"[](){}"	O
     * 1	"](){}["	X
     * 2	"(){}[]"	O
     * 3	"){}[]("	X
     * 4	"{}[]()"	O
     * 5	"}[](){"	X
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "[](){}";
        String s = "}}}";

        System.out.println("result = " + solution.solution(s));
    }
}
