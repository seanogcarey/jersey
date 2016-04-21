package dcu.DAO;

import dcu.service.HibernateUtil;
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
    private static final String GET_ALL_FINTESS_TESTS = "select e from FitnessTest e";

    public List<FitnessTest> getAllFitnessTests() throws IOException, NotFoundException{
        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();
        List<FitnessTest> fitnessTestList  = (List<FitnessTest>) session.createQuery(GET_ALL_FINTESS_TESTS).list();

        session.getTransaction().commit();

        return fitnessTestList;
    }
    public List<FitnessTest> getFintessTestById(final int fitnessId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from FitnessTest e where fitnessId = :fitnessId ");
        query.setParameter("fitnessId", fitnessId);
        List<FitnessTest> fitnessTestList  = query.list();

        session.getTransaction().commit();

        return fitnessTestList ;
    }
    public List<FitnessTest> getFintessTestByPlayerId(final int playerId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select e from FitnessTest e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<FitnessTest> fitnessTestPlayerList  = query.list();

        session.getTransaction().commit();

        return fitnessTestPlayerList ;
    }

    public void createFitnessTest(final int chinUps,int pushUps,final int playerId,final int sprint,final int kmRun,final int agility,final int workLifestyle,final int weeklyAverageTrainingCount){

        System.out.println("Attempting to create manager");

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();
        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.FitnessTest OFF insert into dbo.FitnessTest (chinUps,pushUps,playerId,sprint,kmRun,agility,workLifestyle,weeklyAverageTrainingCount) values(:chinUps,:pushUps,:playerId,:sprint,:kmRun,:agility,:workLifestyle,:weeklyAverageTrainingCount)");

        query.setParameter("chinUps", chinUps);
        query.setParameter("pushUps", pushUps);
        query.setParameter("playerId",playerId);
        query.setParameter("sprint",sprint);
        query.setParameter("kmRun",kmRun);
        query.setParameter("agility",kmRun);
        query.setParameter("workLifestyle",workLifestyle);
        query.setParameter("weeklyAverageTrainingCount",weeklyAverageTrainingCount);



        query.executeUpdate();

        session.getTransaction().commit();

    }

    public void updateFitnessTest(final int chinUps,int pushUps,final int playerId,final int sprint,final int kmRun,final int agility,final int workLifestyle,final int weeklyAverageTrainingCount){


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();
        SQLQuery query= session.createSQLQuery("Update FitnessTest set chinUps=:chinUps,pushUps=:pushUps,sprint=:sprint,kmRun=:kmRun,agility=:agility,workLifestyle=:workLifestyle,weeklyAverageTrainingCount=:weeklyAverageTrainingCount where playerId = :playerId" );
        query.setParameter("chinUps", chinUps);
        query.setParameter("pushUps", pushUps);
        query.setParameter("playerId",playerId);
        query.setParameter("sprint",sprint);
        query.setParameter("agility",kmRun);
        query.setParameter("kmRun",kmRun);
        query.setParameter("workLifestyle",workLifestyle);
        query.setParameter("weeklyAverageTrainingCount",weeklyAverageTrainingCount);


        query.executeUpdate();

        session.getTransaction().commit();

    }



}
