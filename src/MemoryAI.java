public class MemoryAI {

    private String Computer;
    private String Adversary;
    private String[] piece;
    private int numPiece;

    public MemoryAI(String[] piece, String Computer, String Adversary) {
        this.Computer = Computer;
        this.Adversary = Adversary;
        this.piece = piece;
        this.numPiece =0;
    }
    public void centerNotExist(){
        this.numPiece =  this.numPiece==0 &&  pieceNumExist(5) ? 5 : 0;
    }
    public void attackOfTwoCumputers(int p1, int p2, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.piece[p1] == this.Computer &&  this.piece[p2] == this.Computer ) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void defenseTwoAdversary(int a1, int a2, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.piece[a1] == this.Adversary &&  this.piece[a2] == this.Adversary) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void defenseTwoAdversaryOneComputers( int a1, int p1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.piece[a1] == this.Adversary &&  this.piece[5] == this.Adversary &&  this.piece[p1] == this.Computer) && pieceNumExist(pullComputer) ? pullComputer : this.numPiece;
    }
    public void shieldBehindAdversarySpy( int a1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.piece[a1] == this.Adversary && this.piece[5] == this.Computer) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public void shieldTwoComputersOneAdversary( int p1, int a1, int pullComputer) {
        this.numPiece =  this.numPiece==0 && (this.piece[p1] == this.Computer &&  this.piece[5] == this.Computer && pieceNumExist( a1)) && pieceNumExist( pullComputer) ? pullComputer : this.numPiece;
    }
    public boolean pieceNumExist( int p) {
        return (this.piece[p] != this.Adversary) && (this.piece[p] != this.Computer);
    }
    public int lastChance() {
        if( this.numPiece ==0) {
            int i = 1; while (!pieceNumExist( i) && i < this.piece.length){ i++;}
            return i;
        }
        return this.numPiece;
    }
    public int getNumPiece() {
        return this.numPiece;
    }
}
