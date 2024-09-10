package algorithm;

import java.time.LocalDate;

public class Algorithm054 {
    /**
     * 윤년 : 4년마다 오며 2월달이 29일인 해
     * 2016년 1월 1일 금요일
     * SUN,MON,TUE,WED,THU,FRI,SAT
     */
    public static void main(String[] args) {
        int a = 12;
        int b = 24;
        String answer = "";

        int[] monthlyDateSize = {4, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30}; //2016년 1월 1일이 금요일이 오게 + 4, 12월달의 31일값은 내년에 필요한 수치이므로 필요없음
        String[] stringDayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int calculateDate = b;

        for (int i = 0; i < a; i++) {
            calculateDate += monthlyDateSize[i];
        }

        int intDayOfWeek = (calculateDate) % 7;

        answer = stringDayOfWeek[intDayOfWeek];

        System.out.println(answer);





    }
}
