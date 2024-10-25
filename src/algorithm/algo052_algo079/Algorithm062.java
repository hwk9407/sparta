package algorithm.algo052_algo079;


import java.util.Arrays;
import java.util.HashSet;

public class Algorithm062 {
    /**
     * 062. 옹알이 (2)
     * "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못함
     * 연속해서 같은 발음 못함
     * babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수
     */
    public static void main(String[] args) {
        String[] babbling = {"yeayaye"};
        int answer = 0;

        HashSet<String> canTalk = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));


        for (String word : babbling) {
            String lastDeleteString = "";
            StringBuilder sb = new StringBuilder(word);
            System.out.println("word: " + word);
            while (true) {
                boolean checkFlag = false;

                for (String s : canTalk) {
                    if (sb.length() == 0) {
                        break;
                    }

                    if (sb.indexOf(s) == 0 && !lastDeleteString.equals(s)) {
                        lastDeleteString = s;
                        int startIndex = sb.indexOf(s);
                        sb.delete(startIndex, startIndex + s.length());
                        checkFlag = true;
                        if (sb.length() == 0) {
                            answer++;
                        }
                    }
                }

                if (!checkFlag) break;
            }
        }

        System.out.println(answer);


    }
}
