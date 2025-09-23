package com.game.wordle;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        boolean continueGameFlag = true;
        System.out.println("Welcome to Wordle game");
        while (continueGameFlag) {
            printOptionsMenu();
            switch (readChoice()) {
                case 1:
                    // TODO: Start-loop in Game - start()
                    Game newGame = new Game();
                    /*
                    newgame.start()
                     */
                    break;
                case 9:
                    System.out.println("Thank you for playing");
                    continueGameFlag = false;
            }
        }
    }

    public static void printOptionsMenu() {
        System.out.println("Choose option");
        System.out.println("1 for new game ");
        System.out.println("9 for exit");
    }

    public static int readChoice() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;
        //todo: make sure its between 1 and 9

        while (!validInput) {
            try {
                number = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number options");
                printOptionsMenu();
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
        return number;
    }
}