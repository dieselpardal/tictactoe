public class GameView {

    private void Walls() {
        System.out.println("     |     |");
    }
    private void Floor() {
        System.out.println("_____|_____|_____");
    }
    private void Pieces(ScoreBoard scoreBoard,int p1, int p2, int p3) {
        System.out.println("  "+scoreBoard.getPiece(p1)+"  |  "+scoreBoard.getPiece(p2)+"  | "+scoreBoard.getPiece(p3));
    }

    public void View(ScoreBoard scoreBoard) {
        System.out.println("      TIC  TAC  TOE\n");
        System.out.println("Human <X>    -   Computer <O>");
        System.out.println("  " + scoreBoard.player1 + " pontos     -    " + scoreBoard.player2 + " pontos\n");
        Walls();
        Pieces(scoreBoard, 1, 2, 3);
        Floor();
        Walls();
        Pieces(scoreBoard, 4, 5, 6);
        Floor();
        Walls();
        Pieces(scoreBoard, 7, 8, 9);
        Walls();
    }
}