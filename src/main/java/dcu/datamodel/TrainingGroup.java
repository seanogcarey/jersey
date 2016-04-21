package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 20/04/2016.
 */
public class TrainingGroup {


    @Id
    @Column(name = "trainingGroupId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int trainingGroupId;

    @Column(name = "playerid")
    private Integer playerId;

    @Column(name = "fitnessId")
    private int fitnessId;

    @Column(name = "fitnessGroup")
    private String fitnessGroup;

    @Column(name = "strengthGroup")
    private String strengthGroup;

    @Column(name = "speedGroup")
    private String speedGroup;

    public int getTrainingGroupId() {
        return trainingGroupId;
    }

    public void setTrainingGroupId(int trainingGroupId) {
        this.trainingGroupId = trainingGroupId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public int getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(int fitnessId) {
        this.fitnessId = fitnessId;
    }

    public String getFitnessGroup() {
        return fitnessGroup;
    }

    public void setFitnessGroup(String fitnessGroup) {
        this.fitnessGroup = fitnessGroup;
    }

    public String getStrengthGroup() {
        return strengthGroup;
    }

    public void setStrengthGroup(String strengthGroup) {
        this.strengthGroup = strengthGroup;
    }

    public String getSpeedGroup() {
        return speedGroup;
    }

    public void setSpeedGroup(String speedGroup) {
        this.speedGroup = speedGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingGroup that = (TrainingGroup) o;

        if (trainingGroupId != that.trainingGroupId) return false;
        if (fitnessId != that.fitnessId) return false;
        if (playerId != null ? !playerId.equals(that.playerId) : that.playerId != null) return false;
        if (fitnessGroup != null ? !fitnessGroup.equals(that.fitnessGroup) : that.fitnessGroup != null) return false;
        if (strengthGroup != null ? !strengthGroup.equals(that.strengthGroup) : that.strengthGroup != null)
            return false;
        if (speedGroup != null ? !speedGroup.equals(that.speedGroup) : that.speedGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainingGroupId;
        result = 31 * result + (playerId != null ? playerId.hashCode() : 0);
        result = 31 * result + fitnessId;
        result = 31 * result + (fitnessGroup != null ? fitnessGroup.hashCode() : 0);
        result = 31 * result + (strengthGroup != null ? strengthGroup.hashCode() : 0);
        result = 31 * result + (speedGroup != null ? speedGroup.hashCode() : 0);
        return result;
    }
}
