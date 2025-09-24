package com.game.wordle;

import java.util.ArrayList;
import java.util.List;

public class WordleWord {
    //private final Game game;
    String word;
    List<Box> wordleWord;

    WordleWord(Game game, String userInputStr) {
        //this.game = game;
        userInputStr = userInputStr.toLowerCase();
        this.word = userInputStr;
        wordleWord = new ArrayList<>();
        char[] userInputChars = userInputStr.toCharArray();
        for (char userInputChar : userInputChars) {
            Box box = new Box();
            box.letter = userInputChar;
            box.color = Game.Color.WHITE;
            this.wordleWord.add(box);
        }
    }

    public void updateColor(String targetWord) {
        int pos = 0;
        StringBuilder targetWordCopy = new StringBuilder(targetWord);
        for (Box box : this.wordleWord) {
            if (box.letter == targetWord.charAt(pos)) {
                box.color = Game.Color.GREEN;
                for (int i = 0; i < targetWordCopy.length(); i++) {
                    if (targetWordCopy.charAt(i) == box.letter) {
                        targetWordCopy.deleteCharAt(i);
                        i--; // Decrement i to account for the shifted characters
                    }
                }
            }
            pos++;
        }
        /*
            To enforce example rule
            Example: if the the correct word is WATER and you guess OTTER, the first T
            must not get a yellow highlight.
        */
        for (Box box : this.wordleWord) {
            if (box.color != Game.Color.GREEN) {
                if (targetWordCopy.toString().contains(String.valueOf(box.letter))) {
                    box.color = Game.Color.YELLOW;
                }
            }
        }
    }
}
