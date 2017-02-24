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
    private Random rng = new Random();
    
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
    		b.setTranslateX(i*10);
    		hb.getChildren().add(b);
    		btns[i] = b;
    	}
    
    vb.getChildren().add(hb);
    vb.getChildren().add(statusText);
    root.getChildren().add(vb);
        /*
	btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
	*/
    
        //TODO ew ew ew hardcoded ew..
        Scene scene = new Scene(root, (40*11)+(15*11), 20+12+30);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
