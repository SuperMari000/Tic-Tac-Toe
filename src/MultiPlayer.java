
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setColumnSpan;
import static javafx.scene.layout.GridPane.setHalignment;
import static javafx.scene.layout.GridPane.setMargin;
import javafx.scene.text.Font;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */
public class MultiPlayer extends GridPane{
    
    private Label playerXLabel = new Label("Player X :");
    private Label playerOLabel = new Label("Player O :");
    private TextField playerXName = new TextField("Player 1");
    private TextField playerOName = new TextField("Player 2");
    private Button start = new Button("Start");
    private Button back = new Button("Back");
    

    
    public MultiPlayer(){

        
        start.setPrefWidth(200);
        back.setPrefWidth(200);
        

        
        setHgap(20);
        setVgap(20);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(50));
        setMinSize(400, 500);
        
        setMargin(start, new Insets(40,0,0,0));
        setHalignment(start, HPos.CENTER);
        setHalignment(back, HPos.CENTER);
        
        
        
        
       
        setColumnSpan(start, 2);
        setColumnSpan(back, 2);
        
        add(playerXLabel,0,0);
        add(playerXName,1,0);
        add(playerOLabel,0,1);
        add(playerOName,1,1);
        add(start,0,2);
        add(back,0,3);
        
        
        
        start.setOnAction((Action) -> {
            if(!playerXName.getText().equals(playerOName.getText()) && !playerXName.getText().equals("") && !playerOName.getText().equals("")){
                
                AppControler.gameBoard.StartGameBoard(playerXName.getText(), playerOName.getText(), false);
                AppControler.ViewPane(AppControler.gameBoard);
                
            } 

        });
        
        
        
        back.setOnAction((Action) -> {
            AppControler.ViewPane(AppControler.startMenu);
        });
        
        
        
    }
    
    public void SetFont(Font newFont){
        playerXLabel.setFont(newFont);
        playerOLabel.setFont(newFont);
        playerXName.setFont(newFont);
        playerOName.setFont(newFont);
        start.setFont(newFont);
        back.setFont(newFont);
    }
}
