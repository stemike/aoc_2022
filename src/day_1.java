import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class day_1 {
    public static void main(String[] args) throws IOException {
        String file = "src/data/d1_input.txt";
        int max_calories = -1;

        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n\n");
        while (scanner.hasNext()) {
            int calorie_sum = Arrays.stream(scanner.next().split("\n")).mapToInt(Integer::parseInt).sum();
            if (calorie_sum > max_calories) {
                max_calories = calorie_sum;
            }
        }
        scanner.close();
        System.out.println(max_calories);
    }
}

