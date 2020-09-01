package test.round1;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    Trie[] next;
    List<String> words;

    Trie(){
        words = new ArrayList<> ();
        next = new Trie[26];
    }
}
