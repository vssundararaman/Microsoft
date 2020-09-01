package com.microsoft.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchingII {

    char[][] board = null;
    List<String> result = new ArrayList<> ();

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchingII wordSearchingII = new WordSearchingII ();

        System.out.println (wordSearchingII.findWords (board,words));
    }

    List<String> findWords(char[][] board, String[] words) {

        //Step 1) Construct the Trie
        TrieNode root = new TrieNode();

        for(String word: words){

            TrieNode node = root;

            for(Character letter: word.toCharArray()){

                if(node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter,newNode);
                    node = newNode;
                }
            }

            node.word = word; //Store the Word in Trie
        }

        this.board = board;
        //Step2. Backtracking starting for each cell in the board
        for(int row = 0; row < this.board.length; ++row){
            for(int col = 0; col < this.board[row].length; ++col){
                if(root.children.containsKey(this.board[row][col])) {
                    backTracking(row, col, root);
                }
            }
        }

        return result;
    }

     void backTracking(int row, int col, TrieNode parent){

        Character letter = this.board[row][col];
        TrieNode currNode = parent.children.get(letter);

        //Check if there any Match
        if(currNode !=null && currNode.word!=null){
            this.result.add(currNode.word);
            currNode.word = null;
        }

        // Mark the current letter before the EXPLORATIONS
        this.board[row][col] = '#';

        //explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffSet = {-1, 0, 1, 0};
        int[] colOffSet = {0, 1, 0, -1};

        for(int i=0; i<4 ; i++){
            int newRow = row + rowOffSet[i];
            int newCol = col + colOffSet[i];

            if(newRow < 0 || newRow >= board.length
                    || newCol < 0 || newCol >= board.length){
                continue;
            }
            if(currNode.children.containsKey(board[newRow][newCol])){
                backTracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATIONS restorethe original letter in the board
        this.board[row][col] = letter;

        //Optimization: incrementally remove the leaf nodes
        if(currNode.children.isEmpty()){
            parent.children.remove(letter);
        }

    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<> ();
    String word = null;
    public TrieNode(){}
}
