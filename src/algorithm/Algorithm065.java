package algorithm;

public class Algorithm065 {
    /**
     * 문자열 나누기
     *
     * 문자가 s 입력했을때 다음 규칙을 따라 여러 분자열로 분해하려고 한다.
     * - 첫 글자를 읽는다. (x)
     * - 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 센다.
     * - 처음으로 두 개의 횟수가 같아 지는 순간 멈추고 읽은 문자열을 분리한다.
     * - 분리한 문자열을 빼고 남은 부분을 위의 과정을 반복한다. 남은 부분이 없다면 종료한다.
     * - 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 지금까지 읽은 문자열을 분리하고 종료
     */
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        char[] sArr = s.toCharArray();
        int answer = 1;
        boolean flag = false;

        for (int i = 0; i < sArr.length;) {
            char x = sArr[i];
            int sameChar = 0;
            int differentChar = 0;

            for(int j = i; j < sArr.length; j++) {
                char y = sArr[j];

                if(x == y) sameChar++;
                else differentChar++;

                if (j == sArr.length - 1) {
                    flag = true;
                }
                if (sameChar == differentChar) {
                    if (j != sArr.length - 1) {
                        answer++;
                    }
                    i = j + 1;
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println(answer);
    }
}
