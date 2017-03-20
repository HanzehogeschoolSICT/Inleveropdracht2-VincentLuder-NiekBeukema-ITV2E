package model;

import java.util.Random;

/**
 * Created by vincent on 20-3-2017.
 */
public class ArrayFiller {

    private Random random = new Random();

    public String[][] fillArray(String[][] array){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length;j++){
                array[i][j] = generateLetter();
                counter++;
            }
        }
        return array;
    }

    private String generateLetter(){
        int randomNumber = random.nextInt(26);
        String[] letterArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        return letterArray[randomNumber];
    }

    public void printArray(String[][] array){
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayFiller filler = new ArrayFiller();
        String[][] array = new String[10][10];
        filler.fillArray(array);
        filler.printArray(array);

    }
}


