package algorithm.algo052_algo079;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm053 {
    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] answer = {};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            list.add(queue.peek());
        }

        answer = list.stream().mapToInt(i -> i).toArray();


//        System.out.println(Arrays.toString(answer));


    }
}
