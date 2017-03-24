package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Vincent en Niek
 * Met hulp van Ronan
 * Gebruikte bronnen:
 * - blalbla
 * blabla
 * bla
 */
public class Test {
    private String[] woorden = {"hoi","kak","boi"};
    //private String[][] array = new String[3][3];
    //dikheid
    private static String[][] board = {{"h","o","i"},
            {"k","a","k"},
            {"b","o","i"}};


    private static boolean[][] isVisited = new boolean[board.length][board[0].length];
    private ArrayFiller filler = new ArrayFiller();
    private Set<String> foundWords = new HashSet<String>();

    public Test(){

    }

    public void solve(){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                searchWord(i,j,"");
                clearVisited();

            }
        }
        for(String kutwoord: foundWords){
            System.out.println(kutwoord);
        }
    }

    public void clearVisited(){
        for(int i = 0; i <3; i++) {
            for(int j = 0; j <3; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    public void searchWord(int xPos, int yPos, String word){
        boolean hierdoor = false;
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
            for(String checkWord: woorden){
                if (checkWord.equals(word)){
                    foundWords.add(word);
                }
            }

            for(String dictWord:woorden){
                if(dictWord.startsWith(word)){
                    hierdoor = true;
                    break;
                }
            }
            if(hierdoor){
                searchWord(xPos+1, yPos, word); // positie naar rechts
                searchWord(xPos, yPos+1, word); // positie omhoog
                searchWord(xPos-1, yPos, word); // positie naar links
                searchWord(xPos, yPos-1, word); // positie naar beneden
                searchWord(xPos+1, yPos+1, word); //topright
                searchWord(xPos-1, yPos-1, word);//bottomleft
                searchWord(xPos-1, yPos+1, word);//topleft
                searchWord(xPos+1, yPos-1, word);//bottomright
            } else { return;}
           // for(String prefix: woorden){

           // }

    }

    public Set<String> getArray(){
        return foundWords;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.solve();
    }
}