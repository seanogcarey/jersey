package dcu.DAO;

import dcu.datamodel.TrainingGroup;
import dcu.service.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 21/04/2016.
 */
public class TrainingGroupDAOImpl implements TrainingGroupDAO {

    private SessionFactory sf =null ;
    private static final String GET_ALL_TRAINING_GROUPS = "select e from TrainingGroup e";


    public List<TrainingGroup> getAllTrainingGroups() throws IOException, NotFoundException{

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();
        List<TrainingGroup> trainingGroupList = (List<TrainingGroup>) session.createQuery(GET_ALL_TRAINING_GROUPS).list();

        session.getTransaction().commit();

        return trainingGroupList;

    }

    public List<TrainingGroup> getTrainingGroupById(final int trainingGroupId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from TrainingGroup e where trainingGroupId = :trainingGroupId ");
        query.setParameter("trainingGroupId", trainingGroupId);
        List<TrainingGroup> trainingGroupList  = query.list();


        session.getTransaction().commit();


        return trainingGroupList;
    }


    public List<TrainingGroup> getTrainingGroupByFitnessId(final int fitnessId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from TrainingGroup e where fitnessId = :fitnessId ");
        query.setParameter("fitnessId", fitnessId);
        List<TrainingGroup> trainingGroupList  = query.list();


        session.getTransaction().commit();


        return trainingGroupList;
    }

    public List<TrainingGroup> getTrainingGroupByPlayerId(final int playerId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from TrainingGroup e where playerId = :playerId ");
        query.setParameter("playerId", playerId);
        List<TrainingGroup> trainingGroupList  = query.list();


        session.getTransaction().commit();


        return trainingGroupList;
    }

    public List<TrainingGroup> getTrainingGroupByPlayerIdFitnessId(final int playerId,final int fitnessId){

        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        sf = HibernateUtil.getSessionFactory();

        Query query = session.createQuery("select  e from TrainingGroup e where playerId = :playerId and fitnessId = :fitnessId");
        query.setParameter("playerId", playerId);
        query.setParameter("fitnessId", fitnessId);

        List<TrainingGroup> trainingGroupList  = query.list();


        session.getTransaction().commit();


        return trainingGroupList;
    }





    public void createTrainingGroup(final int playerId,final int fitnessId,final String fitnessGroup,final String strengthGroup,final String speedGroup){


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        sf = HibernateUtil.getSessionFactory();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.TrainingGroup OFF insert into dbo.TrainingGroup (playerId,fitnessId,fitnessGroup,strengthGroup,speedGroup) values(:playerId,:fitnessId,:fitnessGroup,:strengthGroup,:speedGroup)" );
        query.setParameter("playerId", playerId);
        query.setParameter("fitnessId", fitnessId);
        query.setParameter("fitnessGroup", fitnessGroup);
        query.setParameter("strengthGroup", strengthGroup);
        query.setParameter("speedGroup", speedGroup);



        query.executeUpdate();

        session.getTransaction().commit();

    }


    public void updateTrainingGroupByPlayerId(final int playerId,final String fitnessGroup,final String strengthGroup,final String speedGroup){


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");



        SQLQuery query= session.createSQLQuery("Update TrainingGroup set fitnessGroup= :fitnessGroup,strengthGroup =:strengthGroup,speedGroup =:speedGroup where playerId = :playerId");
        query.setParameter("playerId", playerId);
        query.setParameter("fitnessGroup", fitnessGroup);
        query.setParameter("strengthGroup", strengthGroup);
        query.setParameter("speedGroup", speedGroup);

        query.executeUpdate();


        session.getTransaction().commit();

        System.out.println("Training Group updated");

    }


    public void updateTrainingGroup(final int trainingGroupId,final String fitnessGroup,final String strengthGroup,final String speedGroup){


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");



        SQLQuery query= session.createSQLQuery("Update TrainingGroup set fitnessGroup= :fitnessGroup,strengthGroup =:strengthGroup,speedGroup =:speedGroup where trainingGroupId = :trainingGroupId");
        query.setParameter("trainingGroupId", trainingGroupId);
        query.setParameter("fitnessGroup", fitnessGroup);
        query.setParameter("strengthGroup", strengthGroup);
        query.setParameter("speedGroup", speedGroup);

        query.executeUpdate();


        session.getTransaction().commit();

        System.out.println("Training Group updated");

    }



}
