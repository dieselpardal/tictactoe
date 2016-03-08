import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class ValidBoard {

    public boolean process(Player player, ScoreBoard scoreBoard) {

        if (validationAllPieces(scoreBoard)) {
            if ( player.getPlay() == 1) scoreBoard.player1++;
            else scoreBoard.player2++;
            return true;
        }
        if(pieceFullBoard(scoreBoard)) scoreBoard.reset();
        return false;
    }

    private boolean validationAllPieces(ScoreBoard scoreBoard)
    {
        if ( validThreePieces(scoreBoard, 1, 5, 9) || validThreePieces(scoreBoard, 3, 5, 7)) return true;
        int line = 0;
        while ( line< 3) {
            int col = line * 3;
            if ( validThreePieces(scoreBoard, 1 + col, 2 + col, 3 + col) || validThreePieces(scoreBoard, 1 + line, 4 + line, 7 + line)) return true;
            line++;
        }
        return false;
    }

    private boolean validThreePieces(ScoreBoard scoreBoard, int piece1, int piece2, int piece3 )
    {
        return scoreBoard.getPiece(piece1) == scoreBoard.getPiece(piece2) && scoreBoard.getPiece(piece1) == scoreBoard.getPiece(piece3) && scoreBoard.getPiece(piece2) == scoreBoard.getPiece(piece3) ;
    }

    private boolean pieceFullBoard(ScoreBoard scoreBoard) {
        int piece =1;
        while (piece < scoreBoard.getLengthPieces()){
            if(isNumber(scoreBoard.getPiece(piece)) ) return false;
            piece++;}
        return true;
    }
}
