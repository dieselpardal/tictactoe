import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShieldTest {

    @Spy
    Shield shield;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSHieldBoard () {

        String[] piece = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        shield.process(mem);
        assertThat(mem.getNumPiece(), is(0));
    }

    @Test
    public void shouldSHieldIfbehindAdversarySpyLeftBoard () {

        String[] piece = {"0", "X", "2", "3", "4", "O", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        shield.process(mem);
        assertThat(mem.getNumPiece(), is(9));
    }
    @Test
    public void shouldSHieldIfbehindAdversarySpyRightBoard () {

        String[] piece = {"0", "1", "2", "X", "4", "O", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        shield.process(mem);
        assertThat(mem.getNumPiece(), is(7));
    }

    @Test
    public void shouldSHieldIftwoCumputersBoard () {

        String[] piece = {"0", "1", "2", "O", "O", "5", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        shield.process(mem);
        assertThat(mem.getNumPiece(), is(1));
    }

    @Test
    public void shouldSHieldIftwoComputersOneAdversaryPreBoard () {

        String[] piece = {"0", "O", "2", "3", "4", "O", "6", "7", "8", "9" };
        MemoryAI mem = new MemoryAI(piece, "O", "X");
        shield.process(mem);
        assertThat(mem.getNumPiece(), is(2));
    }

    @After
    public void free() {
        shield = null;
    }
}
