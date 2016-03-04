import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefenserTest {

    @Spy
    Defenser defenser;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldNotDefenserBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(0));
    }

    @Test
    public void shouldTableAttackIfLastColBoard () {

        String[] piece = {"0", "1", "2", "X", "4", "5", "X", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(9));
    }

    @Test
    public void shouldTableAttackCenterIfLastColBoard () {

        String[] piece = {"0", "1", "2", "X", "4", "5", "6", "7", "8", "X" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(6));
    }

    @Test
    public void shouldDefenserIftwoAdversaryColBoard () {

        String[] piece = {"0", "1", "2", "X", "4", "5", "X", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(9));
    }
    @Test
    public void shouldDefenserIftwoAdversaryLineBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "X", "X", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(4));
    }

    @Test
    public void shouldDefenserIfTwoAdversaryOneComputersBoard () {

        String[] piece = {"0", "X", "2", "O", "4", "X", "6", "7", "8", "O" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(7));
    }
    @Test
    public void shouldDefenserIfHorseTwoAdversaryBoard () {

        String[] piece = {"0", "X", "2", "O", "4", "X", "6", "O", "8", "O" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        defenser.process(mem );
        assertThat(mem.getNumPiece(), is(2));
    }

    @After
    public void free() {
        defenser = null;
    }
}
