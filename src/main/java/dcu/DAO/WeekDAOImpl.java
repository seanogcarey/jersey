package dcu.DAO;

import dcu.datamodel.Week;
import dcu.service.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public class WeekDAOImpl implements WeekDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_WEEKS = "select e from Week e";


    public List<Week> getAllWeeks() throws IOException, NotFoundException{

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();
        List<Week> weekList  = (List<Week>) session.createQuery(GET_ALL_WEEKS).list();

        session.getTransaction().commit();

        return weekList;
    }
    public List<Week> getWeekById(final int weekId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from Week e where weekId = :weekId ");
        query.setParameter("weekId", weekId);
        List<Week> weekList  = query.list();


        session.getTransaction().commit();


        return weekList;
    }
    public List<Week> getWeekByTeamId(final int teamId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from Week e where weekId = :teamId ");
        query.setParameter("teamId", teamId);
        List<Week> weekList  = query.list();


        session.getTransaction().commit();


        return weekList;
    }
    public void createWeek(final int teamId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Week OFF insert into dbo.Week (teamId) values(:teamId)" );
        query.setParameter("teamId", teamId);
        query.executeUpdate();

        session.getTransaction().commit();

    }
}
