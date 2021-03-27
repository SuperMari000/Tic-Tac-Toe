
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setColumnSpan;
import static javafx.scene.layout.GridPane.setHalignment;
import static javafx.scene.layout.GridPane.setHgrow;
import static javafx.scene.layout.GridPane.setMargin;
import static javafx.scene.layout.GridPane.setRowSpan;
import static javafx.scene.layout.GridPane.setValignment;
import static javafx.scene.layout.GridPane.setVgrow;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Pair;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */
public class GameBoard extends GridPane{

    private GamePlayer gamePlayer = new GamePlayer();
    
    private final int len = 3;
    private Label playerXName = new Label();
    private Label playerOName = new Label();
    private Label playerXScore = new Label();
    private Label playerOScore = new Label();
    private Label currentPlayerSymbol = new Label();
    private GridPane boardPane = new GridPane();
    private Button boardButtons[][] = new Button[len][len];
    private Button back = new Button("Back");
    private Button newGame = new Button("New Game");
    
    private boolean isSinglePlayer;
    private boolean isGameEnd;
    private boolean nowPlayer = true;
    private Pair<Integer,Integer> pointPlay;

    
    private String boardStr[][] = new String[len][len];
    
    private Color colorX = Color.BLUE;
    private Color colorO = Color.RED;
    private String defaultStyleButton = "-fx-background-color:#F4F4F4;"
                                      + "-fx-border-color:transparent;"
                                      + "-fx-border-radius:50%;"
                                      + "-fx-background-insets:0px;"
                                      + "-fx-cursor:hand;";

    
    private BackgroundImage backgroundImage;
    private Background background;
    private BackgroundSize backgroundSize;
    
    
    
    public GameBoard(){
        
        playerXName.setMaxSize(120, Double.MAX_VALUE);
        setHgrow(playerXName, Priority.SOMETIMES);
        playerOName.setMaxSize(120, Double.MAX_VALUE);
        setHgrow(playerOName, Priority.SOMETIMES);
        playerXScore.setMaxSize(120, Double.MAX_VALUE);
        setHgrow(playerXScore, Priority.SOMETIMES);
        playerOScore.setMaxSize(120, Double.MAX_VALUE);
        setHgrow(playerOScore, Priority.SOMETIMES);
        
        CreateBoard();
        
        playerXName.setAlignment(Pos.CENTER);
        playerOName.setAlignment(Pos.CENTER);
        playerXScore.setAlignment(Pos.CENTER);
        playerOScore.setAlignment(Pos.CENTER);
        currentPlayerSymbol.setAlignment(Pos.CENTER);
        
        
        
        currentPlayerSymbol.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        setHgrow(currentPlayerSymbol, Priority.ALWAYS);
        setVgrow(currentPlayerSymbol, Priority.ALWAYS);

        
        back.setPrefWidth(130);
        newGame.setPrefWidth(130);

        setHgrow(back, Priority.ALWAYS);
        setHgrow(newGame, Priority.ALWAYS);
        
        setVgap(20);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(50));
        setMinSize(400, 500);
        
        setMargin(boardPane, new Insets(30,0,30,0));
       
        
        
        
        
        setHalignment(playerXName, HPos.CENTER);
        setHalignment(playerOName, HPos.CENTER);
        setHalignment(playerXScore, HPos.CENTER);
        setHalignment(playerOScore, HPos.CENTER);
        setHalignment(currentPlayerSymbol, HPos.CENTER);
        setHalignment(boardPane, HPos.CENTER);
        setHalignment(back, HPos.CENTER);
        setHalignment(newGame, HPos.CENTER);
        
        setValignment(playerXName, VPos.CENTER);
        setValignment(playerOName, VPos.CENTER);
        setValignment(playerXScore, VPos.CENTER);
        setValignment(playerOScore, VPos.CENTER);
        setValignment(currentPlayerSymbol, VPos.CENTER);
        setValignment(boardPane, VPos.CENTER);
        setValignment(back, VPos.CENTER);
        setValignment(newGame, VPos.CENTER);
        
        
       
        setColumnSpan(boardPane, 3);
        setRowSpan(boardPane, 3);

        
        setRowSpan(currentPlayerSymbol, 2);

        

        add(playerXName,0,0);
        add(playerOName,2,0);
        add(playerXScore,0,1);
        add(playerOScore,2,1);
        
        add(currentPlayerSymbol,1,0);
        
        add(boardPane,0,2);
        
        add(back,0,5);
        add(newGame,2,5);
        
        
        
        newGame.setOnAction((Action) -> {
            
            this.StartNewGame(Integer.parseInt(playerXScore.getText()),
                              Integer.parseInt(playerOScore.getText()),
                              isSinglePlayer);
            
            if(isSinglePlayer && !isGameEnd && !nowPlayer){
                pointPlay = gamePlayer.BestMove(boardStr);
                this.SetCurrentPlay(pointPlay.getKey(),pointPlay.getValue());
                this.isGameEnd = SetGameEnd();
                nowPlayer = !nowPlayer;
                this.SetCurrentSymbol();
            }
        });
        
