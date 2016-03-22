package dcu;

/**
 * Created by Sean on 08/03/2016.
 */
import com.google.gson.Gson;
import javassist.NotFoundException;
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
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory, getting claims");
        System.out.println();


        //List<Claim> claimsList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        List<Claim> claimsList  = (List<Claim>) session.createQuery(GET_ALL_CLAIMS).list();


        session.getTransaction().commit();

        System.out.println("Claims got from query");

        return claimsList;


    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery(GET_ALL_CLAIMS)
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }

    public List<Claim> getOneClaim(){

        System.out.println("Attempting to get claim");


        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory, getting claim");
        System.out.println();

        List<Claim> claimList  = (List<Claim>) session.createQuery(GET_CLAIM).list();

        session.getTransaction().commit();

        System.out.println("Claim got from query");

        return claimList;


    }



}