package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.AttendanceTableDAOImpl;
import dcu.DAO.AttendanceWeekViewDAOImpl;
import dcu.DAO.ExtraSessionDAOImpl;
import dcu.DAO.PlayerDAOImpl;
import dcu.datamodel.AttendanceTable;
import dcu.datamodel.AttendanceWeekView;
import dcu.datamodel.ExtraSession;
import dcu.datamodel.Player;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 08/04/2016.
 */

@Path("attendanceWeekView")
public class AttendanceWeekViewController {

    AttendanceWeekViewDAOImpl attendanceWeekViewDAOImpl = new AttendanceWeekViewDAOImpl();
    PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();


    //Strings to check
    final String collegeTraining = "College Training";
    final String schoolTraining = "School Training";
    final String collegeSchoolMatch ="College,School Match";
    final String countyTraining = "County Training";
    final String countyMatch = "County Match";
    final String otherClubTraining = "Other Club Training";
    final String otherClubMatch = "Other Club Match";
    final String otherTeamWithinCLub = "Other Team(within this club) Match,Training";
    final String fitnessWorkout ="Fitness Workout";
    final String other = "Other";

    final String attendedTraining = "True";


    @GET
    @Path("/getAllAttendanceWeekViews")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAttendanceWeekViews()throws IOException, NotFoundException, JSONException {

        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAllAttendanceWeekViews();

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week views do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);

        Gson gson = new Gson();
        String attendanceWeekViews = gson.toJson(jsonObj);

