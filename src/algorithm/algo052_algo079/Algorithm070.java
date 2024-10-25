package algorithm.algo052_algo079;

import java.util.Arrays;

public class Algorithm070 {
    /**
     * 바탕화면 정리
     * 바탕화면 상태를 나타내는 문자열 배열 wallpaper
     *
     * 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return 하는 함수를 작성하라.
     * 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return
     */

    public static void main(String[] args) {
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        int[] answer = {};

        int lux = 50; // wallpaper 최대 길이
        int luy = 50;
        int rdx = 0;
        int rdy = 0;

        for (int x = 0; x < wallpaper.length; x++) { // 세로축 순회
            for (int y = 0; y < wallpaper[x].length(); y++) { // 가로축 순회
                if (wallpaper[x].charAt(y) == '#') {
                    lux = Math.min(lux, x);
                    luy = Math.min(luy, y);

                    rdx = Math.max(rdx, x);
                    rdy = Math.max(rdy, y);
                }
            }
        }

        answer = new int[]{lux, luy, rdx + 1, rdy + 1};

        System.out.println(Arrays.toString(answer));
    }
}
