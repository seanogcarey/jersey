package dcu.DAO;

import dcu.service.HibernateUtil;
import dcu.datamodel.Club;
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
public class ClubDAOImpl implements ClubDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_CLUBS = "select e from Club e";

    public List<Club> getAllClubs() throws IOException, NotFoundException{

        //System.out.println("Attempting to get all clubs");


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        //System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();

        //System.out.println("Got Session Factory, getting clubs");
        //System.out.println();

        //List<Claim> claimsList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        List<Club> clubsList  = (List<Club>) session.createQuery(GET_ALL_CLUBS).list();

        session.getTransaction().commit();

        //System.out.println("Clubs got from query");

        return clubsList;
    }
    public List<Club> getClubById(final int clubId){


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();



        sf = HibernateUtil.getSessionFactory();


        Query query = session.createQuery("select  e from Club e where clubId = :clubId ");
        query.setParameter("clubId", clubId);
        List<Club> clubList  = query.list();


        session.getTransaction().commit();

        return clubList;
    }

    public void createClub(final String clubName,final String email,final String address,final String sport,final String clubContactNumber){

        System.out.println("Attempting to create club");

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");




        /*
        //The way I wanted to do it:

        Club newClub = new Club();
        //newClub.setClubId(4);
        newClub.setClubName(clubName);
        newClub.setAddress("Main Street");
        newClub.setClubContactNumber(08);
        newClub.setEmail("athone@GAA.ie");
        newClub.setSport("Gaelic Football");

        session.save(newClub);
        newClub.getClubId();
        //--------------------------
        */


        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Club OFF insert into dbo.Club (clubName,email,address,sport,clubContactNumber) values(:clubName,:email,:address,:sport,:clubContactNumber)" );
        query.setParameter("clubName", clubName);
        query.setParameter("email", email);
        query.setParameter("address", address);
        query.setParameter("sport", sport);
        query.setParameter("clubContactNumber", clubContactNumber);

        query.executeUpdate();

        session.getTransaction().commit();

        System.out.println("Club created");

    }

    public void updateClub(final int clubId, final String clubName){
        System.out.println("Attempting to updateclub");

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");
        System.out.println("The CLub ID : " + clubId);



        SQLQuery query= session.createSQLQuery("Update Club set clubName= :clubName where clubId = :clubId");
        query.setParameter("clubId", clubId);
        query.setParameter("clubName", clubName);
        query.executeUpdate();


        session.getTransaction().commit();

        System.out.println("Club updated");

    }



}