        return attendanceWeekViews;

    }

    @GET
    @Path("/getAttendanceWeekViewById/{attendanceWeekViewId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceWeekViewById(@PathParam("attendanceWeekViewId") final int attendanceWeekViewId) throws IOException, NotFoundException,JSONException{
        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewById(attendanceWeekViewId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("extra session does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);

        Gson gson = new Gson();
        String attendanceWeekView = gson.toJson(jsonObj);

        return attendanceWeekView;

    }


    @GET
    @Path("/getAttendanceWeekViewByPlayerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceWeekViewByPlayerId(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{

        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByPlayerId(playerId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);

        Gson gson = new Gson();
        String attendanceWeekView = gson.toJson(jsonObj);


        return attendanceWeekView;

    }

    @GET
    @Path("/getAttendanceWeekViewByWeekId/{weekId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceWeekViewByWeekId(@PathParam("weekId") final int weekId) throws IOException, NotFoundException,JSONException{

        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByWeekId(weekId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);

        Gson gson = new Gson();
        String attendanceWeekView = gson.toJson(jsonObj);


        return attendanceWeekView;

    }




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAttendanceWeekViewByWeekIdPlayerId/weekId/{weekId}/playerId/{playerId}")
    public String getAttendanceWeekViewByWeekIdPlayerId(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{


        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByWeekIdPlayerId(weekId,playerId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("attendanceWeekView",attendanceWeekViewList);

        Gson gsonObject = new Gson();
        String attendanceWeekView = gsonObject.toJson(jsonObject);

        int attendanceWeekViewCount = goThroughStrings(attendanceWeekView,"attendanceWeekViewId");

        if (attendanceWeekViewCount == 0) {



            //todo: BRUSH UP code "smell"

            AttendanceTableDAOImpl attendanceTableDAOImpl = new AttendanceTableDAOImpl();
            List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableByWeekIdPlayerId(weekId, playerId);

            ExtraSessionDAOImpl extraSessionDAOImpl = new ExtraSessionDAOImpl();
            List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionByWeekIdPlayerId(weekId, playerId);

            //Go through Attendance Table
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("attendanceTable", attendanceTableList);

            Gson gson = new Gson();
            String attendanceTable = gson.toJson(jsonObj);

            //Go through Extra Sessions
            JSONObject jsonObj2 = new JSONObject();
            jsonObj2.put("extraSession", extraSessionList);

            Gson gson2 = new Gson();
            String extraSession = gson2.toJson(jsonObj2);

            int numOfSessions = getNumOfSessions(attendanceTable, extraSession);

            int numOfSessionsWithTeam = getNumOfSessionsWithTeam(attendanceTable);
            System.out.println("NUMBER OF TRAININGS WITH TEAM " + numOfSessionsWithTeam );

            System.out.println("NUMBER OF TRAININGS : " + numOfSessions);

            List<AttendanceWeekView> newList = attendanceWeekViewDAOImpl.createAttendanceWeekView(weekId, playerId, numOfSessions,numOfSessionsWithTeam);


            //find new list
            JSONObject jsonObj3 = new JSONObject();
            jsonObj3.put("attendanceWeekView", newList);



            Gson gson3 = new Gson();
            String attendanceWeekViewNew = gson3.toJson(jsonObj3);

            attendanceWeekView = attendanceWeekViewNew;


        }

        return attendanceWeekView;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateAttendanceWeekView/weekId/{weekId}/playerId/{playerId}")
    public String updateAttendanceWeekView(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{


        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByWeekIdPlayerId(weekId,playerId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("attendanceWeekView",attendanceWeekViewList);

        Gson gsonObject = new Gson();
        String attendanceWeekView = gsonObject.toJson(jsonObject);



        AttendanceTableDAOImpl attendanceTableDAOImpl = new AttendanceTableDAOImpl();
        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableByWeekIdPlayerId(weekId, playerId);

        ExtraSessionDAOImpl extraSessionDAOImpl = new ExtraSessionDAOImpl();
        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionByWeekIdPlayerId(weekId, playerId);

        //Go through Attendance Table
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable", attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        //Go through Extra Sessions
        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("extraSession", extraSessionList);

        Gson gson2 = new Gson();
        String extraSession = gson2.toJson(jsonObj2);

        int numOfSessions = getNumOfSessions(attendanceTable, extraSession);

        int numOfSessionsWithTeam = getNumOfSessionsWithTeam(attendanceTable);
        System.out.println("NUMBER OF TRAININGS WITH TEAM " + numOfSessionsWithTeam );

        System.out.println("NUMBER OF TRAININGS IN UPDATE : " + numOfSessions);

        attendanceWeekViewDAOImpl.updateAttendanceWeekView(weekId,playerId,numOfSessions,numOfSessionsWithTeam);


        return "UpdatedAttendanceWeekView ";
    }

    public int getNumOfSessionsWithTeam(String attendanceTable){

        int attendanceTableCheckCollegeTraining = goThroughStrings(attendanceTable,"True");

        return attendanceTableCheckCollegeTraining;
    }

    public int getNumOfSessions(String attendanceTable,String extraSession ){


        //Check attendance table
        int attendanceTableCheckCollegeTraining = goThroughStrings(attendanceTable,collegeTraining);
        int attendanceTableCheckSchoolTraining = goThroughStrings(attendanceTable,schoolTraining);
        int attendanceTableCheckCollegeSchoolMatch = goThroughStrings(attendanceTable,collegeSchoolMatch);
        int attendanceTableCheckCountyTraining = goThroughStrings(attendanceTable,countyTraining);
        int attendanceTableCheckCollegeMatch = goThroughStrings(attendanceTable,countyMatch);
        int attendanceTableCheckOtherClubTraining = goThroughStrings(attendanceTable,otherClubTraining);
        int attendanceTableCheckOtherClubMatch= goThroughStrings(attendanceTable,otherClubMatch);
        int attendanceTableCheckOtherTeamWithinClub= goThroughStrings(attendanceTable,otherTeamWithinCLub);
        int attendanceTableCheckOther = goThroughStrings(attendanceTable,other);


        //check extra sessions table
        int extraSessionCheckCollegeTraining = goThroughStrings(extraSession,collegeTraining);
        int extraSessionCheckSchoolTraining = goThroughStrings(extraSession,schoolTraining);
        int extraSessionCheckCollegeSchoolMatch = goThroughStrings(extraSession,collegeSchoolMatch);
        int extraSessionCheckCountyTraining = goThroughStrings(extraSession,countyTraining);
        int extraSessionCheckCollegeMatch = goThroughStrings(extraSession,countyMatch);
        int extraSessionCheckOtherClubTraining = goThroughStrings(extraSession,otherClubTraining);
        int extraSessionCheckOtherClubMatch= goThroughStrings(extraSession,otherClubMatch);
        int extraSessionCheckOtherTeamWithinClub= goThroughStrings(extraSession,otherTeamWithinCLub);
        int extraSessionCheckFitnessWorkout= goThroughStrings(extraSession,fitnessWorkout);



        int attendanceTableCheckTrue = goThroughStrings(attendanceTable,attendedTraining);

        int attendanceTableCounts= attendanceTableCheckCollegeTraining  + attendanceTableCheckSchoolTraining
                                    + attendanceTableCheckCollegeSchoolMatch + attendanceTableCheckCountyTraining + attendanceTableCheckCollegeMatch
                                    + attendanceTableCheckOtherClubTraining + attendanceTableCheckOtherClubMatch + attendanceTableCheckOtherTeamWithinClub + attendanceTableCheckOther
                                    + attendanceTableCheckTrue;

        int extraSessionsCount = extraSessionCheckCollegeTraining  + extraSessionCheckSchoolTraining
                                 + extraSessionCheckCollegeSchoolMatch + extraSessionCheckCountyTraining + extraSessionCheckCollegeMatch
                                 + extraSessionCheckOtherClubTraining + extraSessionCheckOtherClubMatch + extraSessionCheckOtherTeamWithinClub + extraSessionCheckFitnessWorkout;

        int numOfSessions =  attendanceTableCounts +  extraSessionsCount;


        return numOfSessions;
    }




    public int goThroughStrings(String jsonResponce,String findString){

        int countOfWord= 0;

        int lastIndex = 0;


        while(lastIndex != -1){

            lastIndex = jsonResponce.indexOf(findString,lastIndex);

            if(lastIndex != -1){
                countOfWord ++;
                lastIndex += findString.length();
            }
        }

        return countOfWord;

    }


}
