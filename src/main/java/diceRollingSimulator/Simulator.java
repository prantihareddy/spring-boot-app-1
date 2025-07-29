package diceRollingSimulator;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random rand = new Random();
        boolean appCompleted=false;
        do {
            try {
                System.out.println("how many dice do you want to roll");
                int numberOfDice = scanner.nextInt();
                appCompleted=true;
                for (int i = 0; i < numberOfDice; i++) {
                    int value = rand.nextInt(6) + 1;
                    System.out.println(display(value));
                }

            }
            catch (InputMismatchException e){
                System.out.println("please enter a valid number");
                scanner.next();
            }
        }

        while(!appCompleted);

    }
    public static String display(int value){
        return switch (value){
            case 1->"-------\n|     |\n|  0  |\n|     |\n-------";
            case 2-> "-------\n| 0   |\n|     |\n|   0 |\n-------";
            case 3-> "-------\n| 0   |\n|  0  |\n|   0 |\n-------";
            case 4-> "-------\n| 0 0 |\n|     |\n| 0 0 |\n-------";
            case 5-> "-------\n| 0 0 |\n|  0  |\n| 0 0 |\n-------";
            case 6-> "-------\n| 0 0 |\n| 0 0 |\n| 0 0 |\n-------";
            default-> "not a valid die value";
        };
    }
}
