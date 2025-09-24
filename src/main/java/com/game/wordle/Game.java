package com.game.wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    enum Color {GREEN, YELLOW, WHITE}

    private static int noOfAllowedGuesses = 5;

    private WordleDictionary wordleDictionary;
    private List<WordleWord> wordleWordGuesses = new ArrayList<>();
    private int attemptsLeft = 5;// TODO: remove redundant attemptsLeft
    private String targetWord;
    private GameState gameState = GameState.ON;

    Game(WordleDictionary wordleDictionary, String targetWord) {
        this.wordleDictionary = wordleDictionary;
        this.targetWord = targetWord;
    }

    //Used for test cases
    public GameState getGameState() {
        return this.gameState;
    }

    public void startGame() {
        System.out.println("-------Game started-------");
        for (int i = 1; i <= noOfAllowedGuesses && this.gameState == GameState.ON; i++) {
            String userInputStr = this.readUserInput();
            List<String> errorMessages = validateUserInput(userInputStr);
            if (errorMessages.isEmpty()) {
                WordleWord wordleWord = new WordleWord(this, userInputStr);
                this.wordleWordGuesses.add(wordleWord);
                wordleWord.updateColor(this.targetWord);
                this.attemptsLeft--;
                this.updateGameStatus();
                this.printGuessResult();
            } else {
                i--;    //negating increment as this was not a valid attempt
                for (String error : errorMessages) {
                    System.out.println("Error: " + error);
                }
            }
        }
        // TODO: print lost in red and won in green
        if (this.gameState == GameState.LOST) {
            System.out.println("Correct wordle : " + this.targetWord);
            System.out.println("Game lost. Play again");
            System.out.println("---------------------------");
        } else if (this.gameState == GameState.WON) {
            System.out.println("Congratulations. Game won...");
            System.out.println("---------------------------");
        }
    }

    //made public to call from tests
    public void updateGameStatus() {
        WordleWord lastGuess = this.wordleWordGuesses.get(this.wordleWordGuesses.size() - 1);
        if (lastGuess.word.equals(this.targetWord)) {
            this.gameState = GameState.WON;
            return;
        }
        if (this.attemptsLeft == 0) {
            this.gameState = GameState.LOST;
        }
    }

    public String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Attempts left = " + this.attemptsLeft);
        System.out.print("Enter guess: ");
        return scanner.nextLine();
    }

    private List<String> validateUserInput(String userInput) {
        // TODO: validate length and present in dictionary, etc
        List<String> errors = new ArrayList<>();
        String errorMessage;
        if (null == userInput || userInput.length() != 5 || !wordleDictionary.isValidWord(userInput)) {
            errorMessage = "Invalid guess. Guess should be 5 letter English dictionary word(Current txt file don't has all the words)";
            errors.add(errorMessage);
        }
        return errors;
    }

    public void printGuessResult() {
        WordleWord recentGuess = this.wordleWordGuesses.get(this.wordleWordGuesses.size() - 1);
        System.out.print("Guessed result: ");
        for (Box box : recentGuess.wordleWord) {
            if (box.color == Color.WHITE) {
                System.out.print(TextColor.ANSI_RESET + String.valueOf(box.letter) + TextColor.ANSI_RESET);
            } else if (box.color == Color.YELLOW) {
                System.out.print(TextColor.ANSI_YELLOW + String.valueOf(box.letter) + TextColor.ANSI_RESET);
            } else if (box.color == Color.GREEN) {
                System.out.print(TextColor.ANSI_GREEN + String.valueOf(box.letter) + TextColor.ANSI_RESET);
            }
        }
        System.out.println();
    }

    public static void changeAllowedAttemptsForTesting(int maxForTesting) {
        Game.noOfAllowedGuesses = maxForTesting;
    }

    public void addToWorldeListForTesting(WordleWord wordleWord) {
        this.wordleWordGuesses.add(wordleWord);
    }
}
