package dcu.DAO;

import dcu.service.HibernateUtil;
import dcu.datamodel.Manager;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */
public class ManagerDAOImpl implements ManagerDAO{

    //private SessionFactory sf =null ;
    private static final String GET_ALL_MANAGERS = "select e from Manager e";

    public List<Manager> getAllManagers() throws IOException, NotFoundException{


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        List<Manager> managerList  = (List<Manager>) session.createQuery(GET_ALL_MANAGERS).list();

        session.getTransaction().commit();

        return managerList;
    }
    public List<Manager> getManagerById(final int managerId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        //sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from Manager e where managerId = :managerId ");
        query.setParameter("managerId", managerId);
        List<Manager> managerList  = query.list();


        session.getTransaction().commit();


        return managerList;
    }

    public List<Manager> getManagerByTeamId(final int teamId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        Query query = session.createQuery("select  e from Manager e where teamId = :teamId ");
        query.setParameter("teamId", teamId);
        List<Manager> managerTeamList  = query.list();


        session.getTransaction().commit();


        return managerTeamList;
    }

    public void createManager(final String firstName,final String lastName,final String phoneNumber,final String email,final int teamId){

        System.out.println("Attempting to create manager");

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Manager OFF insert into dbo.Manager (firstName,lastName,phoneNumber,email,teamId) values (:firstName,:lastName,:phoneNumber,:email,:teamId)" );

        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("phoneNumber",phoneNumber);
        query.setParameter("email",email);
        query.setParameter("teamId",teamId);
        query.executeUpdate();

        session.getTransaction().commit();


    }

}
