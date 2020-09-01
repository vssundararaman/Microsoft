package com.amazon.treesandgraphs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

         List<String> wordList = new ArrayList<String> (Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"));

        System.out.println (ladderLength ("ymain","oecij",wordList));
    }
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<> ();
        for(String word: wordList){
            set.add (word);
        }

        if(!set.contains (endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<> ();
        queue.offer (beginWord);
        int level = 0;

        while(!queue.isEmpty ()){

            int size = queue.size ();

            for(int i = 0; i <size ; i++){
                String current_word = queue.poll ();
                char[] word_char = current_word.toCharArray ();

                for(int j = 0; j< word_char.length; j++){
                    char original_char = word_char[j];

                    for(char c = 'a'; c < 'z'; c++){
                        if(word_char[j] == c) continue;
                        word_char[j] = c;
                        String new_word = String.valueOf (word_char);

                        if(new_word.equals (endWord)) return level +1;

                        if(set.contains (new_word)){
                            queue.offer (new_word);
                            set.remove (new_word);
                        }
                    }

                    word_char[j] = original_char;
                }
            }
                level++;
        }
        return 0;
    }

}
