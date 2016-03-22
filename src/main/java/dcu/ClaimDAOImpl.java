package dcu;

/**
 * Created by Sean on 08/03/2016.
 */
import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import dcu.Claim;
import dcu.SessionFactoryHelper;
import javassist.NotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sean on 01/03/2016.
 */


public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";

    //private static final String SELECT_CLAIM = "select t.claimId as claim from [SSMS-demo].dbo.Claim t";

    private static final String SELECT_CLAIM2 = "select e from Claim e";
    private static final String SELECT_CLAIM3 = "select e from Claim e where claimId=2";

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


        List<Claim> claimsList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        List<Claim> products  = (List<Claim>) session.createQuery(SELECT_CLAIM2).list();

        Gson gson2 = new Gson();
        String json2 = gson2.toJson(products);

        System.out.println("Products in Json:" + json2);
        session.getTransaction().commit();

        System.out.println("Claims got from query");

        return products;


    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery(SELECT_CLAIM2)
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

        List<Claim> products  = (List<Claim>) session.createQuery(SELECT_CLAIM3).list();


        Gson gson2 = new Gson();
        String json2 = gson2.toJson(products);

        System.out.println("Products in Json:" + json2);
        session.getTransaction().commit();

        System.out.println("Claims got from query");

        return products;


    }



}