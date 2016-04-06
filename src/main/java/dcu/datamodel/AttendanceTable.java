package dcu.datamodel;

/**
 * Created by Sean on 06/04/2016.
 */
public class AttendanceTable {
    private int attendanceId;
    private int playerId;
    private String reasonOfAbsence;
    private String present;
    private int sessionId;
    private int weekId;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getReasonOfAbsence() {
        return reasonOfAbsence;
    }

    public void setReasonOfAbsence(String reasonOfAbsence) {
        this.reasonOfAbsence = reasonOfAbsence;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceTable that = (AttendanceTable) o;

        if (attendanceId != that.attendanceId) return false;
        if (playerId != that.playerId) return false;
        if (sessionId != that.sessionId) return false;
        if (weekId != that.weekId) return false;
        if (reasonOfAbsence != null ? !reasonOfAbsence.equals(that.reasonOfAbsence) : that.reasonOfAbsence != null)
            return false;
        if (present != null ? !present.equals(that.present) : that.present != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attendanceId;
        result = 31 * result + playerId;
        result = 31 * result + (reasonOfAbsence != null ? reasonOfAbsence.hashCode() : 0);
        result = 31 * result + (present != null ? present.hashCode() : 0);
        result = 31 * result + sessionId;
        result = 31 * result + weekId;
        return result;
    }
}
