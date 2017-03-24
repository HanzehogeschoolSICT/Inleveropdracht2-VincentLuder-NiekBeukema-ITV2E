package controller;
import javafx.application.Platform;
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
import model.Solver;

import java.util.HashSet;
import java.util.Set;

/**
 * Bron: http://docs.oracle.com/javafx/2/ui_controls
 */
public class Controller {
    @FXML private Pane rootPane;
    @FXML private GridPane bogglePane;
    @FXML private Button resetButton;
    @FXML private Button startButton;
    @FXML private TextField inputArea;
    @FXML private TextArea foundWordsArea;
    private ArrayFiller arrayFiller = new ArrayFiller();

    private int columnSize = 4;
    private int rowSize = 4;

    Solver solver = new Solver();
    String[][] letterArray = new String[rowSize][columnSize];
    Set<String> gevondenWoorden = new HashSet<String>();


    public Controller(){}

    @FXML
    private void initialize(){
        bogglePane.getChildren().clear();
        createLetter(letterArray);
    }

    @FXML
    private void doReset(){
        bogglePane.getChildren().clear();
        createLetter(letterArray);
    }

    @FXML
    private void startSolver(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gevondenWoorden=solver.solve(letterArray);


                for(String word:gevondenWoorden){
                    if(!gevondenWoorden.isEmpty()){
                        foundWordsArea.appendText(word);
                    }

                }
            }
        });
    }

    @FXML
    private void randomInput(){

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
