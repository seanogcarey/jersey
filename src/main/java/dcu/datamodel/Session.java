package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Sean on 06/04/2016.
 */
public class Session {

    @Id
    @Column(name = "sessionId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sessionId;

    @Column(name = "sessionType")
    private String sessionType;

    @Column(name = "sessionDate")
    private Date sessionDate;

    @Column(name = "weekId")
    private int weekId;

    @Column(name = "sessionDateString")
    private String sessionDateString;

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

    public String getSessionDateString() {
        return sessionDateString;
    }

    public void setSessionDateString(String sessionDateString) {
        this.sessionDateString = sessionDateString;
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
