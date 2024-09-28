package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Algorithm069 {
    /**
     * 성격 유형 검사하기
     * 1번 지표	라이언형(R), 튜브형(T)
     * 2번 지표	콘형(C),     프로도형(F)
     * 3번 지표	제이지형(J), 무지형(M)
     * 4번 지표	어피치형(A), 네오형(N)
     * <p>
     * choices	    뜻
     * 1	    매우 비동의
     * 2	    비동의
     * 3	    약간 비동의
     * 4	    모르겠음
     * 5	    약간 동의
     * 6	    동의
     * 7	    매우 동의
     */

    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        HashMap<String, Integer> typeMap = new HashMap<>();

        typeMap.put("RT", 0);
        typeMap.put("CF", 0);
        typeMap.put("JM", 0);
        typeMap.put("AN", 0);

        for (int i = 0; i < survey.length; i++) {
            boolean reverseFlag = survey[i].charAt(0) > survey[i].charAt(1);

            // 정렬
            if (reverseFlag) {
                survey[i] = String.valueOf(survey[i].charAt(1)) + String.valueOf(survey[i].charAt(0));
                choices[i] = 8 - choices[i];
            }
            typeMap.put(survey[i], typeMap.get(survey[i]) + 4 - choices[i]);
        }

        // 성격 유형 만들기
        StringBuilder sb = new StringBuilder();
        if (typeMap.get("RT") >= 0) {
            sb.append("R");
        } else sb.append("T");

        if (typeMap.get("CF") >= 0) {
            sb.append("C");
        } else sb.append("F");

        if (typeMap.get("JM") >= 0) {
            sb.append("J");
        } else sb.append("M");

        if (typeMap.get("AN") >= 0) {
            sb.append("A");
        } else sb.append("N");

        String answer = sb.toString();

        System.out.println("choices = " + Arrays.toString(choices));
        System.out.println("typeMap = " + typeMap);
        System.out.println("answer = " + answer);
    }
}
