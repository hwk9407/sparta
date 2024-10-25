package algorithm.algo052_algo079;

public class Algorithm076 {
    /**
     * JadenCase 문자열 만들기
     * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
     * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
     * 주어진 문자열 S를 JadenCase 로 바꾼 문자열을 리턴하라.
     */

    public static void main(String[] args) {
        String s = " 3people unFollowed me  ";
        String answer = "";


        String[] sArr = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();

        for (String str : sArr) {
            str = changeJadenCase(str);
            sb.append(str).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        answer = sb.toString();
//        System.out.println("answer = [" + sb + "]");
    }

    private static String changeJadenCase(String str) {
        if (str.isEmpty()) return str;
        str = str.toLowerCase();



        char ch = str.charAt(0);

        // 숫자인 경우 다음 문자열 준비
        if (Character.isDigit(ch)) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toUpperCase(ch));
        str = sb.toString();

        return str;
    }
}