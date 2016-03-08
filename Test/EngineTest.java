import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

public class EngineTest {

    @Spy
    private Attack attack = spy(new Attack());
    @Spy
    private Defenser defenser = spy(new Defenser());
    @Spy
    private Shield shield = spy(new Shield());
    @Spy
    private Engine engine = spy(new Engine(attack, defenser, shield ));
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldDefenserCenterIfEmptyBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        int result = engine.playAI(piece, "O", "X");
        assertThat(result, is(5));
    }

    @Test
    public void shouldDefenserOneIfCenterBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "X", "6", "7", "8", "9" };
        int result = engine.playAI(piece, "O", "X");
        assertThat(result, is(1));
    }

    @Test
    public void shouldShieldOneAndSevenIfDiagonalBoard () {

        String[] piece = {"0", "O", "2", "3", "4", "X", "6", "7", "8", "X" };
        int result = engine.playAI(piece, "O", "X");
        assertThat(result, is(6));
    }

    @Test
    public void shouldDefenserOneIfAdversaryTwoAndThreeBoard () {

        String[] piece = {"0", "1", "X", "X", "4", "O", "6", "7", "8", "9" };
        int result = engine.playAI(piece, "O", "X");
        assertThat(result, is(1));
    }

    @Test
    public void shouldPieceOneIfAttackBoard () {

        String[] piece = {"0", "1", "O", "O", "4", "X", "6", "7", "8", "9" };
        int result = engine.playAI(piece, "O", "X");
        assertThat(result, is(1));
    }
    @After
    public void free() {
        attack = null;
        defenser = null;
        shield = null;
        engine = null;
    }
}
