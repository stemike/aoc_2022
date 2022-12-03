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
        boolean part_two = true;
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

            if(part_two){
                round[1] = getPlayerMove(round[0], round[1]);
            }

            score += getScoreForRound(round[0], round[1]);
        }
        scanner.close();
        System.out.println(score);
    }

    private static int getPlayerMove(int opponent, int outcome){
        // outcome values: 0 Lose, 1 Draw, 2 Win
        if(outcome == 1){
            return opponent;
        } else if ((outcome == 0 && opponent == 1) || (outcome == 2 && opponent == 2)) {
            return 0; // rock
        } else if ((outcome == 0 && opponent == 2) || (outcome == 2 && opponent == 0)) {
            return 1; // paper
        } else{
            return 2; // scissor
        }
    }
    private static int getScoreForRound(int opponent, int player) {
        int score = 0;
        // Win Scenarios
        if ((player == 0 && opponent == 2) || (player == 1 && opponent == 0) || (player == 2 && opponent == 1)){
            score += 6;
        } else if (opponent == player) {
            score += 3;
        }
        score += player + 1;
        return score;
    }
}

