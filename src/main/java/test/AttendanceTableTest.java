package test;

import dcu.datamodel.AttendanceTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 18/05/2016.
 */
public class AttendanceTableTest {


    @Test
    public void getAttendanceIdTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setAttendanceId(22);

        assertNotNull(attendanceTable.getAttendanceId());
        assertEquals(attendanceTable.getAttendanceId(),22);
    }


    @Test
    public void getPlayerIdTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setPlayerId(22);

        assertNotNull(attendanceTable.getPlayerId());
        assertEquals(attendanceTable.getPlayerId(),22);
    }


    @Test
    public void getWeekIdTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setWeekId(22);

        assertNotNull(attendanceTable.getWeekId());
        assertEquals(attendanceTable.getWeekId(),22);
    }


    @Test
    public void getSessionIdTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setSessionId(22);

        assertNotNull(attendanceTable.getSessionId());
        assertEquals(attendanceTable.getSessionId(),22);
    }

    @Test
    public void getPresentTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setPresent("True");

        assertNotNull(attendanceTable.getPresent());
        assertEquals(attendanceTable.getPresent(),"True");
    }

    @Test
    public void getReasonOfAbsenceTest() {

        AttendanceTable attendanceTable= new AttendanceTable();
        attendanceTable.setReasonOfAbsence("College Training");

        assertNotNull(attendanceTable.getReasonOfAbsence());
        assertEquals(attendanceTable.getReasonOfAbsence(),"College Training");
    }
}
