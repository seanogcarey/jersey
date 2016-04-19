package dcu.DAO;

/**
 * Created by Sean on 08/03/2016.
 */
import dcu.datamodel.Claim;
import dcu.service.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 01/03/2016.
 */


public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";

    //private static final String SELECT_CLAIM = "select t.claimId as claim from [SSMS-demo].dbo.Claim t";

    private static final String GET_ALL_CLAIMS = "select e from Claim e";
    private static final String GET_CLAIM = "select e from Claim e where claimId=2";

    private SessionFactory sf =null ;

    public void printmsg() {
        System.out.println("msg");
    }

    @SuppressWarnings("unchecked")
    public List<Claim> getAllClaims() throws IOException, NotFoundException {
        System.out.println("Attempting to get all claims");


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory, getting claims");
        System.out.println();

        //List<Claim> claimsList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        List<Claim> claimsList  = (List<Claim>) session.createQuery(GET_ALL_CLAIMS).list();


        session.getTransaction().commit();


        return claimsList;


    }

    public Claim getClaimByRef(final String claimReference){

        SessionFactory sf = null;
        return (Claim) sf.getCurrentSession().getNamedQuery(GET_ALL_CLAIMS)
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }

    public List<Claim> getOneClaim(final int claimId){

        System.out.println("Attempting to get claim");


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

       SessionFactory sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory, getting claim");
        System.out.println();

        //List<Claim> claimList  = (List<Claim>) session.createQuery(GET_CLAIM).list();

        Query query = session.createQuery("select  e from Claim e where claimId = :id ");
        query.setParameter("id", claimId);
        List<Claim> claimList  = query.list();


        session.getTransaction().commit();

        System.out.println("Claim got from query");

        return claimList;


    }

    public void createClaim(final String claimReference){

        System.out.println("Attempting to create claim");


        //begin transaction
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        System.out.println("Got Session Factory");
        System.out.println();

        SQLQuery query= session.createSQLQuery("SET IDENTITY_INSERT dbo.Claim OFF insert into dbo.Claim (claimReference) values(:claimReference)" );
        query.setParameter("claimReference", claimReference);
        query.executeUpdate();


        //session.ccreateStatement().executeUpdate("SET IDENTITY_INSERT Hotel ON");
/*
        Claim newClaim = new Claim();
        //newClaim.setClaimId(5)
        newClaim.setClaimReference("Hello world from server");
        System.out.println("before save : ClaimID = "+newClaim.getClaimId() + " Claim reference: " + newClaim.getClaimReference() );
        //newClaim.setClaimReference("newClaim Worked!");
        //int id = session.save(newClaim);
        //session.save(newClaim);


        Query query = session.createQuery("update Claim set claimReference= :claimReference");
        query.setParameter("claimReference", "Update Worked! ");
        int result = query.executeUpdate();
        System.out.println("Employee Update Status="+result);

        Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +
               "select stock_code, stock_name from backup_stock");

        Query query2 = session.createQuery("insert into Claim(claimReference)" +
                "values(sql ref)");

        INSERT INTO Claim (claimReference)
        VALUES ('sql ref');


        int rowsCopied = query2.executeUpdate();
 */


        session.getTransaction().commit();

        System.out.println("Claim created");

    }


}