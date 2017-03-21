package model;

/**
 * Created by Gebruiker on 21-3-2017.
 */
public class Test {
    private String[] woorden = {"hoi","kak","boi"};
    //private String[][] array = new String[3][3];
    private String[][] array = {{"h","o","i"},
                                 {"k","a","k"},
                                  {"b","o","i"}};
    private ArrayFiller filler = new ArrayFiller();

    public Test(){

    }

    public void searchWord(String[][] array){
        this.array = array;

        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        // Check rows

        String test = "";
        String woord = woorden[0];
        //horizontale search
        for(int i = numberOfRows-1; i< numberOfRows;i++){
            for(int j =0; j < numberOfColumns; j++){
                test += array[0][j];

                if(Character.toString(woord.charAt(j)).equals(Character.toString(test.charAt(j))) ){
                    System.out.println("letter found in word");
                    System.out.println("letter found is " + Character.toString(test.charAt(j)));
                    //test += array[0][j];
                }



            }
        }
        System.out.println(test);


    }

    public String[][] getArray(){
        return array;
    }

    public static void isConsecutiveFour(int[][] values) {
        int numberOfRows = values.length;
        int numberOfColumns = values[0].length;

        // Check rows
        int rowCheck;
        int columnCheck;
        int counter = 1;
        int temp;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                rowCheck = values[i][j];
                temp = values[i][j - 1];

                if (rowCheck == temp) {
                    counter++;
                    if (counter == 4) {
                        System.out.println(" match found");
                    }
                } else {
                    counter = 1;
                }

            }
        }
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 1; j < numberOfRows; j++) {
                rowCheck = values[j][i];
                temp = values[j - 1][i];

                if (rowCheck == temp) {
                    counter++;
                    if (counter == 4) {
                        System.out.println(" match found");
                    }
                } else {
                    counter = 1;
                }

            }
        }
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
