package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.AttendanceWeekViewDAOImpl;
import dcu.DAO.WeekDAOImpl;
import dcu.datamodel.AttendanceWeekView;
import dcu.datamodel.Team;
import dcu.datamodel.Week;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 07/04/2016.
 */

@Path("week")
public class WeekController {

    WeekDAOImpl weekDAOImpl = new WeekDAOImpl();
    AttendanceWeekViewDAOImpl attendanceWeekViewDAOImpl = new AttendanceWeekViewDAOImpl();

    @GET
    @Path("/getAllWeeks")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllWeeks()throws IOException, NotFoundException, JSONException {

        List<Week> weekList = weekDAOImpl.getAllWeeks();

        if (weekList == null) {
            throw new NotFoundException("weeks do not exist");
        }



        JSONObject jsonObj = new JSONObject();
        jsonObj.put("week",weekList);

        Gson gson = new Gson();
        String weeks = gson.toJson(jsonObj);

        return weeks;

    }

    @GET
    @Path("/getWeek/{weekId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeekById(@PathParam("weekId") final int weekId) throws IOException, NotFoundException,JSONException{
        List<Week> weekList = weekDAOImpl.getWeekById(weekId);

        if (weekList == null) {
            throw new NotFoundException("team does not exist");
        }

        List<AttendanceWeekView> attendanceWeekViewList = attendanceWeekViewDAOImpl.getAttendanceWeekViewByWeekId(weekId);


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("week",weekList);
        jsonObj.put("attendanceWeekView",attendanceWeekViewList);


        Gson gson = new Gson();
        String week = gson.toJson(jsonObj);

        return week;
    }

    @GET
    @Path("/getWeekByTeamId/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeekByTeamId(@PathParam("teamId") final int teamId) throws IOException, NotFoundException,JSONException{
        List<Week> weekList = weekDAOImpl.getWeekByTeamId(teamId);

        if (weekList == null) {
            throw new NotFoundException("week does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("week",weekList);

        Gson gson = new Gson();
        String week = gson.toJson(jsonObj);

        return week;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createWeek/teamId/{teamId}")
    public String createWeek(@PathParam("teamId") final int teamId) throws IOException, NotFoundException,JSONException{

        weekDAOImpl.createWeek(teamId);
        return "createWeek";

    }

    /*
    POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createWeek/teamId/{teamId}/startDate/{startDate}/endDate/{endDate}")
    public String createWeek(@PathParam("teamId") final int teamId, @PathParam("startDate") final Date startDate, @PathParam("endDate") final Date endDate) throws IOException, NotFoundException,JSONException{

        //todo how to pass in dates....explore
        weekDAOImpl.createWeek(teamId,startDate,endDate);
        weekDAOImpl.createWeek(teamId);
        return "createWeek";

    }
    */



}
