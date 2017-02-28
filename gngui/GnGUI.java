package gngui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.*;
import javafx.geometry.*;
import java.util.Random;

public class GnGUI extends Application {
    private static Random rng = new Random();
    private int rNum;
    Text statusText = new Text();
    guessButton[] btns = new guessButton[10];

    private void sayText(String t) {
      statusText.setText(t);
    }

    private void startRound() {
      rNum = rng.nextInt(10)+1;
      for (int i=0; i<btns.length; i++) {
        btns[i].setDisable(false);
      }
      sayText("Pick a numeric character from the selection above");
    }

    private void winRound() {
      sayText("Golly, will you look at that.. You did something right! Congratulations");
      startRound();
    }

    private class guessButton extends Button {
        public int number;

        public void setNumber(int n) {
            this.number = n;
        }
        public int getNumber() {
            return this.number;
        }
    }

    private Boolean checkGuess(int uGuess) {
      return uGuess == rNum;
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Pane TPane = new Pane();
        HBox hb = new HBox();
        VBox vb = new VBox();
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(10);
        hb.setMaxHeight(30);
        hb.setStyle("-fx-background-color: #395868;");

    	for (int i=0; i<btns.length; i++) {
    		guessButton b = new guessButton();
            b.setNumber(i+1);
    		b.setText(Integer.toString(i+1));
            b.setPrefSize(40, 20);

            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    guessButton b = ((guessButton)event.getSource());
                    b.setDisable(true);
                    int guess = b.getNumber();
                    System.out.println(rNum + " " + guess);
                    if (checkGuess(guess)) {
                      winRound();
                    }
                }
            });

    		hb.getChildren().add(b);
    		btns[i] = b;
    	}

      vb.getChildren().add(hb);
      vb.getChildren().add(statusText);
      root.getChildren().add(vb);

      //TODO ew ew ew hardcoded ew..
      Scene scene = new Scene(root, (40*11)+(15*11), 20+12+50);

      startRound();
      primaryStage.setTitle("N. GU(ess)I");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
