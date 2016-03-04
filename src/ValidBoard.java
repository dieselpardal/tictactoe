import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class ValidBoard {

    public boolean Process(Player player, ScoreBoard scoreBoard) {

        if (validationAllPieces(scoreBoard)) { //nao entrou aqui?
            if ( player.getPlayer() == 1) scoreBoard.player1++;
            else scoreBoard.player2++;
            return true;
        }
        if(pieceFullBoard(scoreBoard)) scoreBoard.reset();
        return false;
    }

    private boolean validationAllPieces(ScoreBoard scoreBoard)
    {
        if ( validThreePieces(scoreBoard, 1, 5, 9) || validThreePieces(scoreBoard, 3, 5, 7)) return true;
        int i = 0;
        while ( i< 3) {
            int g = i * 3;
            if ( validThreePieces(scoreBoard, 1 + g, 2 + g, 3 + g) || validThreePieces(scoreBoard, 1 + i, 4 + i, 7 + i)) return true;
            i++;
        }
        return false;
    }

    private boolean validThreePieces(ScoreBoard scoreBoard, int p1, int p2, int p3 )
    {
        return scoreBoard.getPiece(p1) == scoreBoard.getPiece(p2) && scoreBoard.getPiece(p1) == scoreBoard.getPiece(p3) && scoreBoard.getPiece(p2) == scoreBoard.getPiece(p3) ;
    }

    private boolean pieceFullBoard(ScoreBoard scoreBoard) {
        int i =1;
        while (i < scoreBoard.getLengthPieces()){
            if(isNumber(scoreBoard.getPiece(i)) ) return false;
            i++;}
        return true;
    }
}
