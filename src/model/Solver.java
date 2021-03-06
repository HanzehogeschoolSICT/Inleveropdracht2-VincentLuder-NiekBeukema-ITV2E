package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Gemaakt door Vincent & Niek
 * Met hulp van Ronan
 * Bronnen: http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
 * http://stackoverflow.com/questions/23075689/how-to-do-a-recursive-search-for-a-word-in-the-boggle-game-board
 */
public class Solver {

    private boolean[][] isVisited;
    private ArrayList<String> woordenLijst = new ArrayList<>();
    private Set<String> foundWords = new HashSet<String>();

    public Set<String> solve(String[][] board){
        loadWordList();
        isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                searchWord(board, i, j, "");
                clearVisited(board.length,board[0].length);
            }
        }
        return foundWords;
    }

    private void loadWordList(){
        try {
            URL url = getClass().getResource("dict.txt");
            BufferedReader br = new BufferedReader(new FileReader(url.getPath()));
            String line;
            while ((line = br.readLine()) != null) {
                woordenLijst.add(line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void clearVisited(int xSize, int ySize){
        for(int i = 0; i <xSize; i++) {
            for(int j = 0; j <ySize; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    private void searchWord(String[][] board, int xPos, int yPos, String word){
            word += board[xPos][yPos];
            if (isVisited[xPos][yPos]) {return;}
            isVisited[xPos][yPos] = true;

        for(String checkWord: woordenLijst){
            if (checkWord.equals(word)){
                foundWords.add(word);
            }
            if(checkWord.startsWith(word) && xPos>0 && yPos>0 && xPos<board.length-1 && yPos<board.length-1 ){
                searchWord(board,xPos+1, yPos, word); // positie naar rechts
                searchWord(board,xPos, yPos+1, word); // positie omhoog
                searchWord(board,xPos-1, yPos, word); // positie naar links
                searchWord(board,xPos, yPos-1, word); // positie naar beneden
                searchWord(board,xPos+1, yPos+1, word); //topright
                searchWord(board,xPos-1, yPos-1, word);//bottomleft
                searchWord(board,xPos-1, yPos+1, word);//topleft
                searchWord(board,xPos+1, yPos-1, word);//bottomright
                break;
            }
        }
    }
}
