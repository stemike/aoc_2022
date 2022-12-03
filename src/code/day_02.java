package code;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class day_02 {
    // Rock Paper Scissor Tournament
    // A, B, C and X, Y, Z for R, P, S
    // Lose 0, Draw 3, Win 6 Points
    // 1, 2, 3 Points for R, P, S
    public static void main(String[] args) throws IOException {
        String file_name = "src/data/d2_input.txt";
        int score = 0;
        int opponent_rock_char = 'A';
        int player_rock_char = 'X';

        Scanner scanner = new Scanner(new File(file_name));
        scanner.useDelimiter("\n");

        String[] split_string;
        int[] round = new int[2];
        while (scanner.hasNext()) {
            split_string = scanner.next().split(" ");
            for (int i = 0; i < round.length; i++) {
                round[i] = split_string[i].charAt(0);
            }
            round[0] -= opponent_rock_char;
            round[1] -= player_rock_char;

            score += getScoreForRound(round[0], round[1]);
        }
        scanner.close();
        System.out.println(score);
    }

    private static int getScoreForRound(int opponent, int player) {
        int score = 0;
        // Win Scenarios
        if (player > opponent || (player == 0 && opponent == 2)){
            score += 6;
        } else if (opponent == player) {
            score += 3;
        }
        score += player + 1;
        return score;
    }
}

