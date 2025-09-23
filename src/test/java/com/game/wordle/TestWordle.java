package com.game.wordle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWordle {
    Game newGame = new Game();

    @Test
    void testGameScenario1_possibleUserInputs() {
        String targetWord = "water";
        newGame.setTargetWord("water");
        Game.changeAllowedAttepts(100);

        List<String> guessList = new ArrayList<>();
        guessList.add("water");  // correct and game won
        guessList.add("12345");  // invalid- not in dictionary

        targetWord = "water";
        guessList.add("12345");  // none matching
        guessList.add("12t45");  // TODO 1 green vs multiple  vs edge case

        guessList.add("t2345");  // TODO 1 yellow vs multiple  vs edge case
        guessList.add("");  // TODO both vs multiple vs edge case
        //TODO brainstorm and add other possibilities

        /*
        for (String testGuess : guessList) {
            GuessResult result = game.guess(testGuess);
            // TODO: call handleUserToGameInput(testGuess)-entry point
            // TODO: add assertions about result
        }
        /*
         */


        //Edge case
        targetWord = "abcde";


        //TODO: newGame.reset();------if needs

        // TODO: Prepare states for vanilla test case
        // TODO: startNewGame() - initial setup/state needed for new game
        //                      - Prepare data for running the game
        // in loop for 5 allowed inputs
        // TODO: ??????display() current state  (initial state for first loop) to player????????
        // TODO: readPlayerInput() wait for and read player input
        // TODO: applyGamelogic() - based on input from player apply game logic
        //                        - and update state
        boolean result = false;
        assertEquals(true, result);
    }
    //TODO group test cases user input level vs succeess/fail case...
}
