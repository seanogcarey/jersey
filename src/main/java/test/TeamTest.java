package test;

/**
 * Created by Sean on 17/05/2016.
 */
import dcu.datamodel.Team;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeamTest {


    @Test
    public void getTeamNameTest(){

        Team team = new Team();
        team.setTeamName("St. Michaels");

        assertNotNull(team.getTeamName());
        assertEquals(team.getTeamName(),"St. Michaels");
    }


    @Test
    public void getTeamIdTest(){

        Team team = new Team();
        team.setTeamId(112);

        assertNotNull(team.getTeamId());
        assertEquals(team.getTeamId(),112);
    }

    @Test
    public void getClubIdTest(){

        Team team = new Team();
        team.setClubId(133);

        Integer id = 133;
        assertNotNull(team.getClubId());
        assertEquals(team.getClubId(),id);
    }





}
