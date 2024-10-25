package algorithm.algo090;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        // 기본값: 1, 이미 값이 있다면 + 1 로 부위별 map 초기화
        for (String[] clothe : clothes) {
            int currentValue = map.getOrDefault(clothe[1], 0);
            map.put(clothe[1], currentValue + 1);
        }

        answer = countFashion(map);

        // 2, 1 인 경우 5
        // 3 인 경우 3
        return answer;
    }

    private int countFashion(HashMap<String, Integer> map) {
        int size = map.size();

        // 옷 종류가 한 가지인 경우 갖고있는 옷이 총 패션의 수
        if (size == 1) return map.values().iterator().next();

        // 옷 종류가 두 가지이상인 경우 (옷 종류1 개수 + 1) * (옷 종류2 개수 + 1) * ... - 1이 총 패션의 수
        int result = 1;
        for (String key : map.keySet()) {
            result *= map.get(key) + 1;
        }
        return result - 1;
    }
}
public class Algorithm090 {
    /**
     * 의상
     *
     * 매일 다른 옷을 조합하여 입으려 한다.
     * 종류 별로 최대 1가지 의상만 착용 가능하다.(동시에 2개 이상 착용 불가)
     * 착용한 의상 일부가 겹치더라도 다른 의상이 바뀌거나 하면 다른 조합으로 계산한다.
     * 코니는 하루에 최소 한개 의상은 입는다. (알몸 불가)
     *
     * 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int result = solution.solution(clothes);
        System.out.println(result);
    }
}
