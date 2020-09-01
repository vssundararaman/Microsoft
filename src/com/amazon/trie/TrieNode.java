package com.amazon.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Map<Character, TrieNode> children = new HashMap<> ();
    private boolean endOfWord;

    Map<Character, TrieNode> getChildren(){
        return children;
    }

    boolean isEndOfWord(){
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
