package dcu.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sean on 30/03/2016.
 */
public class Manager {

    @Id
    @Column(name = "managerId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int managerId;

    @Column(name ="firstName")
    private String firstName;
    @Column(name ="lastName")
    private String lastName;
    @Column(name ="phoneNumber")
    private String phoneNumber;
    @Column(name ="teamId")
    private Integer teamId;
    @Column(name ="email")
    private String email;


    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (managerId != manager.managerId) return false;
        //if (logInId != manager.logInId) return false;
        if (firstName != null ? !firstName.equals(manager.firstName) : manager.firstName != null) return false;
        if (lastName != null ? !lastName.equals(manager.lastName) : manager.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(manager.phoneNumber) : manager.phoneNumber != null) return false;
        if (teamId != null ? !teamId.equals(manager.teamId) : manager.teamId != null) return false;
        if (email != null ? !email.equals(manager.email) : manager.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        //result = 31 * result + logInId;
        return result;
    }
}
