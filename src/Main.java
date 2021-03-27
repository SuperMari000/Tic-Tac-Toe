
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AppControler.SetStartControl();
        AppControler.ViewPane(AppControler.startMenu);
        
        Scene scene = new Scene(AppControler.rootPane, 450, 550);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
