package com.game.wordle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWordle {
    WordleDictionary wordleDictionary = new WordleDictionary();

    @Test
    void testSimpleSuccess() { //TODO: to be completed
        boolean testSuccess = false;
        Game newLocalGame = new Game(wordleDictionary, "water");
        String guess = "water";
        WordleWord wordleWord = new WordleWord(newLocalGame, guess);
        wordleWord.updateColor(guess);
        newLocalGame.addToWorldeListForTesting(wordleWord);
        newLocalGame.updateGameStatus();
        if (newLocalGame.getGameState() == GameState.WON) {
            testSuccess = true;
        }
        assertTrue(testSuccess);
    }

    @Test
    void testRule3() { //TODO: to be completed
        boolean testSuccess = false;
        assertEquals(true, testSuccess);
    }

    @Test
    void testRule4() {//TODO: to be completed
        /*
            Testing if the correct word is WATER and you guess OTTER, the first T
            must not get a yellow highlight.
        * */
        boolean testSuccess = false;
        Game newLocalGame = new Game(wordleDictionary, "water");
        String guess = "otter";


        assertEquals(true, testSuccess);
    }

    @Test
    void testGameScenario1_possibleUserInputs() { //TODO: other tests to be completed
        Game globalSampleGame = new Game(wordleDictionary, "water");
        boolean testSuccess = false;
        Game.changeAllowedAttemptsForTesting(100);


        Game.changeAllowedAttemptsForTesting(5);

        List<String> guessList = new ArrayList<>();
        guessList.add("water");  // correct and game won
        guessList.add("12345");  // invalid- not in dictionary

        String targetWord = "water";
        guessList.add("12345");  // none matching
        guessList.add("12t45");  // TODO 1 green vs multiple  vs edge case

        guessList.add("t2345");  // TODO 1 yellow vs multiple  vs edge case
        guessList.add("");  // TODO both vs multiple vs edge case
        //TODO brainstorm and add other possibilities

        /*
        for (String testGuess : guessList) {
            GuessResult testSuccess = game.guess(testGuess);
            // TODO: call handleUserToGameInput(testGuess)-entry point
            // TODO: add assertions about testSuccess
        }
         */


        // TODO: Prepare states for vanilla test case
        // TODO: startNewGame() - initial setup/state needed for new game
        //                      - Prepare data for running the game
        // in loop for 5 allowed inputs
        // TODO: ??????display() current state  (initial state for first loop) to player????????
        // TODO: readPlayerInput() wait for and read player input
        // TODO: applyGamelogic() - based on input from player apply game logic
        //                        - and update state

        assertEquals(true, testSuccess);
    }
    //TODO group test cases user input level vs succeess/fail case...
}
