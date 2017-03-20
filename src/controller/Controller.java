package controller;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import model.ArrayFiller;
/**
 * Bron: http://docs.oracle.com/javafx/2/ui_controls
 */
public class Controller {
    @FXML private Pane rootPane;
    @FXML private GridPane bogglePane;
    @FXML private Button manualButton;
    @FXML private Button randomButton;
    @FXML private TextField inputArea;
    @FXML private TextArea foundWordsArea;
    private ArrayFiller arrayFiller = new ArrayFiller();

    private int columnSize = 3;
    private int rowSize = 3;

    private Cell[][] cell = new Cell[rowSize][columnSize];
    String[][] letterArray = new String[rowSize][columnSize];

    public Controller(){}

    @FXML
    private void initialize(){
    }

    @FXML
    private void inputAction(){

    }

    @FXML
    private void randomInput(){
        bogglePane.getChildren().clear();
        createLetter(letterArray);
    }
    private void createLetter(String[][] array){
        String[][] genArray = arrayFiller.fillArray(array);
        for(int i=0; i< rowSize; i++){
            for(int j=0; j<columnSize; j++){
                Label label = new Label();
                label.setText(genArray[i][j]);
                label.setFont(new Font("Arial", 30));
                bogglePane.setConstraints(label, i, j); // column=3 row=1
                bogglePane.setHalignment(label, HPos.CENTER);
                bogglePane.setValignment(label, VPos.CENTER);
                bogglePane.getChildren().add(label);
            }
        }
    }
}
