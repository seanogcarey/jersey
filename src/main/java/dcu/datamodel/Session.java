package dcu.datamodel;

import java.sql.Date;

/**
 * Created by Sean on 06/04/2016.
 */
public class Session {
    private int sessionId;
    private String sessionType;
    private Date sessionDate;
    private int weekId;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
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

        Session session = (Session) o;

        if (sessionId != session.sessionId) return false;
        if (weekId != session.weekId) return false;
        if (sessionType != null ? !sessionType.equals(session.sessionType) : session.sessionType != null) return false;
        if (sessionDate != null ? !sessionDate.equals(session.sessionDate) : session.sessionDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + (sessionType != null ? sessionType.hashCode() : 0);
        result = 31 * result + (sessionDate != null ? sessionDate.hashCode() : 0);
        result = 31 * result + weekId;
        return result;
    }
}
