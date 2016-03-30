import com.google.gson.Gson;
import dcu.DAO.ClaimDAOImpl;
import dcu.DAO.ClubDAOImpl;
import dcu.DAO.TeamDAOImpl;
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import dcu.service.ClaimsController;
import org.json.JSONObject;

import java.util.List;

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

        ClubDAOImpl creatingClub = new ClubDAOImpl();
        creatingClub.createClub("Longford GAA");

        //TeamDAOImpl creatingTeam = new TeamDAOImpl();
        //creatingTeam.createTeam("Longford ladies",2);

        ClubDAOImpl clubDAOImpl = new ClubDAOImpl();
        List<Club> clubsList = clubDAOImpl.getAllClubs();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("claim",clubsList);
        Gson gson = new Gson();
        String clubs = gson.toJson(jsonObj);

        System.out.println("The clubs in JSON:" + clubs );





        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);
        String oneClaim = claimsController.getClaim(1);
        System.out.println("One claim: " + oneClaim);

    }
}
