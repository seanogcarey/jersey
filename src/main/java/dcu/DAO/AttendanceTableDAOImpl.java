package dcu.DAO;

import dcu.datamodel.AttendanceTable;
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
public class AttendanceTableDAOImpl implements AttendanceTableDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_ATTENDANCE_TABLES = "select e from AttendanceTable e";

    public List<AttendanceTable> getAllAttendanceTables() throws IOException, NotFoundException{

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<AttendanceTable> attendanceTableList = (List<AttendanceTable>) session.createQuery(GET_ALL_ATTENDANCE_TABLES).list();

        session.getTransaction().commit();

        return attendanceTableList;
    }
    public List<AttendanceTable> getAllAttendanceTableById(final int attendanceId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where attendanceId = :attendanceId ");
        query.setParameter("attendanceId", attendanceId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }
    public List<AttendanceTable> getAllAttendanceTableByPlayerId(final int playerId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;

    }

    public List<AttendanceTable> getAllAttendanceTableByWeekId(final int weekId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where weekId = :weekId ");
        query.setParameter("weekId", weekId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }

    public List<AttendanceTable> getAllAttendanceTableBySessionId(final int sessionId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where sessionId = :sessionId ");
        query.setParameter("sessionId", sessionId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }

    public List<AttendanceTable> getAllAttendanceTableBySessionIdPlayerId(final int sessionId,final int playerId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where sessionId = :sessionId and playerId = :playerId ");
        query.setParameter("sessionId", sessionId);
        query.setParameter("playerId", playerId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }

    public List<AttendanceTable> getAllAttendanceTableByWeekIdSessionId(final int weekId,final int sessionId){

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where weekId = :weekId and sessionId = :sessionId ");
        query.setParameter("weekId", weekId);
        query.setParameter("sessionId", sessionId);
        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }

    public List<AttendanceTable> getAllAttendanceTableByWeekIdPlayerId(final int weekId,final int playerId){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from AttendanceTable e where weekId = :weekId and playerId = :playerId ");
        query.setParameter("playerId", playerId);
        query.setParameter("weekId", weekId);

        List<AttendanceTable> attendanceTableList  = query.list();

        session.getTransaction().commit();

        return attendanceTableList;
    }

    public void createAttendanceTable(final int weekId,final int playerId, final int sessionId,final String present, final String reasonOfAbsence){


        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.AttendanceTable OFF insert into dbo.AttendanceTable (weekId,playerId,sessionId,present,reasonOfAbsence) values(:weekId,:playerId,:sessionId,:present,:reasonOfAbsence)" );
        query.setParameter("weekId", weekId);
        query.setParameter("playerId",playerId);
        query.setParameter("sessionId",sessionId);
        query.setParameter("present",present);
        query.setParameter("reasonOfAbsence",reasonOfAbsence);


        query.executeUpdate();

        session.getTransaction().commit();

    }

    public void updateAttendanceTable(final int playerId,final int sessionId,final String present,final String reasonOfAbsence){
        System.out.println("Attempting to update Attendance Table");
        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");



        SQLQuery query= session.createSQLQuery("Update AttendanceTable set present= :present , reasonOfAbsence = :reasonOfAbsence where playerId= :playerId and sessionId = :sessionId");
        query.setParameter("playerId", playerId);
        query.setParameter("sessionId", sessionId);
        query.setParameter("present", present);
        query.setParameter("reasonOfAbsence", reasonOfAbsence);
        query.executeUpdate();


        session.getTransaction().commit();

        System.out.println("Attendance Table updated");

    }

}
