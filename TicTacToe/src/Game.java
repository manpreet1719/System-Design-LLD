import java.util.*;

public class Game {

    Deque<Player> players;
    Board gameboard;
    Game(){
        players = new LinkedList<Player>();
        CellX cellX = new CellX();
        players.add(new Player("Player1",cellX));
        CellO cellY = new CellO();
        players.add((new Player("Player2",cellY)));
        gameboard = new Board(3);
    }
    public String startGame(){

        boolean isWinner = true;
        while(isWinner){
            Player playerturn = players.removeFirst();
            gameboard.printBoard();
            boolean freeCells = gameboard.getFreeCells();
            if(!freeCells){
                isWinner = false;
                continue;
            }

            System.out.print("Player " + playerturn.getName() + "Enter Position");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean isValidPosition = gameboard.addAtPostion(inputRow,inputColumn,playerturn.cellType);

            if(!isValidPosition){
                System.out.print("Please Enter valid Position");
                players.addFirst(playerturn);
                continue;
            }
            players.addLast(playerturn);

            boolean iswinner = isWinner(inputRow,inputColumn,playerturn.cellType.cellType);
            if(iswinner){
                 return playerturn.name;
            }
        }
        return "Match Tie";
    }

    public boolean isWinner(int row,int column,CellType cellType){
        boolean isrow = true;
        boolean isColumn = true;
        boolean isDiagonal = true;
        boolean isAntiDiagonal = true;
        for(int i = 0;i<gameboard.size;i++){
            if(gameboard.board[row][i] == null || gameboard.board[row][i].cellType != cellType){
                isrow = false;
            }
        }
        for(int i = 0;i<gameboard.size;i++){
            if(gameboard.board[i][column] == null || gameboard.board[i][column].cellType != cellType){
                isColumn = false;
            }
        }
        for(int i = 0,j=0;i<gameboard.size;i++,j++){
            if(gameboard.board[i][j] == null || gameboard.board[i][j].cellType != cellType){
                isDiagonal = false;
            }
        }
        for(int i = 0,j= gameboard.size-1;i< gameboard.size;i++,j--){
            if(gameboard.board[i][j] == null || gameboard.board[i][j].cellType != cellType){
                isAntiDiagonal = false;
            }
        }
        return isrow || isColumn || isDiagonal || isAntiDiagonal;
    }



}
