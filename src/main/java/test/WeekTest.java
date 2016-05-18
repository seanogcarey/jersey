package test;

import dcu.datamodel.Week;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 17/05/2016.
 */
public class WeekTest {

    @Test
    public void getWeekIdTest(){

        Week week = new Week();
        week.setWeekId(3);

        assertNotNull(week.getWeekId());
        assertEquals(week.getWeekId(),3);
    }

    @Test
    public void getTeamIdTest(){

        Week week = new Week();
        week.setTeamId(4);

        assertNotNull(week.getTeamId());
        assertEquals(week.getTeamId(),4);
    }

    @Test
    public void getWeekNumTest(){

        Integer num = 5;
        Week week = new Week();
        week.setWeekNum(num);

        assertNotNull(week.getWeekNum());
        assertEquals(week.getWeekNum(),num);
    }

    @Test
    public void getStartDateStringTest(){

        Week week = new Week();
        week.setStartDateString("17.05.2016");

        assertNotNull(week.getStartDateString());
        assertEquals(week.getStartDateString(),"17.05.2016");
    }

    @Test
    public void getEndDateStringTest(){

        Week week = new Week();
        week.setEndDateString("17.05.2016");

        assertNotNull(week.getEndDateString());
        assertEquals(week.getEndDateString(),"17.05.2016");
    }

}
