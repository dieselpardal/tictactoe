import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AttackTest {

    @Spy
    Attack attack;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotAttackBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        attack.process(mem );
        assertThat(mem.getNumPiece(), is(0));
    }

    @Test
    public void shouldAttackFirstIftwoCumputersBoard () {

        String[] piece = {"0", "O", "O", "3", "4", "5", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        attack.process(mem );
        assertThat(mem.getNumPiece(), is(3));
    }

    @Test
    public void shouldTableAttackIfLastColBoard () {

        String[] piece = {"0", "1", "2", "O", "4", "5", "O", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        attack.process(mem );
        assertThat(mem.getNumPiece(), is(9));
    }

    @Test
    public void shouldTableAttackCenterIfLastColBoard () {

        String[] piece = {"0", "1", "2", "O", "4", "5", "6", "7", "8", "O" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        attack.process(mem );
        assertThat(mem.getNumPiece(), is(6));
    }

    @After
    public void free() {
        attack = null;
    }
}
