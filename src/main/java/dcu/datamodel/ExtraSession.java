package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 06/04/2016.
 */
public class ExtraSession {

    @Id
    @Column(name = "extraSessionId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int extraSessionId;

    @Column(name = "playerId")
    private int playerId;

    @Column(name = "weekId")
    private int weekId;

    @Column(name = "sessionType1")
    private String sessionType1;

    @Column(name = "sessionType2")
    private String sessionType2;

    @Column(name = "sessionType3")
    private String sessionType3;

    @Column(name = "sessionType4")
    private String sessionType4;

    @Column(name = "sessionType5")
    private String sessionType5;

    @Column(name = "sessionType6")
    private String sessionType6;

    @Column(name = "sessionType7")
    private String sessionType7;

    public int getExtraSessionId() {
        return extraSessionId;
    }

    public void setExtraSessionId(int extraSessionId) {
        this.extraSessionId = extraSessionId;
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

    public String getSessionType1() {
        return sessionType1;
    }

    public void setSessionType1(String sessionType1) {
        this.sessionType1 = sessionType1;
    }

    public String getSessionType2() {
        return sessionType2;
    }

    public void setSessionType2(String sessionType2) {
        this.sessionType2 = sessionType2;
    }

    public String getSessionType3() {
        return sessionType3;
    }

    public void setSessionType3(String sessionType3) {
        this.sessionType3 = sessionType3;
    }

    public String getSessionType4() {
        return sessionType4;
    }

    public void setSessionType4(String sessionType4) {
        this.sessionType4 = sessionType4;
    }

    public String getSessionType5() {
        return sessionType5;
    }

    public void setSessionType5(String sessionType5) {
        this.sessionType5 = sessionType5;
    }

    public String getSessionType6() {
        return sessionType6;
    }

    public void setSessionType6(String sessionType6) {
        this.sessionType6 = sessionType6;
    }

    public String getSessionType7() {
        return sessionType7;
    }

    public void setSessionType7(String sessionType7) {
        this.sessionType7 = sessionType7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraSession that = (ExtraSession) o;

        if (extraSessionId != that.extraSessionId) return false;
        if (playerId != that.playerId) return false;
        if (weekId != that.weekId) return false;
        if (sessionType1 != null ? !sessionType1.equals(that.sessionType1) : that.sessionType1 != null) return false;
        if (sessionType2 != null ? !sessionType2.equals(that.sessionType2) : that.sessionType2 != null) return false;
        if (sessionType3 != null ? !sessionType3.equals(that.sessionType3) : that.sessionType3 != null) return false;
        if (sessionType4 != null ? !sessionType4.equals(that.sessionType4) : that.sessionType4 != null) return false;
        if (sessionType5 != null ? !sessionType5.equals(that.sessionType5) : that.sessionType5 != null) return false;
        if (sessionType6 != null ? !sessionType6.equals(that.sessionType6) : that.sessionType6 != null) return false;
        if (sessionType7 != null ? !sessionType7.equals(that.sessionType7) : that.sessionType7 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extraSessionId;
        result = 31 * result + playerId;
        result = 31 * result + weekId;
        result = 31 * result + (sessionType1 != null ? sessionType1.hashCode() : 0);
        result = 31 * result + (sessionType2 != null ? sessionType2.hashCode() : 0);
        result = 31 * result + (sessionType3 != null ? sessionType3.hashCode() : 0);
        result = 31 * result + (sessionType4 != null ? sessionType4.hashCode() : 0);
        result = 31 * result + (sessionType5 != null ? sessionType5.hashCode() : 0);
        result = 31 * result + (sessionType6 != null ? sessionType6.hashCode() : 0);
        result = 31 * result + (sessionType7 != null ? sessionType7.hashCode() : 0);
        return result;
    }
}
