package algorithm;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Algorithm063 {
    /**
     * 숫자 짝꿍
     * 정수x, y의 겹치는 수 k(자리상관없이, 같은 숫자는 가능, 했던 숫자는 불가능)를 이용해 가장 큰 수 만들기
     * 문자열로 반환
     *
     * 1. 겹치는 수를 찾는다.
     *
     * 3.
     */

    public static void main(String[] args) {
        String X = "100";
        String Y = "203045";
        String answer = "";


        HashMap<String, Integer> tempMap = new HashMap<>();
        for (String s : X.split("")) {
            tempMap.put(s, tempMap.getOrDefault(s, 0) + 1); // 값이 없으면 0 + 1 , 값이 있으면 get(str) + 1
        }
        ArrayList<String> arr = new ArrayList<>();

        for (String s : Y.split("")) {
            int count = tempMap.getOrDefault(s, 0);
            if (count > 0) {
                tempMap.put(s, count - 1);
                arr.add(s);
            }
        }
        if (arr.isEmpty()) {
            answer = "-1";
        } else {
            arr.sort(Comparator.reverseOrder());

            if (arr.get(0).equals("0")) answer = "0";
            else answer = String.join("", arr);
        }

        System.out.println(answer);
    }
}
