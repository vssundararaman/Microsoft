package test.round1;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogFiles {

    public static void main(String[] args) {

        String[] input = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println (Arrays.toString (reorderLogFiles (input)));
    }

    static String[] reorderLogFiles(String[] logs) {

        Arrays.sort (logs, (log1, log2) -> {
            String[] split1 = log1.split (" ", 2);
            String[] split2 = log2.split (" ", 2);

            boolean isDigit1 = Character.isDigit (split1[1].charAt (0));
            boolean isDigit2 = Character.isDigit (split2[1].charAt (0));

            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo (split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo (split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }

    static String[] reorderLogFiles1(String[] logs) {
        Comparator<String> comparable = new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf (" ") + 1;
                int index2 = o2.indexOf (" ") + 1;

                if (Character.isLetter (o1.charAt (index1)) && Character.isLetter (o2.charAt (index2))) {
                    int cmp = o1.substring (index1).compareTo (o2.substring (index2));
                    return cmp == 0 ? o1.compareTo (o2) : cmp;
                } else if (Character.isLetter (o1.charAt (index1))) {
                    return -1;
                } else if (Character.isLetter (o2.charAt (index2))) {
                    return 1;
                } else {
                    return 0;
                }
            }

        };
        Arrays.sort (logs, comparable);
        return logs;
    }
}
