import com.google.gson.Gson;
import dcu.DAO.*;
import dcu.datamodel.Club;
import dcu.datamodel.Team;
import dcu.service.ClaimsController;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Sean on 08/03/2016.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
        System.out.println("Running Main - test our data");

        //ClaimDAOImpl creatingClaim = new ClaimDAOImpl();
        //creatingClaim.createClaim("hello from server");

        //ClubDAOImpl creatingClub = new ClubDAOImpl();
        //creatingClub.createClub("Longford GAA");

        //ManagerDAOImpl creatingManager = new ManagerDAOImpl();
        //creatingManager.createManager("Jane","Kelly",9);

        //PlayerDAOImpl creatingPlayer = new PlayerDAOImpl();
        //creatingPlayer.createPlayer("Mary","O'Brien",9);

        //TeamDAOImpl creatingTeam = new TeamDAOImpl();
        //creatingTeam.createTeam("Longford U21",6);

        //FitnessTestDAOImpl creatingFitnessTest = new FitnessTestDAOImpl();
        //creatingFitnessTest.createFitnessTest(1,3);

        TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
        List<Team> teamList = teamDAOImpl.getAllTeams();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("claim",teamList);
        Gson gson = new Gson();
        String teams = gson.toJson(jsonObj);

        System.out.println("The teams in JSON:" + teams );





        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);
        String oneClaim = claimsController.getClaim(1);
        System.out.println("One claim: " + oneClaim);

    }
}
