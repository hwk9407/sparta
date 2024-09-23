package algorithm;


import java.util.HashSet;

public class Algorithm064 {
    /**
     * 체육복
     * 도둑이 들어 일부 학생이 체육복을 도난당했다.
     * 여벌 체육복이 있는 학생이 한 번 빌려줄 수 있다.
     * 체격순으로 매겨져 있어, 바로 앞번호나 바로 뒷번호 학생에게만 빌려줄 수 있다.
     * 체육복이 없는 학생이 없게 최대한 빌리게 해야한다.
     * 여벌 체육복 있는 학생이 도난 당할 수도 있다. 이 경우 못빌려 준다.
     */
    public static void main(String[] args) {
        int n = 5; // 전체 학생 수
        int[] lost = {4, 5}; // 도난 당한 학생
        int[] reserve = {3, 4}; // 여벌 체육복이 있는 학생
        int answer = 0; // 빌려 주고 난 뒤 체육복 갖고있는 학생 수

        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        for (int lostNum : lost) {
            lostSet.add(lostNum);
        }

        for (int reserveNum : reserve) {
            if (lostSet.contains(reserveNum)) {
                lostSet.remove(reserveNum);
                continue;
            }
            reserveSet.add(reserveNum);
        }
        System.out.println("lostSet: " + lostSet);
        System.out.println("reserveSet: " + reserveSet);


        for (int reserveNum : reserveSet) {
            if (lostSet.contains(reserveNum - 1)) {
                lostSet.remove(reserveNum - 1);
            } else if (lostSet.contains(reserveNum + 1)) {
                lostSet.remove(reserveNum + 1);
            }
        }

        answer = n - lostSet.size();

        System.out.println(n - lostSet.size());

    }
}
