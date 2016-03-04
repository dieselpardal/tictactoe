import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreBoardTest {

    @Mock
    private ScoreBoard scoreBoard;

    private String[] piece = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldExistBoard () {

        Mockito.when(scoreBoard.getPieces()).thenReturn(piece);
        assertThat(scoreBoard.getPieces(), is(piece));

    }

    @Test
    public void shouldDiagonalBoard () {

        Mockito.when(scoreBoard.getPiece(9)).thenReturn("X");
        assertThat(scoreBoard.getPiece(9), is("X"));
        Mockito.verify(scoreBoard).getPiece(9);
    }

    @Test
    public void shouldSizeOfPiecesBoard () {

        Mockito.when(scoreBoard.getLengthPieces()).thenReturn(piece.length);
        assertThat(scoreBoard.getLengthPieces(), is(10));

    }
    @After
    public void free() {
        scoreBoard = null;
    }
}
