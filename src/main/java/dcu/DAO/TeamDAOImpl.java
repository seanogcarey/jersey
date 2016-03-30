package dcu.DAO;

import dcu.SessionFactoryHelper;
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import dcu.datamodel.Team;
import javassist.NotFoundException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 29/03/2016.
 */
public class TeamDAOImpl implements TeamDAO {

    private SessionFactory sf =null ;

    public List<Team> getAllTeams() throws IOException, NotFoundException{

        return null;
    }
    public Team getTeamById(final int teamId){
        return null;
    }
    public void createTeam(final String teamName,final int clubId){

        System.out.println("Attempting to create team");
        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory");
        System.out.println();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Team OFF insert into dbo.team (teamName,clubId) values(:teamName,:clubId)" );
        query.setParameter("teamName", teamName);
        query.setParameter("clubId", clubId);
        query.executeUpdate();


        //session.save(newClub);



        session.getTransaction().commit();

        System.out.println("Club created");

    }

}
