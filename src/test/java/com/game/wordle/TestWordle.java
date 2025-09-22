package com.game.wordle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWordle {
    Game newGame = new Game();

    @Test
    void testGameScenario1(){
        newGame.reset();
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
}
