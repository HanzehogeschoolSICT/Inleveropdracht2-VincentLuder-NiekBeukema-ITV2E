package model;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * Bronnen: http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
 *
 */
public class Solver {

    private boolean[][] isVisited;
    private ArrayList<String> woordenLijst;
    Set<String> foundWords = new HashSet<String>();

    public Set<String> solve(String[][] board){
        isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                searchWord(board, i, j, "");
                clearVisited(board.length,board[0].length);
            }
        }
        for(String woord: foundWords){
            System.out.println(woord);
        }
        return foundWords;
    }

    public void clearVisited(int xSize, int ySize){
        for(int i = 0; i <xSize; i++) {
            for(int j = 0; j <ySize; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    public void loadWordList(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Gebruiker/IdeaProjects/Inleveropdracht2-VincentLuder-NiekBeukema-ITV2E/src/model/dict.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                woordenLijst.add(line);
            }
        } catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void searchWord(String[][] board, int xPos, int yPos, String word){
        boolean recursive = false;
        // "a" "kaas"
        try {
            word += board[xPos][yPos];
            if (isVisited[xPos][yPos]) {
                return;
            }
            isVisited[xPos][yPos] = true;
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
            return;
        }

        //de booleans worden toegevoegd aan de array

        //het woord dat getest moet worden wordt elke stap groter. Tenzij er niks is.
        for(String checkWord: woordenLijst){
            if (checkWord.equals(word)){
                foundWords.add(word);
            }
        }

        for(String dictWord:woordenLijst){
            if(dictWord.startsWith(word)){
                recursive = true;
                break;
            }
        }
        if(recursive){
            searchWord(board,xPos+1, yPos, word); // positie naar rechts
            searchWord(board,xPos, yPos+1, word); // positie omhoog
            searchWord(board,xPos-1, yPos, word); // positie naar links
            searchWord(board,xPos, yPos-1, word); // positie naar beneden
            searchWord(board,xPos+1, yPos+1, word); //topright
            searchWord(board,xPos-1, yPos-1, word);//bottomleft
            searchWord(board,xPos-1, yPos+1, word);//topleft
            searchWord(board,xPos+1, yPos-1, word);//bottomright
        } else { return;}
        // for(String prefix: woorden){

        // }

    }
}
