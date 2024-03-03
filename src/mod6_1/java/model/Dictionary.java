package model;

import java.util.HashMap;

public class Dictionary {

    private final HashMap<String, String> dict = new HashMap<>();

    public Dictionary() {
    }

    public void add(String word, String meaning) {
        word = word.toLowerCase();
        meaning = meaning.toLowerCase();
        dict.put(word, meaning);
    }

    public String search(String word) {
        word = word.toLowerCase();
        return dict.get(word);
    }

}

