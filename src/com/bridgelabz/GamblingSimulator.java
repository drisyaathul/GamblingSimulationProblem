package com.bridgelabz;

import java.util.Random;

public class GamblingSimulator {
    /*
     * As a Gambler, would start with a stake of $100 every day and
       bet $1 every game(UC1).
     * Initializing Stack of Every day and Bet Amount
   */
    static int stackEveryDay = 100;
    static int betEveyGame = 1;

    public static void main(String[] args) {
        System.out.println(" *** GAMBLING SIMULATION PROBLEM *** ");

        System.out.println("Stack of Every Day = " + stackEveryDay + "$");
        System.out.println("Bet Amount Every Game = " + betEveyGame + "$");
        /*
           Initializing 50% of the Everyday Stock Won and Lost
         */
        int stackWon = 150;
        int stackLost = 50;
        int totalAmount=0;
        /*
           Playing the game for 20 days (UC4)
         */
        for (int days = 1; days <= 20; days++) {
            stackEveryDay = 100;
        /*
           Gambler if won or lost 50% of the stake, would resign for the day (UC3)
         */
            while (stackEveryDay > stackLost && stackEveryDay < stackWon) {
                /*
                 * Gambler make $1 bet either win or loose $1 (UC2).
                 * Using Random to find the Bet wins or lose.
                 */
                Random random = new Random();
                int bet = random.nextInt(2);

                switch(bet) {
                    case 1:
                        /*
                           When the Bet wins Bet amount is added to Stack of Everyday
                        */
                        stackEveryDay += betEveyGame;
                        break;
                    default:
                        /*
                           When the Bet loose Stack of Every day is deducted by bet amount
                        */
                        stackEveryDay -= betEveyGame;
                        break;

                }
            }
            /*
              * if the Stack of Every day is equal to 150$ else 50$
              * total amount is total stack of month
             */
            if(stackEveryDay == stackWon) {
                System.out.println("Player Has Won Gambler For Day "+days);
                totalAmount += stackWon;
            }else {
                System.out.println("Player Has Loss Gambler For Day "+days);
                totalAmount -= stackLost;
            }
            /*
              After 20 days of playing every day would like to know the total amount won or lost (UC4)
             */
            System.out.println("Total Win Price: "+totalAmount + "$");
        }
    }
}