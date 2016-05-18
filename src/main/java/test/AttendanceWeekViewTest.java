package test;

import dcu.datamodel.AttendanceWeekView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 18/05/2016.
 */
public class AttendanceWeekViewTest {





    @Test
    public void getAttendanceWeekViewIdTest() {

        AttendanceWeekView attendanceWeekView= new AttendanceWeekView();
        attendanceWeekView.setAttendanceWeekViewId(22);

        assertNotNull(attendanceWeekView.getAttendanceWeekViewId());
        assertEquals(attendanceWeekView.getAttendanceWeekViewId(),22);
    }

    @Test
    public void getPlayerIdTest() {

        AttendanceWeekView attendanceWeekView= new AttendanceWeekView();
        attendanceWeekView.setPlayerId(22);

        assertNotNull(attendanceWeekView.getPlayerId());
        assertEquals(attendanceWeekView.getPlayerId(),22);
    }


    @Test
    public void getWeekIdTest() {

        AttendanceWeekView attendanceWeekView= new AttendanceWeekView();
        attendanceWeekView.setWeekId(22);

        assertNotNull(attendanceWeekView.getWeekId());
        assertEquals(attendanceWeekView.getWeekId(),22);
    }

    @Test
    public void getNumOfSessionsTest() {

        Integer num = 5;
        AttendanceWeekView attendanceWeekView= new AttendanceWeekView();
        attendanceWeekView.setNumOfSessions(num);

        assertNotNull(attendanceWeekView.getNumOfSessions());
        assertEquals(attendanceWeekView.getNumOfSessions(),num);
    }

    @Test
    public void getNumOfSessionsWithTeamTest() {

        Integer num = 5;
        AttendanceWeekView attendanceWeekView= new AttendanceWeekView();
        attendanceWeekView.setNumOfSessionsWithTeam(num);

        assertNotNull(attendanceWeekView.getNumOfSessionsWithTeam());
        assertEquals(attendanceWeekView.getNumOfSessionsWithTeam(),num);
    }

}
