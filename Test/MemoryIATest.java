import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

public class MemoryIATest {

        private String[] piece1 = {"0", "O", "O", "3", "4", "5", "6", "7", "X", "X" };
        private String[] piece2 = {"0", "X", "2", "3", "4", "X", "6", "7", "8", "O" };
        private String[] piece3 = {"0", "X", "O", "3", "4", "O", "6", "7", "8", "9" };
        @Spy
        private MemoryAI mem1 = spy(new MemoryAI(piece1, "O", "X"));
        @Spy
        private MemoryAI mem2 = spy(new MemoryAI(piece2, "O", "X"));
        @Spy
        private MemoryAI mem3 = spy(new MemoryAI(piece3, "O", "X"));
        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void shouldCenterNotExist () {

            mem1.centerNotExist();
            assertThat(mem1.getNumPiece(), is(5));
        }
    @Test
    public void shouldAttackOfTwoCumputers () {

        mem1.attackOfTwoCumputers(1, 2, 3);
        assertThat(mem1.getNumPiece(), is(3));
    }

    @Test
    public void shouldDefenseTwoAdversary () {

        mem1.defenseTwoAdversary(8, 9, 7);
        assertThat(mem1.getNumPiece(), is(7));
    }

    @Test
    public void shouldDefenseTwoAdversaryOneComputers () {

        mem2.defenseTwoAdversaryOneComputers(1, 9, 6);
        assertThat(mem2.getNumPiece(), is(6));
    }

    @Test
    public void shouldShieldBehindAdversarySpy () {

        mem3.shieldBehindAdversarySpy(1, 9);
        assertThat(mem3.getNumPiece(), is(9));
    }
    @Test
    public void shouldShieldTwoComputersOneAdversary () {

        mem3.shieldTwoComputersOneAdversary(2, 9, 8);
        assertThat(mem3.getNumPiece(), is(8));
    }
    @Test
    public void shouldPieceNumExist () {


        assertThat(mem1.pieceNumExist(5), is(true));
    }
    @After
    public void free() {
        mem1 = null;
        mem2 = null;
        mem3 = null;
    }

}

