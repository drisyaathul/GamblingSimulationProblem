package com.bridgelabz;

import java.util.Random;

public class GamblingSimulator {
    /*
     * As a Gambler, would start with a stake of $100 every day and
       bet $1 every game(UC1).
     * Initializing
   */
    static int stackEveryDay = 100;
    static int betEveyGame = 1;
    static int win =0;
    static int lose =0;
    static int winMax = 0;
    static int losMax = 0;
    static int luckyDay;
    static int unluckyDay;

    public static void main(String[] args) {
        System.out.println(" *** GAMBLING SIMULATION PROBLEM *** ");

        System.out.println("Stack of Every Day = " + stackEveryDay + "$");
        System.out.println("Bet Amount Every Game = " + betEveyGame + "$");
        /*
           Initializing 50% of the Everyday Stock Won and Lost
         */
        int stackWon = 150;
        int stackLost = 50;
        System.out.println("Gambler if won ="+stackWon+"$");
        System.out.println("Gambler if loss ="+stackLost+"$");
        int totalAmount = 0;
        int winDays =0;
        int lostDays =0;
        /*
           Playing the game for 20 days (UC4)
         */
        for (int days = 1; days <= 30; days++) {
            stackEveryDay = 100;
        /*
           Gambler if won or lost 50% of the stake, would resign for the day (UC3)
         */
            while (stackEveryDay > stackLost && stackEveryDay < stackWon) {
                /*
                 * Gambler make $1 bet either win or loose $1 (UC2).
                 * Using Random to find the Bet wins or lose.
                 * When the Bet wins Bet amount is added to Stack of Everyday
                 * When the Bet loose Stack of Every day is deducted by bet amount
                 */
                Random random = new Random();
                int bet = random.nextInt(2);

                switch(bet) {
                    case 1:
                        stackEveryDay += betEveyGame;
                        win++;
                        break;
                    default:
                        stackEveryDay -= betEveyGame;
                        lose++;
                        break;
                }
            }
            /*
              * if the Stack of Every day is equal to 150$ else 50$
              * total amount is total stack of month
              * Counting the Winning and Loosing Days(UC5)
             */
            if(stackEveryDay == stackWon) {
                totalAmount += stackWon;
                winDays +=1;
            }else {
                totalAmount -= stackLost;
                lostDays +=1;
            }
            /*
               luckiest day won maximum and my unluckiest day lost maximum(UC6)
             */
            if(win > winMax) {
                winMax = win;
                luckyDay = days ;
            }
            if(lose > losMax) {
                losMax = lose;
                unluckyDay = days;
            }
        }
        /*
         * After 20 days of playing every day would like to know the total amount won or lost (UC4)
         * Each month would like to know the days won and lost (UC5)
         * print the Luckiest and Unluckiest day (UC6)
         */
        System.out.println("Winning Days : "+winDays+" days");
        System.out.println("Loosing Days : "+lostDays+" days");
        System.out.println("The Luckiest Day is "+luckyDay);
        System.out.println("The Unluckiest Day is "+unluckyDay);
        System.out.println("Total Win Price: "+totalAmount + "$");

    }
}