package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };

    private Mark[][] board;

    private boolean currentlyX;

    public TicTacToeModel() {

        currentlyX = true;
        board = new Mark[3][3];

        for(int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++){
            board[i][j] = Mark.EMPTY;
          }
        }
    }

    public boolean setMarkAt(int row, int col) {

        if(getResult() != Result.NONE){return false;}
        if(board[row][col] != Mark.EMPTY){return false;}

        board[row][col] = currentlyX ? Mark.XMARK : Mark.OMARK;
        currentlyX = !currentlyX;

        return true;
    }

    public Mark getMarkAt(int row, int col) {
        return board[row][col];
    }

    private boolean resultMarkWinner(Mark checkThis){

        for(int i = 0; i < 3; i++){
            if(board[i][0] == checkThis && board[i][1] == checkThis && board[i][2] == checkThis){return true;}
            if(board[0][i] == checkThis && board[1][i] == checkThis && board[2][i] == checkThis){return true;}
        }

        if(board[0][0] == checkThis && board[1][1] == checkThis && board[2][2] == checkThis){return true;}
        if(board[0][2] == checkThis && board[1][1] == checkThis && board[2][0] == checkThis){return true;}

        return false;

    }

    public Result getResult() {

        if(resultMarkWinner(Mark.XMARK)){return Result.XWIN;}
        if(resultMarkWinner(Mark.OMARK)){return Result.OWIN;}

        for(int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++){
              if(board[i][j] == Mark.EMPTY){return Result.NONE;}
          }
        }

        return Result.TIE;
    }

    private String getChar(Mark theMark){
      if(theMark == Mark.XMARK){return "X";}
      if(theMark == Mark.OMARK){return "O";}
      return " ";
    }

    public String toString() {

        String theString =  getChar(getMarkAt(0,0)) + "|" + getChar(getMarkAt(0,1)) + "|" + getChar(getMarkAt(0,2)) + "\n" +
                            "-----\n" +
                            getChar(getMarkAt(1,0)) + "|" + getChar(getMarkAt(1,1)) + "|" + getChar(getMarkAt(1,2)) + "\n" +
                            "-----\n" +
                            getChar(getMarkAt(2,0)) + "|" + getChar(getMarkAt(2,1)) + "|" + getChar(getMarkAt(2,2));

        return theString;
    }

}
