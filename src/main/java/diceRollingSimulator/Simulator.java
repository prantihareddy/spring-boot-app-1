package diceRollingSimulator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean appCompleted = false;
        do {
            try {
                System.out.println("how many dice do you want to roll");
                int numberOfDice = scanner.nextInt();
                appCompleted = true;
                // 1. Store the roll values first
                ArrayList<Integer> rolls = new ArrayList<>();
                for (int i = 0; i < numberOfDice; i++) {
                    rolls.add(rand.nextInt(6) + 1);
                }

                // 2. Print line by line
                // Each die has 5 lines of text
                for (int line = 0; line < 5; line++) {
                    // Loop through each roll for the current line
                    for (int rollValue : rolls) {
                        // Get the array of lines for the current die
                        String[] dieLines = display(rollValue);
                        // Print the correct line for this die, without a newline
                        System.out.print(dieLines[line] + "  ");
                    }
                    // After printing the line for all dice, go to the next line
                    System.out.println();
                    for (int i = 0; i < numberOfDice; i++) {
                        int value = rand.nextInt(6) + 1;
                        System.out.println(display(value));
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number");
                scanner.next();
            }
        }

            while (!appCompleted) ;

        }
        public static String[] display ( int value){
            return switch (value) {
                case 1 -> new String[]{
                        "---------",
                        "|       |",
                        "|   O   |",
                        "|       |",
                        "---------"};
                case 2 -> new String[]{
                        "---------",
                        "| O     |",
                        "|       |",
                        "|     O |",
                        "---------"};
                case 3 -> new String[]{
                        "---------",
                        "| O     |",
                        "|   O   |",
                        "|     O |",
                        "---------"};
                case 4 -> new String[]{
                        "---------",
                        "| O   O |",
                        "|       |",
                        "| O   O |",
                        "---------"};
                case 5 -> new String[]{
                        "---------",
                        "| O   O |",
                        "|   O   |",
                        "| O   O |",
                        "---------"};
                case 6 -> new String[]{
                        "---------",
                        "| O   O |",
                        "| O   O |",
                        "| O   O |",
                        "---------"};
                default -> new String[]{"invalid"};
            };
        }
}
