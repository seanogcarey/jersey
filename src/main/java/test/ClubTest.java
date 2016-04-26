package test;

import dcu.datamodel.Club;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sean on 26/04/2016.
 */
public class ClubTest {

    @Test
    public void getClubIdTest() {

        Club club = new Club();
        club.setClubId(1);

        assertNotNull(club.getClubId());
        assertEquals(club.getClubId(),1);
    }

    @Test
    public void setClubIdTest(){

        Club club = new Club();
        club.setClubId(1);

        assertTrue(club.getClubId()==1);
    }

    @Test
    public void getClubNameTest(){

        Club club = new Club();
        club.setClubName("ClubName");

        assertNotNull(club.getClubName());
        assertEquals(club.getClubName(),"ClubName");
    }

    @Test
    public void setClubNameTest(){

        Club club = new Club();
        club.setClubName("ClubName");

        assertTrue(club.getClubName().equals("ClubName"));
    }

    @Test
    public void setClubEmailTest(){

        Club club = new Club();
        club.setEmail("email@email.com");

        assertNotNull(club.getEmail());
        assertEquals(club.getEmail(),"email@email.com");
    }

    /*
    @Test
    public void setClubContactNumberTest(){

        Club club = new Club();
        club.setClubContactNumber(0872449601L);

        assertEquals(club.getClubContactNumber(),0872449601L);


    }
    */
}
