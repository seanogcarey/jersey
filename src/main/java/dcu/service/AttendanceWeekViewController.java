package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.AttendanceWeekViewDAOImpl;
import dcu.DAO.ExtraSessionDAOImpl;
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




    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createAttendanceWeekView/weekId/{weekId}/playerId/{playerId}/numOfSessions/{numOfSessions}")
    public String createAttendanceWeekView(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("numOfSessions") final int numOfSessions) throws IOException, NotFoundException,JSONException{

        attendanceWeekViewDAOImpl.createAttendanceWeekView(weekId,playerId,numOfSessions);
        return "createAttendanceWeekView";

    }


}
