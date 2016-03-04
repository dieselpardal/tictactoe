public class ScoreBoard {

    private final int PIECE = 10;
    private String[] piece;

    public int player1;
    public int player2;

    public ScoreBoard() {
        this.player1 = 0;
        this.player2 = 0;
        this.piece = new String[PIECE];

    }
    public void setPiece(int piece, String bet) {
        this.piece[piece] = bet;
    }
    public String getPiece(int piece) {
        return this.piece[piece];
    }
    public String[] getPieces() {
        return this.piece;
    }
    public int getLengthPieces() {
        return this.piece.length;
    }
    public void reset() {

        for(int i =0; i < this.piece.length; i++) {
            this.piece[i] = String.valueOf(i);
        }
    }
}
