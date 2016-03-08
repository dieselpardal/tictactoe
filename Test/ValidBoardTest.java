import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidBoardTest {

    @Spy
    private ValidBoard validBoard;
    @Spy
    private ScoreBoard scoreBoard;
    @Spy
    private Player player;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldProcessDiagonalLeftBoard() {

        scoreBoard.reset();
        scoreBoard.setPiece(1, "X");
        scoreBoard.setPiece(5, "X");
        scoreBoard.setPiece(9, "X");

        assertThat(validBoard.process(player, scoreBoard), is(true));
    }

    @Test
    public void shouldProcessDiagonalRightBoard() {

        scoreBoard.reset();
        scoreBoard.setPiece(3, "X");
        scoreBoard.setPiece(5, "X");
        scoreBoard.setPiece(7, "X");

        assertThat(validBoard.process(player, scoreBoard), is(true));
    }
    @Test
    public void shouldProcessDiagonalLinesBoard() {

        scoreBoard.reset();
        scoreBoard.setPiece(1, "X");
        scoreBoard.setPiece(2, "X");
        scoreBoard.setPiece(3, "X");

        assertThat(validBoard.process(player, scoreBoard), is(true));
    }
    public void shouldProcessDiagonalColsBoard() {

        scoreBoard.reset();
        scoreBoard.setPiece(1, "X");
        scoreBoard.setPiece(4, "X");
        scoreBoard.setPiece(7, "X");

        assertThat(validBoard.process(player, scoreBoard), is(true));
    }

    @After
    public void free() {
        validBoard = null;
        scoreBoard = null;
        player = null;
    }
}
