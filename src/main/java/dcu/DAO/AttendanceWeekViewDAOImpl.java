package dcu.DAO;

import dcu.datamodel.AttendanceTable;
import dcu.datamodel.AttendanceWeekView;
import dcu.datamodel.ExtraSession;
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
public class AttendanceWeekViewDAOImpl {

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


        /*
        SQLQuery sqlQuery = session.createSQLQuery("SELECT AttendanceWeekView.NumOfSessions, Player.firstName from AttendanceWeekView join Player on Player.playerId = AttendanceWeekView.playerId where attendanceWeekViewId = :weekId");
        sqlQuery.setParameter("weekId",weekId);
        System.out.println(sqlQuery.list());
        List<AttendanceWeekView> attendanceWeekViewListSQL = sqlQuery.list();


        System.out.print("HERE IS THE SQL JOIN: " + attendanceWeekViewListSQL);

        //Query query2 = session.createQuery("SELECT AttendanceWeekView.NumOfSessions, Player.firstName from AttendanceWeekView join Player on Player.playerId = AttendanceWeekView.playerId where attendanceWeekViewId = 1 ");

        //Query queryJoin = session.

        Query queryJoin = session.createQuery("SELECT attendanceWeekView.attendanceWeekViewId, attendanceWeekView.weekId,attendanceWeekView.playerId,attendanceWeekView.numOfSessions FROM AttendanceWeekView attendanceWeekView WHERE  attendanceWeekView.weekId = :weekId");

        //Query queryJoin = session.createQuery("SELECT attendanceWeekView.attendanceWeekViewId, attendanceWeekView.weekId,attendanceWeekView.playerId,attendanceWeekView.numOfSessions, player.firstName FROM AttendanceWeekView attendanceWeekView, Player player WHERE attendanceWeekView.playerId = player.playerId AND attendanceWeekView.weekId = :weekId ORDER BY attendanceWeekView.playerId");
        queryJoin.setParameter("weekId", weekId);

        List<AttendanceWeekView> attendanceWeekViewListNew = queryJoin.list();
        System.out.println("LIST :" + attendanceWeekViewListNew);
        */


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

    public List<AttendanceWeekView> createAttendanceWeekView(final int weekId, final int playerId, final int numOfSessions){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.AttendanceWeekView OFF insert into dbo.AttendanceWeekView (weekId,playerId,numOfSessions) values(:weekId,:playerId,:numOfSessions)" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("numOfSessions",numOfSessions);
        query.executeUpdate();

        session.getTransaction().commit();

        List<AttendanceWeekView> attendanceWeekViewList = getAttendanceWeekViewByWeekIdPlayerId(weekId,playerId);

        return attendanceWeekViewList;

    }

    public void updateAttendanceWeekView(final int weekId, final int playerId, final int numOfSessions){


        System.out.println("Attempting to update Attendance Week View");
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();


        SQLQuery query= session.createSQLQuery("Update AttendanceWeekView set NumOfSessions=:numOfSessions where playerId = :playerId and weekId=:weekId" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("numOfSessions",numOfSessions);
        query.executeUpdate();

        session.getTransaction().commit();

    }
}
