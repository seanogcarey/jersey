import dcu.DAO.ClaimDAOImpl;
import dcu.service.ClaimsController;

/**
 * Created by Sean on 08/03/2016.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
        System.out.println("Hello World");

        ClaimDAOImpl creatingClaim = new ClaimDAOImpl();
        String claimRef;
        claimRef = "hello from server";
        //creatingClaim.createClaim(claimRef);


        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);
        String oneClaim = claimsController.getClaim(1);
        System.out.println("One claim: " + oneClaim);

    }
}
