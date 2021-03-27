
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */

public class StartMenu extends GridPane{
        
    private Button singlePlayer = new Button("Single Player");
    private Button multiPlayer = new Button("Multi Player");
    private Button settings = new Button("Settings");
    private Button exit = new Button("Exit");
    
    private String buttonStyle;
    private String revButtonStyle;
    
    private Image image;
    private BackgroundImage backgroundImage;
    private BackgroundSize backgroundSize;
    private Background background;
    

   
    public StartMenu() {
        
        singlePlayer.setPrefWidth(240);
        multiPlayer.setPrefWidth(240);
        settings.setPrefWidth(240);
        exit.setPrefWidth(240);
        
        StyleButton();
        
        setHgap(20);
        setVgap(20);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(50));
        setMinSize(400, 500);



        
        setBackground(SetBackground());
     
        add(singlePlayer,0,0);
        add(multiPlayer,0,1);
        add(settings,0,2);
        add(exit,0,3);


        singlePlayer.setOnAction((Action) -> {
            AppControler.ViewPane(AppControler.singlePlayer);
           
        });
        
        multiPlayer.setOnAction((Action) -> {
            AppControler.ViewPane(AppControler.multiPlayer);
        });


        settings.setOnAction((Action) -> {
           AppControler.ViewPane(AppControler.settingsMenu);
        });


        exit.setOnAction((Action) -> {
            System.exit(0);
        });
    }
    
    public void StyleButton(){
        this.buttonStyle = ("-fx-background-color:rgba(255,255,255,0.7);"
                        + "-fx-border-size:1px;"
                        + "-fx-border-style:solid;"
                        + "-fx-border-color:transparent;"
                        + "-fx-border-radius:1%;"
                        + "-fx-background-insets:0px;");
        
        this.revButtonStyle = ("-fx-background-color:rgba(255,255,255,0.4);"
                            + "-fx-border-size:1px;"
                            + "-fx-border-style:solid;"
                            + "-fx-border-color:#EEE;"
                            + "-fx-border-radius:1%;"
                            + "-fx-background-insets:0px;");
        
        singlePlayer.setStyle(buttonStyle);
        multiPlayer.setStyle(buttonStyle);
        settings.setStyle(buttonStyle);
        exit.setStyle(buttonStyle);
        
        singlePlayer.setOnMouseEntered(e -> {
            singlePlayer.setStyle(revButtonStyle);
            
        });
        singlePlayer.setOnMouseExited(e -> {
            singlePlayer.setStyle(buttonStyle);
        });
        
        multiPlayer.setOnMouseEntered(e -> {
            multiPlayer.setStyle(revButtonStyle);
        });
        multiPlayer.setOnMouseExited(e -> {
            multiPlayer.setStyle(buttonStyle);
        });
        
        settings.setOnMouseEntered(e -> {
            settings.setStyle(revButtonStyle);
        });
        settings.setOnMouseExited(e -> {
            settings.setStyle(buttonStyle);
        });
        
        exit.setOnMouseEntered(e -> {
            exit.setStyle(revButtonStyle);
        });
        exit.setOnMouseExited(e -> {
            exit.setStyle(buttonStyle);
        });
        
        
    }
    public Background SetBackground(){
        
        try{
            
            image = new Image(new FileInputStream("./src/img/Start_Background.jpg"));
            
        }catch(Exception e){
            System.exit(0);
        }
        
        backgroundSize=new BackgroundSize(0, 0, true, true, false, true);
        
        backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        
        return new Background(backgroundImage);
    }
    public void SetFont(Font newFont){
        singlePlayer.setFont(newFont);
        multiPlayer.setFont(newFont);
        settings.setFont(newFont);
        exit.setFont(newFont);
    }
}
