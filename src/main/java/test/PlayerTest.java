package test;

/**
 * Created by Sean on 26/04/2016.
 */

import dcu.datamodel.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void getPlayerIdTest() {

        Player player = new Player();
        player.setPlayerId(3);

        assertNotNull( player.getPlayerId());
        assertEquals(player.getPlayerId(),3);
    }

    @Test
    public void getFirstNameTest() {

        Player player = new Player();
        player.setFirstName("John");

        assertNotNull( player.getFirstName());
        assertEquals(player.getFirstName(),"John");
    }

    @Test
    public void getLastNameTest() {

        Player player = new Player();
        player.setLastName("Murphy");

        assertNotNull( player.getLastName());
        assertEquals(player.getLastName(),"Murphy");
    }

    @Test
    public void getPhoneNumberTest() {

        Player player = new Player();
        player.setPhoneNumber("087244901");

        assertNotNull( player.getPhoneNumber());
        assertEquals(player.getPhoneNumber(),"087244901");
    }

    @Test
    public void getEmailTest() {

        Player player = new Player();
        player.setEmail("seanogcarey@email.com");

        assertNotNull( player.getEmail());
        assertEquals(player.getEmail(),"seanogcarey@email.com");
    }

    @Test
    public void getTeamIdTest() {

        Player player = new Player();
        player.setTeamId(22);
        assertNotNull( player.getTeamId());
        assertEquals(player.getTeamId(),22);
    }
}

