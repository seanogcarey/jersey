package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 30/03/2016.
 */
public class FitnessTest {

    @Id
    @Column(name = "fitnessId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int fitnessId;

    @Column(name = "bodyfat")
    private Integer bodyFat;
    @Column(name = "chinUps")
    private Integer chinUps;
    @Column(name = "pushUps")
    private Integer pushUps;
    @Column(name = "playerId")
    private int playerId;

    public int getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(int fitnessId) {
        this.fitnessId = fitnessId;
    }

    public Integer getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Integer bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Integer getChinUps() {
        return chinUps;
    }

    public void setChinUps(Integer chinUps) {
        this.chinUps = chinUps;
    }

    public Integer getPushUps() {
        return pushUps;
    }

    public void setPushUps(Integer pushUps) {
        this.pushUps = pushUps;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FitnessTest that = (FitnessTest) o;

        if (fitnessId != that.fitnessId) return false;
        if (playerId != that.playerId) return false;
        if (bodyFat != null ? !bodyFat.equals(that.bodyFat) : that.bodyFat != null) return false;
        if (chinUps != null ? !chinUps.equals(that.chinUps) : that.chinUps != null) return false;
        if (pushUps != null ? !pushUps.equals(that.pushUps) : that.pushUps != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fitnessId;
        result = 31 * result + (bodyFat != null ? bodyFat.hashCode() : 0);
        result = 31 * result + (chinUps != null ? chinUps.hashCode() : 0);
        result = 31 * result + (pushUps != null ? pushUps.hashCode() : 0);
        result = 31 * result + playerId;
        return result;
    }
}
