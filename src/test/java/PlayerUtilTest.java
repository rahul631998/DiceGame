import Model.PlayerUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerUtilTest {

    @Test
    public void TestgetPlayerList() {
        PlayerUtil playerUtil = new PlayerUtil();

        assertTrue("List is Empty", playerUtil.getPlayerList().isEmpty());
    }

    @Test
    public void TestpopulatePlayerList() {
        PlayerUtil playerUtil = new PlayerUtil();
        playerUtil.populatePlayerList(10);
        assertFalse("List is not Empty", playerUtil.getPlayerList().isEmpty());
    }
}