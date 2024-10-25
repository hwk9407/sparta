package algorithm.algo052_algo079;

import java.util.Arrays;

public class Algorithm073 {
    /**
     * 073. 공원 산책
     * 지나다니는길을 'O' , 장애물을 'X'로 시작위치를 S 나타낸 직사각형 격자 모양의 공원
     * 예를들어 "E 5"는 동쪽으로 5칸을 이동했음을 의미
     *
     * 이동 명령 수행 전 두 가지를 확인
     * 1. 공원을 벗어나지 않는지
     * 2. 이동 중 장애물을 만나는지
     * 하나라도 해당 시 해당 명령을 스킵 후 다음 명령어를 수행.
     * 공원의 가로:W 세로:H 라 할 때 왼쪽 위가 (0, 0) 오른쪽 아래가 (H-1, W-1)
     */

    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        int[] answer = new int[2];

        int[] parkSizes = new int[2];
        parkSizes[0] = park.length;
        parkSizes[1] = park[0].length();


        // 시작 좌표 찾기
        for (int h = 0; h < parkSizes[0]; h++) {
            int w = park[h].indexOf('S');

            if (w != -1) {
                answer[0] = h;
                answer[1] = w;
                park[h] = park[h].replace('S', 'O');
                break;
            }
        }



        // routes 명령 순서대로 move 메서드 수행
        for (String route : routes) {
            answer = move(parkSizes, answer, route, park);
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    // 명령을 수행하는 메서드 성공시 이동좌표, 실패시 원래좌표 반환
    private static int[] move(int[] parkSize, int[] pos, String route, String[] park) {
        int h = pos[0];
        int w = pos[1];

        String[] rArr = route.split(" ");
        String direction = rArr[0];
        int distance = Integer.parseInt(rArr[1]);

        distance = (direction.equals("W") || direction.equals("N")) ? -distance : distance;

        // 가로 방향
        if (direction.equals("W") || direction.equals("E")) {


            // 이동 후 가로 좌표가 공원 밖이면 원래 좌표 반환
            if (distance > 0 && w + distance >= parkSize[1] || distance < 0 && w + distance < 0) {
                return pos;
            }

            for (int i = 0; i < Math.abs(distance); i++) {
                w = distance > 0 ? w + 1 : w - 1;

                // 장애물 만나면 원래 좌표 반환
                if (park[h].charAt(w) == 'X') return pos;
            }
        } else if (direction.equals("N") || direction.equals("S")) {

            // 이동 후 세로 좌표가 공원 밖이면 원래 좌표 반환
            if (distance > 0 && h + distance >= parkSize[1] || distance < 0 && h + distance < 0) {
                return pos;
            }

            for (int i = 0; i < Math.abs(distance); i++) {
                h = distance > 0 ? h + 1 : h - 1;

                // 장애물 만나면 원래 좌표 반환
                if (park[h].charAt(w) == 'X') return pos;
            }
        }

        pos[0] = h;
        pos[1] = w;

        return pos;
    }
}
