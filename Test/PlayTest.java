import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayTest {

    @Spy
    private Player player;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInitPlayerBoard () {

        assertThat(player.next(), is(1));
    }

    @Test
    public void shouldDefenserCenterIfEmptyBoard () {
        player.next();
        assertThat(player.next(), is(2));
    }
    @After
    public void free() {
        player = null;
    }
}
