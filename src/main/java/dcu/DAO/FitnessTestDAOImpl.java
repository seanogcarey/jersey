package dcu.DAO;

import dcu.SessionFactoryHelper;
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import dcu.datamodel.FitnessTest;
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
public class FitnessTestDAOImpl implements FitnessTestDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_FINTESSTESTS = "select e from FitnessTest e";

    public List<FitnessTest> getAllFitnessTests() throws IOException, NotFoundException{
        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();
        List<FitnessTest> fitnessTestList  = (List<FitnessTest>) session.createQuery(GET_ALL_FINTESSTESTS).list();

        session.getTransaction().commit();

        return fitnessTestList;
    }
    public List<FitnessTest> getFintessTestById(final int fitnessId){

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();

        Query query = session.createQuery("select e from FitnessTest e where fitnessId = :fitnessId ");
        query.setParameter("fitnessId", fitnessId);
        List<FitnessTest> fitnessTestList  = query.list();

        session.getTransaction().commit();

        return fitnessTestList ;
    }
    public List<FitnessTest> getFintessTestByPlayerId(final int playerId){

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = SessionFactoryHelper.getSessionFactory();

        Query query = session.createQuery("select e from FitnessTest e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<FitnessTest> fitnessTestPlayerList  = query.list();

        session.getTransaction().commit();

        return fitnessTestPlayerList ;
    }

    public void createFitnessTest(final int playerId, final int bodyFat){

        System.out.println("Attempting to create manager");

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = SessionFactoryHelper.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.FitnessTest OFF insert into dbo.FitnessTest (bodyFat,playerId) values(:bodyFat,:playerId)" );
        query.setParameter("bodyFat", bodyFat);
        query.setParameter("playerId",playerId);
        query.executeUpdate();

        session.getTransaction().commit();

    }
}