        back.setOnAction((Action) -> {
            if(this.isSinglePlayer)
                AppControler.ViewPane(AppControler.singlePlayer);
            else
                AppControler.ViewPane(AppControler.multiPlayer);
        });
        
    }
    
    public void CreateBoard(){

        boardPane.setHgap(10);
        boardPane.setVgap(10);
        boardPane.setAlignment(Pos.CENTER);
        
        for(int row=0 ; row<len ; ++row){
            
            for(int col=0 ; col<len ; ++col){
                boardButtons[row][col] = new Button("");
                boardStr[row][col] = new String("");
                
                boardButtons[row][col].setPrefSize(100, 100);
                
                boardButtons[row][col].setFocusTraversable(false);
                boardButtons[row][col].setStyle(defaultStyleButton);
                boardButtons[row][col].setFont(Font.font("Comic Sans Ms", FontWeight.BOLD, 45));
                boardButtons[row][col].setAlignment(Pos.CENTER);
                boardButtons[row][col].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                boardPane.setHgrow(boardButtons[row][col], Priority.SOMETIMES);
                boardPane.setVgrow(boardButtons[row][col], Priority.SOMETIMES);
                boardPane.setHalignment(boardButtons[row][col], HPos.CENTER);
                boardPane.setValignment(boardButtons[row][col], VPos.CENTER);
                
                
                boardPane.add(boardButtons[row][col],col,row);
            }
            
        }
        
        
        for(int row=0 ; row<len ; ++row){
            for(int col=0 ; col<len ; ++col){
                final int x = row,y = col;
                boardButtons[row][col].setOnAction((Action) -> {
                    
                    if(!isGameEnd && boardButtons[x][y].getText().equals("")){
                        this.SetCurrentPlay(x,y);
                        
                        this.isGameEnd = SetGameEnd();
                        
                        nowPlayer = !nowPlayer;
                        
                        if(isSinglePlayer && !isGameEnd && !nowPlayer){
                            pointPlay = gamePlayer.BestMove(boardStr);
                            this.SetCurrentPlay(pointPlay.getKey(),pointPlay.getValue());
                            this.isGameEnd = SetGameEnd();
                            nowPlayer = !nowPlayer;
                        }
                        
                        
                        
                        this.SetCurrentSymbol();
                    }
                    
                    
                });
            }
        }
        

        
    }
    
    
    public void StartGameBoard(String firstName,String secondName,boolean isSingle){
        playerXName.setText(firstName);
        playerOName.setText(secondName);
        
        this.nowPlayer = true;
        this.SetBackgroundBoard(AppControler.imageBoard);
        
        this.StartNewGame(0, 0, isSingle);
        
    }
    public void StartNewGame(int firstScore,int secondScore,boolean isSingle){
        
        this.ClearBoard();
        this.SetGameScore(firstScore,secondScore);
        this.SetCurrentSymbol();
        this.isSinglePlayer = isSingle;
        this.isGameEnd = false;
        
    }
    public void SetGameScore(int firstScore,int secondScore){
        playerXScore.setText(Integer.toString(firstScore));
        playerOScore.setText(Integer.toString(secondScore));
    }
    public void SetCurrentSymbol(){
        
        if(nowPlayer){
            currentPlayerSymbol.setText("X");
            currentPlayerSymbol.setTextFill(colorX);
        }else{
            currentPlayerSymbol.setText("O");
            currentPlayerSymbol.setTextFill(colorO);
        }
    }
    public void SetCurrentPlay(int x,int y){
        
        if(nowPlayer){
            boardStr[x][y]="X";
            boardButtons[x][y].setText(boardStr[x][y]);
            boardButtons[x][y].setTextFill(colorX);
        }else{
            boardStr[x][y]="O";
            boardButtons[x][y].setText(boardStr[x][y]);
            boardButtons[x][y].setTextFill(colorO);
        }
    }
    
    public boolean SetGameEnd(){

        if(gamePlayer.IsBlayWin(boardStr, "X")){
            this.SetColorWin(gamePlayer.GetWinPoints(boardStr,"X"));
            this.SetGameScore(Integer.parseInt(playerXScore.getText())+1,
                                Integer.parseInt(playerOScore.getText()));

        }else if(gamePlayer.IsBlayWin(boardStr, "O")){
            this.SetColorWin(gamePlayer.GetWinPoints(boardStr,"O"));
            this.SetGameScore(Integer.parseInt(playerXScore.getText()),
                                Integer.parseInt(playerOScore.getText())+1);

        }else if(gamePlayer.IsGameComplete(boardStr)){
            this.SetGameScore(Integer.parseInt(playerXScore.getText())+1,
                                Integer.parseInt(playerOScore.getText())+1);

        }
        
        return gamePlayer.IsBlayWin(boardStr, "X") ||
               gamePlayer.IsBlayWin(boardStr, "O") ||
               gamePlayer.IsGameComplete(boardStr);
    }
    public void SetColorWin(ArrayList<Pair<Integer,Integer>> lstWin){
        
        for(Pair<Integer,Integer> p : lstWin){
            boardButtons[p.getKey()][p.getValue()].setStyle("-fx-background-color:yellow");
        }
        
    }
    public void ClearBoard(){
        
        for(int row=0 ; row<len ; ++row){
            
            for(int col=0 ; col<len ; ++col){
                
                boardButtons[row][col].setStyle(defaultStyleButton);
                boardButtons[row][col].setText("");
                boardStr[row][col] = "";

                
            }
        }
    }

    public void SetFont(Font newFont){

        playerXName.setFont(newFont);
        playerOName.setFont(newFont);
        playerXScore.setFont(newFont);
        playerOScore.setFont(newFont);
        currentPlayerSymbol.setFont(Font.font("Comic Sans Ms", FontWeight.BOLD, 20));
        back.setFont(newFont);
        newGame.setFont(newFont);
        
    }
    
    public void SetBackgroundBoard(Image newImage){

        backgroundSize=new BackgroundSize(0, 0, true, true, true, true);
        backgroundImage = new BackgroundImage(newImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        background = new Background(backgroundImage);
        
        this.boardPane.setBackground(background);
        
    }
    
}
