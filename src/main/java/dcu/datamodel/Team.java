package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 29/03/2016.
 */
public class Team {

    @Id
    @Column(name = "teamId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int teamId;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "clubId")
    private Integer clubId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != team.teamId) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;
        if (clubId != null ? !clubId.equals(team.clubId) : team.clubId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (clubId != null ? clubId.hashCode() : 0);
        return result;
    }
}
