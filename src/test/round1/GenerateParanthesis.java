package test.round1;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println (generateParanthesis (3));
    }

    static List<String> generateParanthesis(int n) {
        List<String> output = new ArrayList<> ();
        backTrack (output, "", 0, 0, n);
        return output;
    }

    static void backTrack(List<String> output, String currentString, int open, int close, int max) {

        if (currentString.length () == max * 2) {
            output.add (currentString);
            return;
        }

        if (open < max) {
            backTrack (output, currentString + "(", open + 1, close, max);
        }

        if (close < open) {
            backTrack (output, currentString + ")", open, close + 1, max);
        }

    }
}
