package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 06/04/2016.
 */
public class AttendanceWeekView {

    @Id
    @Column(name = "attendanceWeekViewId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int attendanceWeekViewId;

    @Column(name = "playerId")
    private int playerId;

    @Column(name = "weekId")
    private int weekId;

    @Column(name = "numOfSessions")
    private Integer numOfSessions;

    public int getAttendanceWeekViewId() {
        return attendanceWeekViewId;
    }

    public void setAttendanceWeekViewId(int attendanceWeekViewId) {
        this.attendanceWeekViewId = attendanceWeekViewId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public Integer getNumOfSessions() {
        return numOfSessions;
    }

    public void setNumOfSessions(Integer numOfSessions) {
        this.numOfSessions = numOfSessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceWeekView that = (AttendanceWeekView) o;

        if (attendanceWeekViewId != that.attendanceWeekViewId) return false;
        if (playerId != that.playerId) return false;
        if (weekId != that.weekId) return false;
        if (numOfSessions != null ? !numOfSessions.equals(that.numOfSessions) : that.numOfSessions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attendanceWeekViewId;
        result = 31 * result + playerId;
        result = 31 * result + weekId;
        result = 31 * result + (numOfSessions != null ? numOfSessions.hashCode() : 0);
        return result;
    }
}
