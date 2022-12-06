package code;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class day_06 {
    // Day 6: Tuning Trouble
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d6_input.txt";
        boolean second_part = true;
        int start_index = -1;
        int package_len = 4; // start of package
        if (second_part){
            package_len = 14; // start of message
        }

        Scanner scanner = new Scanner(new File(file_name));
        String signal = scanner.next();
        scanner.close();

        for (int i = 0; i < signal.length() - package_len; i++) {
            String package_str = signal.substring(i, i+package_len);
            Set<Character> package_set = package_str.chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            if(package_set.size() == package_len){
                start_index = i + package_len;
                break;
            }
        }

        System.out.println(start_index);
    }

}

