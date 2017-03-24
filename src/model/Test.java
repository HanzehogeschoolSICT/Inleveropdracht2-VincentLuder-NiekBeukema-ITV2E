package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Gebruiker on 21-3-2017.
 */
public class Test {
    private String[] woorden = {"hoi","kak","boi"};
    //private String[][] array = new String[3][3];
    //dikheid
    private static String[][] board = {{"h","o","i"},
            {"k","a","k"},
            {"b","o","i"}};


    private static boolean[][] isVisited = new boolean[3][3];
    private ArrayFiller filler = new ArrayFiller();
    private ArrayList<String> foundWords = new ArrayList<>();
    public Test(){

    }

    public void solve(){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                searchWord(i,j,"");
                clearVisited();
            }
        }
        for(String string : getArray()){
            System.out.println(string);
        }
        for (int k = 0; k < foundWords.size(); k++) {
            System.out.println(foundWords.get(k));

        }
    }

    public void clearVisited(){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    public void searchWord(int xPos, int yPos, String word){
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
        System.out.println(word);
        //de booleans worden toegevoegd aan de array

        //het woord dat getest moet worden wordt elke stap groter. Tenzij er niks is.

            for(String checkWord: woorden){
                if (word.equals(checkWord)){
                    foundWords.add(checkWord);
                }
            }

            for(int i=0; i<woorden.length; i++){
                if(!woorden[i].startsWith(word)){
                    return;
                }
                else{
                    System.out.println(xPos);
                    searchWord(xPos+1, yPos, word); // positie naar rechts
                    searchWord(xPos, yPos+1, word); // positie omhoog
                    searchWord(xPos+1, yPos, word); // positie naar links
                    searchWord(xPos+1, yPos, word); // positie naar beneden
                    searchWord(xPos+1, yPos+1, word); //topright
                    searchWord(xPos-1, yPos-1, word);//bottomleft
                    searchWord(xPos-1, yPos+1, word);//topleft
                    searchWord(xPos+1, yPos-1, word);//bottomright
                }
            }

           // for(String prefix: woorden){

           // }

    }

    public ArrayList<String> getArray(){
        return foundWords;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.solve();
    }
}