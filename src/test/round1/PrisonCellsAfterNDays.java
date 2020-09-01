package test.round1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println (Arrays.toString (prisonAfterNDays (cells, 7)));
    }

    static int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<> ();

        int size = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {

            int[] nextState = new int[cells.length];
            for (int j = 1; j < cells.length - 1; j++) {
                nextState[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }

            String s = Arrays.toString (nextState);
            if (set.contains (s)) {
                flag = true;
                break;
            } else {
                set.add (s);
                size++;
            }

            cells = nextState;
        }
        if (flag) {
            N = N % size;
            for (int i = 0; i < N; i++) {
                int[] nextState = new int[cells.length];
                for (int j = 1; j < cells.length - 1; j++) {
                    nextState[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
                }
                cells = nextState;
            }
        }

        return cells;
    }
}
