package algorithm;

import java.util.Arrays;

public class Algorithm055 {
    public static void main(String[] args) {
        // Yes
        String[] cards1 = {"i", "drink", "water"};
        // No
//        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = "";

        boolean canMake = true;
        int[] saveIndex = {0, 0};


        for (int i = 0; i < goal.length; i++) {

            if (saveIndex[0] < cards1.length
                    && cards1[saveIndex[0]].equals(goal[i])) {
                saveIndex[0]++;
            } else if (saveIndex[1] < cards2.length
                    && cards2[saveIndex[1]].equals(goal[i])) {
                saveIndex[1]++;
            }else {
                canMake = false;
                break;
            }
        }

        answer = canMake ? "Yes" : "No";

        System.out.println(answer);
    }
}
