package diceRollingSimulator;

import java.util.Random;

public class Simulator {
    public static void main(String[] args) {
        Random rand=new Random();
        int value=rand.nextInt(6)+1;
        System.out.println(display(value));
    }
    public static String display(int value){
        switch (value){
            case 1: return "-------\n|     |\n|  0  |\n|     |\n-------";
            case 2: return "-------\n| 0   |\n|     |\n|   0 |\n-------";
            case 3: return "-------\n| 0   |\n|  0  |\n|   0 |\n-------";
            case 4: return "-------\n| 0 0 |\n|     |\n| 0 0 |\n-------";
            case 5: return "-------\n| 0 0 |\n|  0  |\n| 0 0 |\n-------";
            case 6: return "-------\n| 0 0 |\n| 0 0 |\n| 0 0 |\n-------";
            default:return "not a valid die value";
        }
    }
}
