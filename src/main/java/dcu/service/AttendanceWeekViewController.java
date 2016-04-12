package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.AttendanceTableDAOImpl;
import dcu.DAO.AttendanceWeekViewDAOImpl;
import dcu.DAO.ExtraSessionDAOImpl;
import dcu.datamodel.AttendanceTable;
import dcu.datamodel.AttendanceWeekView;
import dcu.datamodel.ExtraSession;
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


/*
    @GET
    @Path("/getAttendanceWeekViewByWeekIdPlayerId/weekId/{weekId}/playerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceWeekViewByWeekIdPlayerId(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{

        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByWeekIdPlayerId(weekId,playerId);

        if (attendanceWeekViewList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);

        Gson gson = new Gson();
        String attendanceWeekView = gson.toJson(jsonObj);

        int doesItExist = goThroughStrings(attendanceWeekView,"attendanceWeekViewId");

        if (doesItExist == 0){

            System.out.println("DOESNT EXIST!!!!!!");
            //String attendanceWeekViewNew =

            //get from created

            JSONObject jsonObj2 = new JSONObject();
            jsonObj.put("attendanceWeekView",attendanceWeekViewList);

            Gson gson2 = new Gson();
            String attendanceWeekViewNew = gson2.toJson(jsonObj2);

            attendanceWeekView = attendanceWeekViewNew;
        }


        return attendanceWeekView;

    }
*/
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

        int doesItExist = goThroughStrings(attendanceWeekView,"attendanceWeekViewId");

        if (doesItExist == 0) {



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

            System.out.println("NUMBER OF TRAININGS : " + numOfSessions);

            List<AttendanceWeekView> newList = attendanceWeekViewDAOImpl.createAttendanceWeekView(weekId, playerId, numOfSessions);

            //find new list
            JSONObject jsonObj3 = new JSONObject();
            jsonObj3.put("attendanceWeekView", newList);

            Gson gson3 = new Gson();
            String attendanceWeekViewNew = gson3.toJson(jsonObj3);

            attendanceWeekView = attendanceWeekViewNew;


        }

        return attendanceWeekView;
    }


    public int getNumOfSessions(String attendanceTable,String extraSession ){

        //Strings to check
        String collegeTraining = "College Training";
        String attendedTraining = "True";

        int attendanceTableCheckCollege = goThroughStrings(attendanceTable,collegeTraining);
        int extraSessionCheckCollege = goThroughStrings(extraSession,collegeTraining);

        int attendanceTableCheckTrue = goThroughStrings(attendanceTable,attendedTraining);

        int numOfSessions = attendanceTableCheckCollege  + extraSessionCheckCollege + attendanceTableCheckTrue;

        return numOfSessions;
    }

    public int goThroughStrings(String jsonResponce,String findString){

        int countOfWord= 0;


        int lastIndex = 0;
        //int count = 0;

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