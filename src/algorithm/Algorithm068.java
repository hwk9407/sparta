package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Algorithm068 {
    /**
     * 햄버거 만들기
     * 함께 일하는 다른 직원이 재료를 조리해 준다.
     * 상수 앞에 조리된 순서대로 아래서부터 위로 쌓이게 된다.
     * 상수는 순서에 맞게 (아래서부터 빵 - 야체 - 고기 - 빵) 포장을 한다.
     * 포장하는 동안에는 재료가 추가적으로 들어오는 일은 없다.
     * <p>
     * ex)
     * {야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵}
     * 6번째 재료 들어올 때 햄버거 한 개
     * 9번째 재료 들어올 때 햄버거 두 개
     * 총 2개 포장하게 된다.
     * <p>
     * (1 (1 2 3 1) 2 3 1)   2개
     * (1 2 3 1) (1 2 3 1)   2개
     * 1 2 (1 2 3 1) 2 3 1   1개
     */

    public static void main(String[] args) {
        int[] ingredient = {1, 2, 3, 1, 1, 2, 3, 1}; // 1 = 빵, 2 = 야채, 2 = 고기
//        int[] ingredient = {1, 2, 3, 1}; // 1 = 빵, 2 = 야채, 2 = 고기
        int answer = 0; // (빵 - 야체 - 고기 - 빵) 포장된 갯수

        // 콤보를 기억하는 변수
        int combo = 0;
        List<Integer> ingreList = new ArrayList<Integer>();
        for (int i : ingredient) {
            // 일단 list에 추가
            ingreList.add(i);

            // combo = 3이라면 다음에 오는게 1(빵)이면 완성 1개 추가하고 사용된 재료 지워야함
            if (combo == 3) {
                if (i == 1) {
                    combo = 0;
                    answer++;
                    // 재료 4개 지움
                    for (int j = 0; j < 4; j++) {
                        ingreList.remove(ingreList.size() - 1);
                    }
//                    System.out.println("한 개 완성!" + ingreList);
                }
            }

            // 처음이 아니면 앞 재료가 연속하는지 확인해야함
            if (!ingreList.isEmpty()) {
                combo = comboCheck(ingreList);
//                System.out.println("콤보 확인 결과 : " + combo);
            }
        }

        System.out.println("총 완성 갯수 : " + answer);
    }

    // 앞 재료가 연속하는지 확인하는 메서드
    public static int comboCheck(List<Integer> ingreList) {
        // 마지막 저장된 값
        int reverseCombo = ingreList.get(ingreList.size() - 1);

        // 1이면 1반환
        if (reverseCombo == 1) return reverseCombo;

        // 역순
        for (int i = ingreList.size() - 2; i >= 0; i--) {
            // 연속된 값이면 계속 진행
            if (reverseCombo == ingreList.get(i) + 1) {
                reverseCombo--;

                // 1에 도달하면 마지막 값 반환
                if (reverseCombo == 1) {
                    return ingreList.get(ingreList.size() - 1);
                }

                // 불규칙은 0 반환
            } else {
                return 0;
            }
        }

        return 0;
    }
}
