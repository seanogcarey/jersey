package dcu;

/**
 * Created by Sean on 08/03/2016.
 */
import dcu.Claim;
import dcu.SessionFactoryHelper;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 01/03/2016.
 */


public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";

    private static final String SELECT_CLAIM = "select t.claimId as claim from [SSMS-demo].dbo.Claim t";



    private SessionFactory sf =null ;

    /*
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }
    */

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
        //Transaction tx = getCurrent().beginTransaction();
        //Query query = session.getNamedQuery("getAllClaimsInfo");
        // System.out.println(sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list());
        //System.out.println("ERROR HERE");
        //commit transaction
        System.out.println();
        List<Claim> newList= sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        session.getTransaction().commit();

        /*
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(newList);

        System.out.println("JSON STRING: " + jsonInString);
        */



        System.out.println("Claims got from query");

        //sf.close();
        //return (List<Claim>) sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        //return null ;//"getAllClaimsInfo"
        return newList;


    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery(SELECT_CLAIM)
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }

    public List<Claim> getOneClaim(){

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction begun");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory, getting the one claim");
        System.out.println();
        List<Claim> claim ;
        /*

        claim = sf.getCurrentSession().getNamedQuery("getClaim");
        */
        claim= sf.getCurrentSession().getNamedQuery("getClaim").list();

        session.getTransaction().commit();


        System.out.println("Claims got from query");

        //sf.close();
        //return (List<Claim>) sf.getCurrentSession().getNamedQuery("getAllClaimsInfo").list();
        //return null ;//"getAllClaimsInfo"
        return claim;



    }

}