package controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
   // @FXML private GridPane bogglePane;
    @FXML private Button resetButton;
    @FXML private Button startButton;
    @FXML private TextField inputArea;
    @FXML private TextArea foundWordsArea;
    @FXML private Slider slider;
    @FXML private Pane boggleParent;
    private GridPane bogglePane;
    private ArrayFiller arrayFiller = new ArrayFiller();

    private int columnSize = 4;
    private int rowSize = 4;

    private Solver solver = new Solver();
    private String[][] letterArray = new String[rowSize][columnSize];
    private Set<String> gevondenWoorden = new HashSet<>();


    public Controller(){}

    @FXML
    private void initialize(){
        bogglePane = new GridPane();
        boggleParent.getChildren().add(bogglePane);
        bogglePane.autosize();
        doSetSize();
    }

    @FXML public void doSetSize(){
        bogglePane.getChildren().removeAll();
        columnSize = (int)slider.getValue();
        rowSize = (int)slider.getValue();
        letterArray= new String[rowSize][columnSize];
        for(int i=0; i< columnSize; i++){
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPercentWidth(25);
            //bogglePane.addRow(i);
            //bogglePane.addColumn(i);
        }
        doReset();
    }
    @FXML
    private void doReset(){
        bogglePane.getChildren().clear();
        createLetter(letterArray);
        gevondenWoorden.clear();
        foundWordsArea.clear();

    }

    @FXML
    private void startSolver(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gevondenWoorden=solver.solve(letterArray);
                for(String word:gevondenWoorden){
                    foundWordsArea.appendText(word + "\n");
                }
            }
        });
    }

    private void createLetter(String[][] array){
        String[][] genArray = arrayFiller.fillArray(array);
        for(int i=0; i< rowSize; i++){
            for(int j=0; j<columnSize; j++){
                Label label = new Label();
                label.setMinSize(0,0);
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
