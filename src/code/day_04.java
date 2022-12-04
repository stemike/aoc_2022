package code;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class day_04 {
    // Day 4: Find Overlaps
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d4_input.txt";
        String elf_split_char = ",";
        String assignment_split_char = "-";
        boolean second_part = true;
        int counter = 0;


        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("\n");

        while (scanner.hasNext()) {
            String[] split_assignment = scanner.next().split(elf_split_char);
            int[] first_range = Arrays.stream(split_assignment[0].split(assignment_split_char))
                    .mapToInt(Integer::parseInt).toArray();
            int[] second_range = Arrays.stream(split_assignment[1].split(assignment_split_char))
                    .mapToInt(Integer::parseInt).toArray();
            if((!second_part && isInOther(first_range, second_range)) ||
                    (second_part && hasOverlap(first_range, second_range))){
                counter++;
            }
        }
        scanner.close();
        System.out.println(counter);
    }

    private static boolean hasOverlap(int[] firstRange, int[] secondRange) {
        return (secondRange[0] <= firstRange[0] && firstRange[0] <= secondRange[1]) ||
                (secondRange[0] <= firstRange[1] && firstRange[0] <= secondRange[1]) ||
                (firstRange[0] <= secondRange[0] && secondRange[0] <= firstRange[1]) ||
                (firstRange[0] <= secondRange[1] && secondRange[1] <= firstRange[1]);
    }
    private static boolean isInOther(int[] firstRange, int[] secondRange) {
            return (firstRange[0] >= secondRange[0] && firstRange[1] <= secondRange[1]) ||
                    (firstRange[0] <= secondRange[0] && firstRange[1] >= secondRange[1]);
    }


}

