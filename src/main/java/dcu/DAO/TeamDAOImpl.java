package dcu.DAO;

import dcu.SessionFactoryHelper;
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import dcu.datamodel.Team;
import javassist.NotFoundException;
import org.hibernate.Query;
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
    private static final String GET_ALL_TEAMS = "select e from Team e";

    public List<Team> getAllTeams() throws IOException, NotFoundException{

        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();
        List<Team> teamList  = (List<Team>) session.createQuery(GET_ALL_TEAMS).list();

        session.getTransaction().commit();

        return teamList;
    }
    public List<Team> getTeamById(final int teamId){

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();

        Query query = session.createQuery("select  e from Team e where teamId = :teamId ");
        query.setParameter("teamId", teamId);
        List<Team> teamList  = query.list();


        session.getTransaction().commit();


        return teamList;
    }

    public List<Team> getTeamByClubId(final int clubId){

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();

        Query query = session.createQuery("select  e from Team e where clubId = :clubId ");
        query.setParameter("clubId", clubId);
        List<Team> teamClubList  = query.list();


        session.getTransaction().commit();


        return teamClubList;
    }

    public void createTeam(final String teamName,final int clubId){

        System.out.println("Attempting to create team");

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = SessionFactoryHelper.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Team OFF insert into dbo.team (teamName,clubId) values(:teamName,:clubId)" );
        query.setParameter("teamName", teamName);
        query.setParameter("clubId", clubId);
        query.executeUpdate();

        session.getTransaction().commit();

    }

}
