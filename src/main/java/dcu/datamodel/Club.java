package dcu.datamodel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sean on 29/03/2016.
 */
public class Club {

    @Id
    @Column(name = "clubId", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GenericGenerator(name="increment", strategy = "increment")
    private int clubId;

    @Column(name = "clubName")
    private String clubName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "sport")
    private String sport;

    @Column(name = "clubContactNumber")
    private String clubContactNumber;

    //private Set<Team> teams;
    
    public Club(){
    }
    public Club(int clubId,String clubName,String email,String address,String sport, String clubContactNumber){

        this.clubId = clubId;
        this.clubName = clubName;
        this.email = email;
        this.address = address;
        this.sport = sport;
        this.clubContactNumber = clubContactNumber;
    }
/*
    public Club(int clubId,String clubName,String email,String address,
                String sport, Long clubContactNumber,
                Set<Team> teams){

        this.clubId = clubId;
        this.clubName = clubName;
        this.email = email;
        this.address = address;
        this.sport = sport;
        this.clubContactNumber = clubContactNumber;
        //this.teams = teams;
    }
    */

   // public Set<Team> getTeams(){return teams;}

    //public void setTeams(Set<Team> teams){ this.teams = teams;}

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getClubContactNumber() {
        return clubContactNumber;
    }

    public void setClubContactNumber(String clubContactNumber) {
        this.clubContactNumber = clubContactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (clubId != club.clubId) return false;
        if (clubName != null ? !clubName.equals(club.clubName) : club.clubName != null) return false;
        if (email != null ? !email.equals(club.email) : club.email != null) return false;
        if (address != null ? !address.equals(club.address) : club.address != null) return false;
        if (sport != null ? !sport.equals(club.sport) : club.sport != null) return false;
        if (clubContactNumber != null ? !clubContactNumber.equals(club.clubContactNumber) : club.clubContactNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clubId;
        result = 31 * result + (clubName != null ? clubName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        result = 31 * result + (clubContactNumber != null ? clubContactNumber.hashCode() : 0);
        return result;
    }
}
