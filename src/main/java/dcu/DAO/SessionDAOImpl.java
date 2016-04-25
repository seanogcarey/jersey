package dcu.DAO;

import dcu.datamodel.Session;
import dcu.datamodel.Team;
import dcu.service.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public class SessionDAOImpl implements SessionDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_SESSIONS = "select e from Session e";

    public List<Session> getAllSessions() throws IOException, NotFoundException{

        org.hibernate.Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();
        List<Session> sessionList  = (List<Session>) session.createQuery(GET_ALL_SESSIONS).list();

        session.getTransaction().commit();

        return sessionList;
    }
    public List<Session> getSessionById(final int sessionId){

        org.hibernate.Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from Session e where sessionId = :sessionId ");
        query.setParameter("sessionId", sessionId);
        List<Session> sessionList  = query.list();


        session.getTransaction().commit();


        return sessionList;
    }
    public List<Session> getSessionByWeekId(final int weekId){

        org.hibernate.Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from Session e where weekId = :weekId ");
        query.setParameter("weekId", weekId);
        List<Session> sessionList  = query.list();


        session.getTransaction().commit();


        return sessionList;
    }
    public void createSession(final int weekId,final String sessionType,final String sessionDateString){

        //begin transaction
        org.hibernate.Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Session OFF insert into dbo.Session (weekId,sessionType,sessionDateString) values(:weekId,:sessionType,:sessionDateString)" );
        query.setParameter("weekId", weekId);
        query.setParameter("sessionType", sessionType);
        query.setParameter("sessionDateString", sessionDateString);
        query.executeUpdate();

        session.getTransaction().commit();


    }
/*
    public void createSession(final int weekId, final Date sessionDate, final String sessionType){

        //begin transaction
        org.hibernate.Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Session OFF insert into dbo.Session (weekId,sessionDate,sessionType) values(:weekId,:sessionDate,:sessionType)" );
        query.setParameter("weekId", weekId);
        query.setParameter("sessionDate", sessionDate);
        query.setParameter("sessionType", sessionType);
        query.executeUpdate();

        session.getTransaction().commit();


    }
    */


}
