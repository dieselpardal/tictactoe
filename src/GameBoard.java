import java.util.Scanner;

public class GameBoard {

    static final String PIECE_IA = "O";
    static final  String PIECE_HUMANO = "X";

    private GameView gameView ;
    private Player player;
    private ScoreBoard scoreBoard ;
    private Engine engine;
    private ValidBoard valid;
    private Scanner scanner;

    public GameBoard() {
        gameView = new GameView();
        player = new Player();
        scoreBoard = new ScoreBoard();
        engine = new Engine(new Attack(), new Defenser(), new Shield());
        valid = new ValidBoard();
        scanner = new Scanner(System.in);
    }
    public void start() {
        do {
            scoreBoard.reset();
            do {
                gameView.View(scoreBoard);
                if (player.next() == 2) {
                    scoreBoard.setPiece(engine.IA(scoreBoard.getPieces(), PIECE_IA, PIECE_HUMANO), PIECE_IA);
                } else {
                    scoreBoard.setPiece(player.Human(scoreBoard.getPieces(), PIECE_HUMANO, PIECE_IA), PIECE_HUMANO);
                }
            } while (!valid.Process(player, scoreBoard));
            gameView.View(scoreBoard);
            System.out.println("Again game? ( 0 = Exit    1= Yes) ");
        } while ( scanner.nextInt() != 0);
    }
}