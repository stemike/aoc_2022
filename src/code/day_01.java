package code;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class day_01 {
    // Find the n Elves carrying the most Calories
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d1_input.txt";
        int n_elves = 3;
        int[] max_calories = new int[n_elves];

        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("\n\n");

        int placeholder;
        while (scanner.hasNext()) {
            int calorie_sum = Arrays.stream(scanner.next().split("\n")).mapToInt(Integer::parseInt).sum();
            for (int i = 0; i < n_elves; i++) {
                if (calorie_sum > max_calories[i]) {
                    placeholder = max_calories[i];
                    max_calories[i] = calorie_sum;
                    calorie_sum = placeholder;
                }
            }
        }

        scanner.close();
        System.out.println(Arrays.stream(max_calories).sum());
    }
}

