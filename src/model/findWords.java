package model;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Niek on 21-3-2017.
 */
public class findWords {
    private int rowSize = 3;
    private int colSize = 3;
    private static char[][] board =
            { { 's', 'a', 's', 'g' },
            { 'a', 'u', 't', 'h' },
            { 'r', 't', 'j', 'e' },
            { 'k', 'a', 'h', 'e' }};
    private static Set<String> dictionary = new HashSet<String>();
    private static boolean[][] visited = new boolean[board.length][board[0].length];

    public static void main(String[] args) {
            dictionary.add("tutje");
            dictionary.add("kat");
            scanWords();
    }

    // show all words, starting from each possible starting place
    private static void scanWords() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                StringBuffer buffer = new StringBuffer();
                dfs(i, j, buffer);
            }

        }

    }

    // run depth first search starting at cell (i, j)
    private static void dfs(int i, int j, StringBuffer buffer) {

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1) {
            return;
        }

        if (visited[i][j] == true) { // can't visit a cell more than once
            return;
        }

        // not to allow a cell to reuse
        visited[i][j] = true;

        // combining cell character with other visited cells characters to form
        // word a potential word which may exist in dictionary
        buffer.append(board[i][j]);

        // found a word in dictionary. Print it.
        if (dictionary.contains(buffer.toString())) {
            System.out.println(buffer);
        }

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                dfs(k, l, buffer);

            }

        }
        buffer.deleteCharAt(buffer.length() - 1);
        visited[i][j] = false;
    }

}
