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

    private Boolean checkGuess(int uGuess) {
      return uGuess == rNum;
    }

    @Override
    public void start(Stage primaryStage) {
        Button[] btns = new Button[10];
        Text statusText = new Text();
        statusText.setText("allo");
    	StackPane root = new StackPane();
        Pane TPane = new Pane();
        HBox hb = new HBox();
        VBox vb = new VBox();
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(10);
        hb.setMaxHeight(30);
        hb.setStyle("-fx-background-color: #395868;");

    	for (int i=0; i<btns.length; i++) {
    		Button b = new Button();
    		b.setText(Integer.toString(i+1));
        b.setPrefSize(40, 20);

        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(this.);
                //int guess = this.getText();
                /*if (checkGuess()) {
                  statusText.setText("")
                }*/
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
      primaryStage.setTitle("Hello World!");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
