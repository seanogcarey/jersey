package dcu.DAO;

import dcu.SessionFactoryHelper;
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import javassist.NotFoundException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 29/03/2016.
 */
public class ClubDAOImpl implements ClubDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_CLUBS = "select e from Club e";

    public List<Club> getAllClubs() throws IOException, NotFoundException{

        System.out.println("Attempting to get all clubs");


        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory, getting clubs");
        System.out.println();

        //List<Claim> claimsList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        List<Club> clubsList  = (List<Club>) session.createQuery(GET_ALL_CLUBS).list();

        session.getTransaction().commit();

        System.out.println("Clubs got from query");

        return clubsList;
    }
    public Claim getClubById(final int clubId){

        return null;
    }

    public void createClub(final String clubName){
        System.out.println("Attempting to create club");
        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory");
        System.out.println();


        //SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Club OFF");
        //query.executeUpdate();
        /*
        Club newClub = new Club();
        //newClub.setClubId(4);
        newClub.setClubName(clubName);
        newClub.setAddress("Main Street");
        newClub.setClubContactNumber(08); //// TODO: 29/03/2016  int number too large fix
        newClub.setEmail("athone@GAA.ie");
        newClub.setSport("Gaelic Football");

        session.save(newClub);
        newClub.getClubId();
        */


        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Club OFF insert into dbo.Club (clubName) values(:clubName)" );
        query.setParameter("clubName", clubName);
        query.executeUpdate();

        session.getTransaction().commit();

        System.out.println("Club created");

    }

}
