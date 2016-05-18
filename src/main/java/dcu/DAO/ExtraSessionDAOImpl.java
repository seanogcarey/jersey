package dcu.DAO;

import dcu.datamodel.ExtraSession;
import dcu.datamodel.Manager;
import dcu.service.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public class ExtraSessionDAOImpl implements  ExtraSessionDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_EXTRA_SESSIONS = "select e from ExtraSession e";

    public List<ExtraSession> getAllExtraSessions() throws IOException, NotFoundException{


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<ExtraSession> extraSessionList = (List<ExtraSession>) session.createQuery(GET_ALL_EXTRA_SESSIONS).list();

        session.getTransaction().commit();

        return extraSessionList;
    }
    public List<ExtraSession> getExtraSessionById(final int extraSessionId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from ExtraSession e where extraSessionId = :extraSessionId ");
        query.setParameter("extraSessionId", extraSessionId);
        List<ExtraSession> extraSessionList  = query.list();

        session.getTransaction().commit();

        return extraSessionList ;
    }
    public List<ExtraSession> getExtraSessionByWeekId(final int weekId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from ExtraSession e where weekId = :weekId ");
        query.setParameter("weekId", weekId);
        List<ExtraSession> extraSessionList  = query.list();

        session.getTransaction().commit();

        return extraSessionList ;
    }
    public List<ExtraSession> getExtraSessionByPlayerId(final int playerId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from ExtraSession e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<ExtraSession> extraSessionList  = query.list();

        session.getTransaction().commit();

        return extraSessionList ;
    }
    public List<ExtraSession> getExtraSessionByWeekIdPlayerId(final int weekId,final int playerId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from ExtraSession e where weekId = :weekId and playerId = :playerId");
        query.setParameter("weekId", weekId);
        query.setParameter("playerId", playerId);
        List<ExtraSession> extraSessionList  = query.list();

        session.getTransaction().commit();

        return extraSessionList ;
    }


    public void createExtraSession(final int weekId, final int playerId, final String sessionType1,final String sessionType2,final String sessionType3,
                                    final String sessionType4,final String sessionType5,final String sessionType6,final String sessionType7){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.ExtraSession OFF insert into dbo.ExtraSession (weekId,playerId,sessionType1,sessionType2,sessionType3,sessionType4,sessionType5,sessionType6,sessionType7) values(:weekId,:playerId,:sessionType1,:sessionType2,:sessionType3,:sessionType4,:sessionType5,:sessionType6,:sessionType7)" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("sessionType1",sessionType1);
        query.setParameter("sessionType2",sessionType2);
        query.setParameter("sessionType3",sessionType3);
        query.setParameter("sessionType4",sessionType4);
        query.setParameter("sessionType5",sessionType5);
        query.setParameter("sessionType6",sessionType6);
        query.setParameter("sessionType7",sessionType7);
        query.executeUpdate();

        session.getTransaction().commit();


    }


    public void updateExtraSession(final int weekId, final int playerId, final String sessionType1, final String sessionType2, final String sessionType3, final String sessionType4, final String sessionType5, final String sessionType6, final String sessionType7){


        System.out.println("Attempting to update Extra Session");
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();


        SQLQuery query= session.createSQLQuery("Update ExtraSession set sessionType1=:sessionType1,sessionType2=:sessionType2,sessionType3=:sessionType3,sessionType4=:sessionType4,sessionType5=:sessionType5,sessionType6=:sessionType6,sessionType7=:sessionType7 where playerId = :playerId and weekId=:weekId" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("sessionType1",sessionType1);
        query.setParameter("sessionType2",sessionType2);
        query.setParameter("sessionType3",sessionType3);
        query.setParameter("sessionType4",sessionType4);
        query.setParameter("sessionType5",sessionType5);
        query.setParameter("sessionType6",sessionType6);
        query.setParameter("sessionType7",sessionType7);

        query.executeUpdate();

        session.getTransaction().commit();

    }



}
