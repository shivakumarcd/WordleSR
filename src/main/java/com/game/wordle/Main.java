package com.game.wordle;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        boolean continueGameFlag = true;
        System.out.println("------------------------------------------");
        System.out.println(TextColor.ANSI_YELLOW +
                " to Welcome" + TextColor.ANSI_GREEN + " Wordle game :-)" + TextColor.ANSI_RESET);
        WordleDictionary wordleDictionary = new WordleDictionary();
        while (continueGameFlag) {
            printOptionsMenu();
            switch (readChoice()) {
                case 1:
                    Game newGame = new Game(wordleDictionary, wordleDictionary.getRandomWord());
                    newGame.startGame();
                    break;
                case 7:
                    printWordlePlayingRules();
                    break;
                case 8:
                    //TODO: Not working. OS dependent. EXTRA NOT asked... remove or it time permits
                    System.out.println("Some content before clearing.");
                    System.out.print("\033[H\033[2J"); // ANSI escape codes to clear the screen
                    System.out.flush(); // Ensures the output is sent to the console immediately
                    System.out.println("Content after clearing.");
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextInt();
                    break;
                case 9:
                    System.out.println("Thank you for playing");
                    System.out.println("------------------------------------------");
                    continueGameFlag = false;
            }
            //TODO: make ctrl+x exit main at any time
        }
    }

    private static void printWordlePlayingRules() {
        System.out.println("=======================================");
        System.out.println("         Welcome to WORDLE (CLI)       ");
        System.out.println("=======================================");
        System.out.println("Game Rules:");
        System.out.println("1. You have 5 guesses.");
        System.out.println("2. All words are exactly 5 letters long.");
        System.out.println("3. Feedback after each guess:");
        System.out.println("   - GREEN  : Letter in correct position.");
        System.out.println("   - YELLOW : Letter in the word, wrong position.");
        System.out.println("   - WHITE  : Letter not in the word.");
        System.out.println("4. Duplicate letters:");
        System.out.println("   - Yellow shows only if target has that letter.");
        System.out.println("     Example: Target=WATER, Guess=OTTER");
        System.out.println("     -> First 'T' is WHITE, second 'T' is GREEN.");
        System.out.println("=======================================");
        System.out.println("Let's play!\n");
    }

    public static void printOptionsMenu() {
        System.out.println("Choose option");
        System.out.println("1 for new game ");
        System.out.println("7 for quick introduction to the game");
        System.out.println("8 for clearing screen ");
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