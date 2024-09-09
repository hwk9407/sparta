package algorithm;

public class Algorithm052 {
    public static void main(String[] args) {

        int a = 3;      // a개의 빈병을 갖다주면
        int b = 2;      // b개의 새콜라 줌
        int n = 20;     // 콜라 n개 스타트

        int answer = 0;


        while (!(n < a)) {
            int newCola = n;
            int remainCola = newCola % a;
            newCola = newCola / a * b;
            n = newCola + remainCola;

            answer += newCola;
        }


        System.out.println("총 콜라 : " + answer);

    }
}
