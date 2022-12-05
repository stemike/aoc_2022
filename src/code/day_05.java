package code;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class day_05 {
    // Day 5: Supply Stacks
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d5_input.txt";
        boolean second_part = true;
        int start_index = 1;
        int space_between_entries = 4;

        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("\n\n");
        String stack_strs = scanner.next();

        int num_stacks = 9;
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < num_stacks; i++) {
            stacks.add(new Stack<>());
        }

        // remove last line
        stack_strs = stack_strs.substring(0, stack_strs.lastIndexOf("\n"));
        String[] split_stacks = stack_strs.split("\n");
        for (int i = 0; i < split_stacks.length; i++) {
            // go in reverse order through stacks to add them to collection
            String stack_row = split_stacks[split_stacks.length - (i + 1)];
            for (int j = 0; j < num_stacks; j++) {
                int char_index = start_index + j * space_between_entries;
                if (stack_row.charAt(char_index) != ' '){
                    stacks.get(j).push(stack_row.charAt(char_index));
                }
            }
        }

        String[] orders = scanner.next()
                .replace("move ", "")
                .replace("from ", "")
                .replace("to ", "")
                .split("\n");
        scanner.close();

        for (String order: orders) {
            // n_crates, source_crate, target_crate
            int[] order_numbers = Arrays.stream(order.split(" ")).mapToInt(Integer::parseInt).toArray();
            char[] crates = new char[order_numbers[0]];
            // Find crates to move, done this way to make switching between first and second part easy
            for (int i = 0; i < order_numbers[0]; i++) {
                crates[i] = stacks.get(order_numbers[1] - 1).pop();
            }
            if(second_part){
                // Reverse Array to keep same order of elements (they are moved all at once)
                invertUsingFor(crates);
            }
            // Move crates
            for (char crate: crates) {
                stacks.get(order_numbers[2] - 1).push(crate);
            }
        }

        for (Stack<Character> stack:stacks) {
            System.out.print(stack.peek());
        }

    }

    private static void invertUsingFor(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = (char) temp;
        }
    }

}

