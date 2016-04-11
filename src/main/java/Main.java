import com.google.gson.Gson;
import dcu.DAO.*;
import dcu.datamodel.AttendanceTable;
import dcu.datamodel.Club;
import dcu.datamodel.ExtraSession;
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


        int playerId = 3;
        int weekId = 1;

        AttendanceTableDAOImpl attendanceTableDAOImpl = new  AttendanceTableDAOImpl();
        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableByWeekIdPlayerId(weekId,playerId);

        ExtraSessionDAOImpl extraSessionDAOImpl = new ExtraSessionDAOImpl();
        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionByWeekIdPlayerId(weekId, playerId);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);
//-----------------------------------------------------------------------
        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("extraSession",extraSessionList);

        Gson gson2 = new Gson();
        String extraSession = gson2.toJson(jsonObj2);


        int numOfSessions = 0;

        String findStr = "College Training";

        System.out.println("STRINGS: " + attendanceTable);
        System.out.println("STRINGS: " + extraSession);

        int lastIndex = 0;
        //int count = 0;

        while(lastIndex != -1){

            lastIndex = attendanceTable.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                numOfSessions ++;
                lastIndex += findStr.length();
            }
        }

        int lastIndex2 = 0;
        //int count = 0;

        while(lastIndex2 != -1){

            lastIndex2 = extraSession.indexOf(extraSession,lastIndex2);

            if(lastIndex2 != -1){
                numOfSessions ++;
                lastIndex2 += findStr.length();
            }
        }

        System.out.println("NUMBER OF TRAININGS : " + numOfSessions);

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



/*

        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);
        String oneClaim = claimsController.getClaim(1);
        System.out.println("One claim: " + oneClaim);
*/
    }
}
