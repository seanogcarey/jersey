package dcu.DAO;

import dcu.datamodel.AttendanceTable;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public interface AttendanceTableDAO {

    public List<AttendanceTable> getAllAttendanceTables() throws IOException, NotFoundException;

    public List<AttendanceTable> getAllAttendanceTableById(final int attendanceId);

    public List<AttendanceTable> getAllAttendanceTableByPlayerId(final int playerId);

    public List<AttendanceTable> getAllAttendanceTableByWeekId(final int weekId);

    public List<AttendanceTable> getAllAttendanceTableBySessionId(final int sessionId);

    public List<AttendanceTable> getAllAttendanceTableByWeekIdSessionId(final int weekId,final int sessionId);

    public List<AttendanceTable> getAllAttendanceTableBySessionIdPlayerId(final int weekId, final int playerId);


    public void createAttendanceTable(final int weekId, final int playerId, final int sessionId,final String present, final String reasonOfAbsence);

}
