package dcu.DAO;

import dcu.datamodel.AttendanceWeekView;
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
public class AttendanceWeekViewDAOImpl implements  AttendanceWeekViewDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_ATTENDANCE_WEEK_VIEWS = "select e from AttendanceWeekView e";


    public List<AttendanceWeekView> getAllAttendanceWeekViews() throws IOException, NotFoundException{

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<AttendanceWeekView> attendanceWeekViewsList = (List<AttendanceWeekView>) session.createQuery(GET_ALL_ATTENDANCE_WEEK_VIEWS).list();

        session.getTransaction().commit();

        return attendanceWeekViewsList;
    }

    public List<AttendanceWeekView> getAttendanceWeekViewById(final int attendanceWeekViewId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceWeekView e where attendanceWeekViewId = :attendanceWeekViewId ");
        query.setParameter("attendanceWeekViewId", attendanceWeekViewId);
        List<AttendanceWeekView> attendanceWeekViewList  = query.list();

        session.getTransaction().commit();

        return attendanceWeekViewList;
    }
    public List<AttendanceWeekView> getAttendanceWeekViewByWeekId(final int weekId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();



        Query query = session.createQuery("select e, player from AttendanceWeekView e ,Player player where weekId = :weekId and e.playerId = player.playerId ");
        query.setParameter("weekId", weekId);
        List<AttendanceWeekView> attendanceWeekViewList  = query.list();

        session.getTransaction().commit();

        return attendanceWeekViewList;
    }
    public List<AttendanceWeekView> getAttendanceWeekViewByPlayerId(final int playerId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceWeekView e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<AttendanceWeekView> attendanceWeekViewList  = query.list();

        session.getTransaction().commit();

        return attendanceWeekViewList;
    }
    public List<AttendanceWeekView> getAttendanceWeekViewByWeekIdPlayerId(final int weekId,final int playerId){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceWeekView e where weekId = :weekId and playerId = :playerId ");
        query.setParameter("weekId", weekId);
        query.setParameter("playerId", playerId);

        List<AttendanceWeekView> attendanceWeekViewList  = query.list();

        session.getTransaction().commit();

        return attendanceWeekViewList;
    }

    public List<AttendanceWeekView> createAttendanceWeekView(final int weekId, final int playerId, final int numOfSessions, final int numOfSessionsWithTeam){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.AttendanceWeekView OFF insert into dbo.AttendanceWeekView (weekId,playerId,numOfSessions,numOfSessionsWithTeam) values(:weekId,:playerId,:numOfSessions,:numOfSessionsWithTeam)" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("numOfSessions",numOfSessions);
        query.setParameter("numOfSessionsWithTeam",numOfSessionsWithTeam);
        query.executeUpdate();

        session.getTransaction().commit();

        List<AttendanceWeekView> attendanceWeekViewList = getAttendanceWeekViewByWeekIdPlayerId(weekId,playerId);

        return attendanceWeekViewList;

    }

    public void updateAttendanceWeekView(final int weekId, final int playerId, final int numOfSessions,final int numOfSessionsWithTeam){


        System.out.println("Attempting to update Attendance Week View");
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();


        SQLQuery query= session.createSQLQuery("Update AttendanceWeekView set NumOfSessions=:numOfSessions,numOfSessionsWithTeam =:numOfSessionsWithTeam  where playerId = :playerId and weekId=:weekId" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("numOfSessions",numOfSessions);
        query.setParameter("numOfSessionsWithTeam",numOfSessionsWithTeam);
        query.executeUpdate();

        session.getTransaction().commit();

    }
}
