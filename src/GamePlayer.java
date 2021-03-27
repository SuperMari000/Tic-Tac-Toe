
import java.util.ArrayList;
import javafx.util.Pair;


/**
 *
 * @author Mostafa Mounir Shehab
 * 
 * User Name : Super Mari000
 * 
 */
public class GamePlayer {

    private final int len=3;
    private int OO = 1000;
    private boolean flage;
    
    public ArrayList<Pair<Integer,Integer>> GetWinPoints(String boardGame[][], String winner){
        ArrayList<Pair<Integer,Integer>> points = new ArrayList<Pair<Integer,Integer>>();
        
        for(int i=0;i<len;++i){
            
            if(boardGame[i][0].equals(boardGame[i][1]) && boardGame[i][0].equals(boardGame[i][2]) && boardGame[i][0].equals(winner)){
                points.add(new Pair(i,0));
                points.add(new Pair(i,1));
                points.add(new Pair(i,2));
            }
            
            if(boardGame[0][i].equals(boardGame[1][i]) && boardGame[0][i].equals(boardGame[2][i]) && boardGame[0][i].equals(winner)){
                points.add(new Pair(0,i));
                points.add(new Pair(1,i));
                points.add(new Pair(2,i));
            }
            
        }
        
        if(boardGame[0][0].equals(boardGame[1][1]) && boardGame[0][0].equals(boardGame[2][2]) && boardGame[1][1].equals(winner)){
            points.add(new Pair(0,0));
            points.add(new Pair(1,1));
            points.add(new Pair(2,2));
        }
        if(boardGame[1][1].equals(boardGame[2][0]) && boardGame[1][1].equals(boardGame[0][2]) && boardGame[1][1].equals(winner)){
            points.add(new Pair(0,2));
            points.add(new Pair(1,1));
            points.add(new Pair(2,0));
        }

        
        return points;
    }
    
    public boolean IsBlayWin(String boardGame[][],String currentPlay){
        flage=false;
        for(int i=0;i<len;++i){
            flage|=(boardGame[i][0].equals(boardGame[i][1]) &&
                    boardGame[i][0].equals(boardGame[i][2]) &&
                    boardGame[i][0].equals(currentPlay));
            
            flage|=(boardGame[0][i].equals(boardGame[1][i]) &&
                    boardGame[0][i].equals(boardGame[2][i]) &&
                    boardGame[0][i].equals(currentPlay));
        }
        
        flage|=(boardGame[0][0].equals(boardGame[1][1]) &&
                boardGame[0][0].equals(boardGame[2][2]) &&
                boardGame[0][0].equals(currentPlay));
            
        flage|=(boardGame[0][2].equals(boardGame[1][1]) &&
                boardGame[0][2].equals(boardGame[2][0]) &&
                boardGame[0][2].equals(currentPlay));
        
        return flage;
    }
    public boolean IsGameComplete(String boardGame[][]){
        flage=true;
        for(int row=0;row<len;++row){
            for(int col=0;col<len;++col){
                
                flage&=!(boardGame[row][col].equals(""));
                
            }   
        }
        
        return flage;
    }

    public Pair<Integer,Integer> BestMove(String boardGame[][]){

        int bestScore = Integer.MIN_VALUE;
        Pair<Integer,Integer> p = new Pair(-1,-1);
        
        for(int row=0;row<len;++row){
            for(int col=0;col<len;++col){
                if(boardGame[row][col].equals("")){
                    
                   boardGame[row][col] = "O";
                   
                   int Score = MiniMax(boardGame, 0, false);
                   
                   boardGame[row][col] = "";
                   
                   System.out.println("Row :" + row + " , Col :" + col + "  || Best Score = " + Score);
                   
                   if(Score > bestScore){
                       p = new Pair(row,col);
                       bestScore = Score;
                   }

                }
                
            }
        }
        System.out.println(" ||| ");
        return p;
    }
    
    public int MiniMax(String boardGame[][],int depth,boolean isMax){
        
        if(IsBlayWin(boardGame,"X"))
            return -OO;
        if(IsBlayWin(boardGame,"O"))
            return OO;
        
        if(IsGameComplete(boardGame))
            return 0;
        
        
        int MX=-OO,MN=OO;
        
        for(int row=0 ; row<len ; ++row){
            for(int col=0 ; col<len ; ++col){
                if(boardGame[row][col].equals("")){
                    if(isMax){
                        boardGame[row][col] = "O";
                        
                        MX = Math.max(MX, MiniMax(boardGame, depth+1, !isMax));
                        
                        boardGame[row][col] = "";
                    }else{
                        
                        boardGame[row][col] = "X";
                        
                        MN = Math.min(MN, MiniMax(boardGame, depth+1, !isMax));
                        
                        boardGame[row][col] = "";
                        
                    }
                }
                
            }
        }
        
        return isMax ? MX : MN;
    }
    
    
}
