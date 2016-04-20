package dcu.DAO;

import dcu.datamodel.AttendanceWeekView;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public interface AttendanceWeekViewDAO {

    public List<AttendanceWeekView> getAllAttendanceWeekViews() throws IOException, NotFoundException;
    public List<AttendanceWeekView> getAttendanceWeekViewById(final int attendanceWeekViewId);
    public List<AttendanceWeekView> getAttendanceWeekViewByWeekId(final int weekId);
    public List<AttendanceWeekView> getAttendanceWeekViewByPlayerId(final int playerId);
    public List<AttendanceWeekView> getAttendanceWeekViewByWeekIdPlayerId(final int weekId,final int playerId);

    public void createAttendanceWeekView(final int weekId, final int playerId,final int numOfSessions,final int numOfSessionsWithTeam);
    public void updateAttendanceWeekView(final int weekId, final int playerId, final int numOfSessions,final int numOfSessionsWithTeam );
}
