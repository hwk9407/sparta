package algorithm.algo096;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * <h1>주차 요금 계산
 * <p>
 * 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다.
 * 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다.
 * 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.<br><br>
 * - 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.<br>
 * - 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.<br>
 * - 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.<br>
 * - 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.<br>
 * - 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.<br>
 *
 * <p>
 * <h1>제한사항
 * <p>
 * fees[0] = 기본 시간(분) <br>
 * 1 ≤ fees[0] ≤ 1,439 <br>
 * fees[1] = 기본 요금(원) <br>
 * 0 ≤ fees[1] ≤ 100,000 <br>
 * fees[2] = 단위 시간(분) <br>
 * 1 ≤ fees[2] ≤ 1,439 <br>
 * fees[3] = 단위 요금(원) <br>
 * 1 ≤ fees[3] ≤ 10,000 <br>
 * <p>
 * fees의 길이 = 4<br>
 * 1 ≤ records의 길이 ≤ 1,000<br>
 * records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다. <br>
 * 하나의 공백으로 구분되어 있다. <br>
 * 시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다. <br>
 * HH:MM은 00:00부터 23:59까지 주어집니다. <br>
 * 잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다. <br>
 * 차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다. <br>
 * 내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다. <br>
 * records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다. <br>
 * records는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다. <br>
 * 같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다. <br>
 * 마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다. <br>
 * 아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다. <br>
 * 주차장에 없는 차량이 출차되는 경우 <br>
 * 주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우
 */

class Solution {
    public int[] solution(int[] fees, String[] records) {

        // 차량 번호를 key, 누적시간을 갖는 TreeMap(String, Long) 자료구조 생성
        TreeMap<String, Long> carParkingTimeMap = new TreeMap<>();

        // records[] 를 파싱하여 IN, OUT 정리
        for (int i = 0; i < records.length; i++) {
            String[] parsedInRecord = records[i].split(" ");

            // 입차 기록만 수행
            if (parsedInRecord[2].equals("OUT")) continue;
            Boolean outFlag = false;
            for (int j = i + 1; j < records.length; j++) {
                String[] parsedOutRecord = records[j].split(" ");

                // 출차 기록만 수행 + 다른번호면 continue
                if (parsedOutRecord[2].equals("IN")) continue;
                if (!parsedOutRecord[1].equals(parsedInRecord[1])) continue;

                // 차량별로 누적 주차 시간 계산하기
                outFlag = true;
                long parkingTime = calculateParkingTime(parsedInRecord[0], parsedOutRecord[0]);
                long totalTime = carParkingTimeMap.getOrDefault(parsedInRecord[1], 0L) + parkingTime;
                carParkingTimeMap.put(parsedInRecord[1], totalTime);
                break;
            }

            // 출차 기록이 없는 경우 23:59에 나간거로 연산
            if (!outFlag) {
                long parkingTime = calculateParkingTime(parsedInRecord[0], "23:59");
                long totalTime = carParkingTimeMap.getOrDefault(parsedInRecord[1], 0L) + parkingTime;
                carParkingTimeMap.put(parsedInRecord[1], totalTime);
            }
        }
        // fees[]에 적혀있는 요금표 대로 정산하기
        int[] result = new int[carParkingTimeMap.size()];
        int carIndex = 0;
        for (String carNum : carParkingTimeMap.keySet()) {
            int totalPrice;
            long totalParkingTime = carParkingTimeMap.get(carNum);

            // 기본요금 정산
            if (fees[0] > totalParkingTime) {
                totalPrice = fees[1];
            } else {
                long overTime = (totalParkingTime - fees[0] + (fees[2]- 1)) / fees[2];
                totalPrice = (int) (fees[1] + overTime * fees[3]);
            }
            result[carIndex] = totalPrice;
            carIndex++;
        }

        return result;
    }

    private long calculateParkingTime(String in, String out) {
        LocalTime inTime = LocalTime.parse(in);
        LocalTime outTime = LocalTime.parse(out);

        return ChronoUnit.MINUTES.between(inTime, outTime);
    }
}

public class Algorithm096 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Arrays.stream(solution.solution(fees, records))
                .forEach(System.out::println);
    }
}
