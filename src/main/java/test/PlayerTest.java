package test;

/**
 * Created by Sean on 26/04/2016.
 */

import dcu.datamodel.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void getEmailTest() {

        Player player = new Player();
        player.setEmail("seanogcarey@email.com");

        assertNotNull( player.getEmail());
        assertEquals(player.getEmail(),"seanogcarey@email.com");
    }
}

