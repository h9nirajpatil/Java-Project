package com.example.dictionaryniraj11dec;

import java.util.HashMap;

public class DictionaryUSingMashMap {
    private HashMap<String,String> dictionary;

    public DictionaryUSingMashMap() {
        this.dictionary = new HashMap<>();
        addWordList();
    }

    public boolean addWord(String word, String meaning) {
        try {
            dictionary.put(word, meaning);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

        public String getMeaning(String word)
        {
            if(dictionary.containsKey(word))
            {
                return dictionary.get(word);
            }
            else
            {
                return "Word does not exit in dictionary!";
            }
        }

        private void addWordList(){
        addWord("shubh","Auspicios");
        addWord("capture","the act of capturing something or being captured");
        addWord("leap","to move quickly");
        addWord("chatter","to talk quickly or for a long time about something unimportant");
        addWord("devotee","a person who likes somebody/something very much");
        addWord("visitor","a person who visits somebody/something");
        addWord("cringe","to move away from somebody/something because you are frightened");
        addWord("reluctant","not wanting to do something because you are not sure it is the right thing to do");
        addWord("abrasion","a damaged area of the skin where it has been rubbed against something hard and rough");
        addWord("temptation ","a feeling that you want to do something even if you know that it is wrong");
    }
}
