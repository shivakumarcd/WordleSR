package com.game.wordle;

import java.util.ArrayList;
import java.util.List;

//TODO - TBD refactoring state of game into seperate class
public class Game {

    enum Color { GREEN, YELLOW, WHITE, UNKNOWN }

    class Box {
        char letter;
        Color color;
    }

    class Guess {
        List<Box> wordleWord;

        Guess(String guess) {
            //TODO: string to box
            //populate box color based on matching letters and position wrt solution word
        }
    }

    public static List<String> dictionary = new ArrayList<>();
    private static int noOfAllowedGuesses = 5;

    // TODO:create arraylist of length 5 for each position color
    private List<Guess> guessList = new ArrayList<>();
    private int usedGuesses = 0;

    private String targetWord;

    Game() {
        //TODO : prepare dictionary by read word's list and sort and keep
        // it ready for comparison using binary search or library or ask GPT for alternative options
    }

    public void startGame() {
        // TOTO: Randomly choose target word to be guessed from word_list
        // TODO: loop for 5 valid guesses
    }

    public void processUserInput(String userInput) {
        // TODO: Read from command  line and create
    }

    public void reset() {
        // TODO---- same target or new target
    }

    public void applyGameRules(String userInput) {
        List<String> errorMessages = validateUserInput(userInput);
        if (errorMessages != null && errorMessages.isEmpty()) {
            return;
        }
        // TODO: Update game state based on user input
    }

    private List<String> validateUserInput(String userInput){
        // TODO: implement worldList append errors to errorMsges
        return null;
    }

    //TODO Display method with color printing

    public String getTargetWord() {
        return targetWord;
    }

    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    public static void changeAllowedAttepts(int maxForTesting) {
        Game.noOfAllowedGuesses = maxForTesting;
    }
}


