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
        //creatingFitnessTest.createFitnessTest(1,3)
        String str = "Mick is fat Mick Boob";
        String findStr = "Mick";
        String findStr2 = "Boob";
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += findStr.length();
            }
        }
        int lastIndex2 = 0;
        while(lastIndex2 != -1){

            lastIndex2 = str.indexOf(findStr2,lastIndex2);

            if(lastIndex2 != -1){
                count ++;
                lastIndex2 += findStr2.length();
            }
        }
        System.out.println("words occurs " + count + " times");

        TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
        List<Team> teamList = teamDAOImpl.getAllTeams();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("claim",teamList);
        Gson gson = new Gson();
        String teams = gson.toJson(jsonObj);

        System.out.println("The teams in JSON:" + teams );



/*

        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);
        String oneClaim = claimsController.getClaim(1);
        System.out.println("One claim: " + oneClaim);
*/
    }
}
