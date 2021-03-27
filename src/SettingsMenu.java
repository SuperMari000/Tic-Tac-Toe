
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class SettingsMenu extends GridPane{

    private Label boards = new Label("Game Board");
    private Label fontSizes = new Label("Font Size");
    private ComboBox boardsComboBox = new ComboBox();
    private ComboBox fontSizesComboBox = new ComboBox();
    private Button back = new Button("Back");

    
    
    
    public SettingsMenu(){
        
        CreateComboBox();
        
        back.setPrefWidth(200);
        
        setHgap(20);
        setVgap(20);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(50));
        setMinSize(400, 500);
        
        setMargin(back, new Insets(40,0,0,0));
        setHalignment(back, HPos.CENTER);
        
        setColumnSpan(back, 2);
        
        add(boards,0,0);
        add(boardsComboBox,1,0);
        
        add(fontSizes,0,1);
        add(fontSizesComboBox,1,1);
        
        add(back,0,2);
        
        
        back.setOnAction((Action) -> {
            AppControler.ViewPane(AppControler.startMenu);
        });
        
        
    }
    
    public void CreateComboBox(){
        
        boardsComboBox.getItems().addAll("Board 1", "Board 2", "Board 3", "Board 4", "Board 5");
        fontSizesComboBox.getItems().addAll("Small", "Medium", "Large");
        
        boardsComboBox.getSelectionModel().selectFirst();
        fontSizesComboBox.getSelectionModel().selectFirst();
        
        
        boardsComboBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
                switch((int)newVal) {
                    case 0:
                        AppControler.SetImageBoard("board_1.JPG");
                        break;
                        
                    case 1:
                        AppControler.SetImageBoard("board_2.JPG");
                        break;
                        
                    case 2:
                        AppControler.SetImageBoard("board_3.JPG");
                        break;
                        
                    case 3:
                        AppControler.SetImageBoard("board_4.JPG");
                        break;
                        
                    case 4:
                        AppControler.SetImageBoard("board_5.JPG");
                        break;
                }
        });
        
        fontSizesComboBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
                switch((int)newVal) {
                    case 0:
                        AppControler.SetFontSize(16);
                        break;
                        
                    case 1:
                        AppControler.SetFontSize(17);
                        break;
                        
                    case 2:
                        AppControler.SetFontSize(18);
                        break;
 
                }
                AppControler.SetFontControl();
        });
    }
    
    public void SetFont(Font newFont){
        boards.setFont(newFont);
        fontSizes.setFont(newFont);
        back.setFont(newFont);

        String comboboxStyle = "-fx-font-family:" + newFont.getName() + ";"
                             + "-fx-font-size: " + newFont.getSize() +"px;"
                             + "-fx-font-weight: normal;";
        
        boardsComboBox.setStyle(comboboxStyle);
        fontSizesComboBox.setStyle(comboboxStyle);
        
    }
    
}
