public class ScoreBoard {

    private final int SIZE_PIECE = 10;
    private String[] pieces;

    public int player1;
    public int player2;

    public ScoreBoard() {
        this.player1 = 0;
        this.player2 = 0;
        this.pieces = new String[SIZE_PIECE];

    }
    public void setPiece(int piece, String bet) {
        this.pieces[piece] = bet;
    }
    public String getPiece(int piece) {
        return this.pieces[piece];
    }
    public String[] getPieces() {
        return this.pieces;
    }
    public int getLengthPieces() {
        return this.pieces.length;
    }
    public void reset() {

        for(int piece =0; piece < this.pieces.length; piece++) {
            this.pieces[piece] = String.valueOf(piece);
        }
    }
}
