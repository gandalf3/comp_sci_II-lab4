package gngui;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class GnGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button[] btns = new Button[10];
	StackPane root = new StackPane();

	for (int i=0; i<btns.length; i++) {
		Button b = new Button();
		b.setText(Integer.toString(i));

		b.setTranslateX(i*10);
		root.getChildren().add(b);
		btns[i] = b;

	}
        /*
	btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
	*/
        
       
 Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
}
