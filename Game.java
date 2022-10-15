public class Game {
    Board board;
    Player[] players;
    boolean[] isAllowed;
    int turn;
    Coordinates[] places;
    Game(Board board,Player[] players){
        this.board = board;
        this.players = players;
        isAllowed = new boolean[players.length];
        turn = 0;
        places = new Coordinates[players.length];
        for(int i=0;i<players.length;i++){
            places[i] = new Coordinates(board.size-1, 0);
        }
    }

    public void play(){
        while(true){
            int num = Die.roll();

            // System.out.println(players[turn].name + " rolled -> " + num + places[turn]);
            if(isAllowed[turn] == false){
                if(num != 1){
                    turn = (turn+1)%players.length;
                    continue;
                }
                else{
                    isAllowed[turn] = true;
                }
            }

            Coordinates newCoordinates = getNewCoordinates(places[turn],num);
            if(newCoordinates.row_number < 0){
                System.out.println(players[turn].name + " has won.");
                return;
            }

            places[turn] = newCoordinates;
            turn = (turn+1)%players.length;
        }
    }

    public Coordinates getNewCoordinates(Coordinates old,int numofMoves){
        int row_number = old.row_number;
        int col_number = old.col_number;

        while(numofMoves-- > 0){
            if(board.size%2==0){
                if(row_number%2 == 0){
                    if(col_number == board.size-1){
                        row_number--;
                    }
                    else{
                        col_number++;
                    }
                }
                else{
                    if(col_number == 0){
                        row_number--;
                    }
                    else{
                        col_number--;
                    }
                }
            }
            else{
                if(row_number%2 != 0){
                    if(col_number == board.size-1){
                        row_number--;
                    }
                    else{
                        col_number++;
                    }
                }
                else{
                    if(col_number == 0){
                        row_number--;
                    }
                    else{
                        col_number--;
                    }
                }
            }
        }
        if(row_number < 0){
            return new Coordinates(row_number, col_number);
        }

        if(Check_if_jumper_exists(row_number,col_number)){
            
            Jumper jumpercoordinates = board.jumpers.get(board.board[row_number][col_number]);
            return jumpercoordinates.end;

        }
        return new Coordinates(row_number, col_number);
    }

    public boolean Check_if_jumper_exists(int row_number,int col_number){
        return board.jumpers.containsKey(board.board[row_number][col_number]);
    }

}
