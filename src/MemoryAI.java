public class MemoryAI {

    private String computer;
    private String adversary;
    private String[] pieces;
    private int numPiece;

    public MemoryAI(String[] pieces, String computer, String adversary) {
        this.computer = computer;
        this.adversary = adversary;
        this.pieces = pieces;
        this.numPiece =0;
    }
    public void centerNotExist(){
        this.numPiece =  this.numPiece==0 &&  pieceNumExist(5) ? 5 : 0;
    }
    public void attackOfTwoCumputers(int piece1, int piece2, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.pieces[piece1] == this.computer &&  this.pieces[piece2] == this.computer) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void defenseTwoAdversary(int adversary1, int adversary2, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.pieces[adversary1] == this.adversary &&  this.pieces[adversary2] == this.adversary) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void defenseTwoAdversaryOneComputers( int adversary1, int piece1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.pieces[adversary1] == this.adversary &&  this.pieces[5] == this.adversary &&  this.pieces[piece1] == this.computer) && pieceNumExist(pullComputer) ? pullComputer : this.numPiece;
    }
    public void shieldBehindAdversarySpy( int adversary1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.pieces[adversary1] == this.adversary && this.pieces[5] == this.computer) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void shieldTwoComputersOneAdversary( int piece1, int adversary1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.pieces[piece1] == this.computer &&  this.pieces[5] == this.computer && pieceNumExist( adversary1)) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public boolean pieceNumExist( int piece1) {
        return (this.pieces[piece1] != this.adversary) && (this.pieces[piece1] != this.computer);
    }
    public int lastChance() {
        if( this.numPiece ==0) {
            int piece = 1; while (!pieceNumExist(piece) && piece < this.pieces.length){ piece++;}
            return piece;
        }
        return this.numPiece;
    }
    public int getNumPiece() {
        return this.numPiece;
    }
}
