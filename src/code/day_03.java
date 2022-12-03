package code;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class day_03 {
    // Day 3: Rucksack Reorganization
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d3_input.txt";

        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("\n");

        if (false){
            System.out.println(getPriorityForRucksack(scanner));    // first part
        }
        else{
            System.out.println(getPriorityForTeam(scanner));        // second part
        }

    }
    private static int getPriorityForTeam(Scanner scanner){
        int priority = 0;
        while (scanner.hasNext()) {
            String first_rucksack = scanner.next();
            String second_rucksack = scanner.next();
            String thrid_rucksack = scanner.next();

            Set<Character> first_set = first_rucksack.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            Set<Character> second_set = second_rucksack.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            Set<Character> third_set = thrid_rucksack.chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            Set<Character> intersectSet = new HashSet<>(first_set);
            intersectSet.retainAll(second_set);
            intersectSet.retainAll(third_set);
            char common_char = (char) intersectSet.toArray()[0];

            priority += getPriorityForItem(common_char);
        }
        scanner.close();
        return priority;
    }

    private static int getPriorityForRucksack(Scanner scanner){
        int priority = 0;
        while (scanner.hasNext()) {
            String items = scanner.next();

            String first_half = items.substring(0, items.length() / 2);
            String second_half = items.substring(items.length() / 2);

            Set<Character> first_set = first_half.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            Set<Character> second_set = second_half.chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            Set<Character> intersectSet = new HashSet<>(first_set);
            intersectSet.retainAll(second_set);
            char common_char = (char) intersectSet.toArray()[0];

            priority += getPriorityForItem(common_char);
        }
        scanner.close();
        return priority;
    }

    private static int getPriorityForItem(char character){
        int priority;
        if (Character.isLowerCase(character)) {
            priority = character - 'a' + 1;
        }
        else {
            priority = character - 'A' + 27;
        }
        return priority;
    }

}

