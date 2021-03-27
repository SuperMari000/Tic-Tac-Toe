
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */
public class AppControler {
    
        
    static StartMenu startMenu = new StartMenu();
    static SinglePlayer singlePlayer = new SinglePlayer();
    static MultiPlayer multiPlayer = new MultiPlayer();
    static SettingsMenu settingsMenu = new SettingsMenu();
    static GameBoard gameBoard = new GameBoard();
    
    
    static BorderPane rootPane = new BorderPane();
    
    static Font currentFont;
    
    static Image  imageBoard;
    
    
    public static void ViewPane(GridPane currentPane){
        rootPane.getChildren().clear();
        
        rootPane.setCenter(currentPane);
        
    }
    
    public static void SetFontControl(){
        
        startMenu.SetFont(currentFont);
        singlePlayer.SetFont(currentFont);
        multiPlayer.SetFont(currentFont);
        gameBoard.SetFont(currentFont);
        settingsMenu.SetFont(currentFont);
        
    }
    
    public static void SetStartControl(){
        
        AppControler.SetFontSize(16);
        AppControler.SetImageBoard("board_1.JPG");
        SetFontControl();
        

    }
    
    public static void SetFontSize(int fontSize){
        
        AppControler.currentFont = Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,fontSize);
    }
    
    public static void SetImageBoard(String background){
        
        try{

            AppControler.imageBoard = new Image(new FileInputStream("./src/img/" + background));
            
        }catch(Exception e){
            System.out.println("Can Not Load Image Board !!!");
            System.exit(0);
        }
        
    }
    

}
