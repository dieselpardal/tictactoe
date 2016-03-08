public class GameView {

    private void walls() {
        System.out.println("     |     |");
    }
    private void floor() {
        System.out.println("_____|_____|_____");
    }
    private void pieces(ScoreBoard scoreBoard, int p1, int p2, int p3) {
        System.out.println("  "+scoreBoard.getPiece(p1)+"  |  "+scoreBoard.getPiece(p2)+"  | "+scoreBoard.getPiece(p3));
    }

    public void view(ScoreBoard scoreBoard) {
        System.out.println("      TIC  TAC  TOE\n");
        System.out.println("Human <X>    -   Computer <O>");
        System.out.println("  " + scoreBoard.player1 + " pontos     -    " + scoreBoard.player2 + " pontos\n");
        walls();
        pieces(scoreBoard, 1, 2, 3);
        floor();
        walls();
        pieces(scoreBoard, 4, 5, 6);
        floor();
        walls();
        pieces(scoreBoard, 7, 8, 9);
        walls();
    }
}