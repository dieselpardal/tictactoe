import java.util.Scanner;

public class GameBoard {

    static final String PIECE_IA = "O";
    static final  String PIECE_HUMAN = "X";

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
                gameView.view(scoreBoard);
                if (player.next() == 2) {
                    scoreBoard.setPiece(engine.playAI(scoreBoard.getPieces(), PIECE_IA, PIECE_HUMAN), PIECE_IA);
                } else {
                    scoreBoard.setPiece(player.playHuman(scoreBoard.getPieces(), PIECE_HUMAN, PIECE_IA), PIECE_HUMAN);
                }
            } while (!valid.process(player, scoreBoard));
            gameView.view(scoreBoard);
            System.out.println("Again game? ( 0 = Exit    1= Yes) ");
        } while ( scanner.nextInt() != 0);
    }
}