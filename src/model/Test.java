package model;

import java.util.ArrayList;

/**
 * Created by Gebruiker on 21-3-2017.
 */
public class Test {
    private String[] woorden = {"hoi","kak","boi"};
    //private String[][] array = new String[3][3];
    private String[][] board = {{"h","o","i"},
                                 {"k","a","k"},
                                  {"b","o","i"}};
    private ArrayFiller filler = new ArrayFiller();
    private ArrayList<String> foundWords = new ArrayList<>();
    public Test(){

    }

    public void searchWord(int xPos, int yPos, String word){
        // "a" "kaas"
        word += board[xPos][yPos];
        for(String checkWord: woorden){
            if (word.equals(checkWord)){
                foundWords.add(checkWord);
            }
        }


    }
    


    public String[][] getArray(){
        return board;
    }



    public static void main(String[] args) {
        Test test = new Test();
        for(int i = 0; i < test.getArray().length; i++){
            for (int j =0; j<test.getArray().length;j++){
                System.out.println(test.getArray()[i][j]);
            }
        }


        test.searchWord(test.getArray());
    }
}
