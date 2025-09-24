package com.game.wordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

public class WordleDictionary {

    private static final String WORDS_FILE = "/word_list.txt";  // resource path
    private NavigableSet<String> validWords = new TreeSet<>();

    public WordleDictionary() {
        loadWords();
    }

    private void loadWords() {
        try (InputStream in = getClass().getResourceAsStream(WORDS_FILE);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(",");
            }

            String[] words = sb.toString().split(",");
            for (String w : words) {
                w = w.trim().toLowerCase();
                if (w.length() == 5) {
                    validWords.add(w);
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Failed to load dictionary file: " + WORDS_FILE, e);
        }
    }

    public boolean isValidWord(String word) {
        return validWords.contains(word.toLowerCase());
    }

    public String getRandomWord() {
        int index = new Random().nextInt(validWords.size());
        return validWords.stream().skip(index).findFirst().get();
    }
}
