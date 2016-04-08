package dcu.DAO;

import dcu.service.HibernateUtil;
import dcu.datamodel.Player;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */
public class PlayerDAOImpl implements PlayerDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_PLAYERS = "select e from Player e";

    public List<Player> getAllPlayers() throws IOException, NotFoundException{

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();
        List<Player> playerList  = (List<Player>) session.createQuery(GET_ALL_PLAYERS).list();

        session.getTransaction().commit();

        return playerList;

    }
    public List<Player> getPlayerById(final int playerId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from Player e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<Player> playerList  = query.list();


        session.getTransaction().commit();


        return playerList;
    }

    public List<Player> getPlayerByTeamId(final int teamId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from Player e where teamId = :teamId ");
        query.setParameter("teamId", teamId);
        List<Player> playerTeamList  = query.list();


        session.getTransaction().commit();


        return playerTeamList;
    }



    public void createPlayer(final String firstName,final String lastName, final int teamId){


        System.out.println("Attempting to create manager");

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Player OFF insert into dbo.Player (firstName,lastName,teamId) values(:firstName,:lastName,:teamId)" );
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("teamId",teamId);
        query.executeUpdate();

        session.getTransaction().commit();


    }


}
