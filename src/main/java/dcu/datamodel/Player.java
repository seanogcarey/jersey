package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 30/03/2016.
 */
public class Player {

    @Id
    @Column(name = "playerId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int playerId;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private Long phoneNumber;
    //todo set to a string!
    @Column(name = "email")
    private String email;
    @Column(name = "teamId")
    private int teamId;
    //@Column(name = "logInId")
    //private int logInId;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /*

    public int getLogInId() {
        return logInId;
    }

    public void setLogInId(int logInId) {
        this.logInId = logInId;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerId != player.playerId) return false;
        if (teamId != player.teamId) return false;
        // (logInId != player.logInId) return false;
        if (firstName != null ? !firstName.equals(player.firstName) : player.firstName != null) return false;
        if (lastName != null ? !lastName.equals(player.lastName) : player.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(player.phoneNumber) : player.phoneNumber != null) return false;
        if (email != null ? !email.equals(player.email) : player.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + teamId;
        //result = 31 * result + logInId;
        return result;
    }
}
