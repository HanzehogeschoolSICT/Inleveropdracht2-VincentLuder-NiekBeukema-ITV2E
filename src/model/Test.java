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
        boolean isVisited;

        word += board[xPos][yPos];
        try{
            for(String checkWord: woorden){
                if (word.equals(checkWord)){
                    foundWords.add(checkWord);
                }
            }

            for(String prefix: woorden){
                if(!prefix.startsWith(word)){
                    return;
                }
                else{
                    searchWord(xPos+1, yPos, word); // positie naar rechts
                    searchWord(xPos, yPos+1, word); // positie omhoog
                    searchWord(xPos+1, yPos, word); // positie naar links
                    searchWord(xPos+1, yPos, word); // positie naar beneden
                }
            }
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex);
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
