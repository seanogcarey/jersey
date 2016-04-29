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
    public void getClubNameTest(){

        Club club = new Club();
        club.setClubName("ClubName");

        assertNotNull(club.getClubName());
        assertEquals(club.getClubName(),"ClubName");
    }


    @Test
    public void getEmailTest(){

        Club club = new Club();
        club.setEmail("sean.carey22@mail.dcu.ie");

        assertNotNull(club.getEmail());
        assertEquals(club.getEmail(),"sean.carey22@mail.dcu.ie");
    }

    @Test
    public void getSportTest(){

        Club club = new Club();
        club.setSport("Gaelic Football");

        assertNotNull(club.getSport());
        assertEquals(club.getSport(),"Gaelic Football");
    }

    @Test
    public void getAddressTest(){

        Club club = new Club();
        club.setAddress("2 Westpark, Moore Drive, Athlone, Co.Westmeath");

        assertNotNull(club.getAddress());
        assertEquals(club.getAddress(),"2 Westpark, Moore Drive, Athlone, Co.Westmeath");
    }

    @Test
    public void getClubContactNumberTest(){

        Club club = new Club();
        club.setClubContactNumber("0872449601");

        assertNotNull(club.getClubContactNumber());
        assertEquals(club.getClubContactNumber(),"0872449601");
    }


}
