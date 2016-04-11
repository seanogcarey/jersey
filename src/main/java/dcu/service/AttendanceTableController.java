package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.AttendanceTableDAOImpl;
import dcu.datamodel.AttendanceTable;
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

@Path("attendanceTable")
public class AttendanceTableController {

    AttendanceTableDAOImpl attendanceTableDAOImpl = new AttendanceTableDAOImpl();

    @GET
    @Path("/getAllAttendanceTables")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAttendanceTables()throws IOException, NotFoundException, JSONException {

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTables();

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance tables do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTables = gson.toJson(jsonObj);

        return attendanceTables;

    }

    @GET
    @Path("/getAttendanceTableById/{attendanceTableId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceTableById(@PathParam("attendanceTableId") final int attendanceTableId) throws IOException, NotFoundException,JSONException{
        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableById(attendanceTableId);

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance table do not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        return attendanceTable;

    }

    @GET
    @Path("/getAttendanceTableByWeekIdPlayerId/sessionId/{sessionId}/playerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceTableBySessionIdPlayerId(@PathParam("sessionId") final int sessionId,@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableBySessionIdPlayerId(sessionId,playerId);

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance table do not exis");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        return attendanceTable;

    }

    @GET
    @Path("/getAttendanceTableByPlayerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceTableByPlayerId(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableByPlayerId(playerId);

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        return attendanceTable;

    }
    @GET
    @Path("/getAttendanceTableBySessionId/{sessionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceTableBySessionId(@PathParam("sessionId") final int sessionId) throws IOException, NotFoundException,JSONException{

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableBySessionId(sessionId);

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        return attendanceTable;

    }

    @GET
    @Path("/getAttendanceTableByWeekId/{weekId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAttendanceTableByWeekId(@PathParam("weekId") final int weekId) throws IOException, NotFoundException,JSONException{

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableBySessionId(weekId);

        if (attendanceTableList == null) {
            throw new NotFoundException("attendance week view does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("attendanceTable",attendanceTableList);

        Gson gson = new Gson();
        String attendanceTable = gson.toJson(jsonObj);

        return attendanceTable;

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createAttendanceTable/weekId/{weekId}/playerId/{playerId}/sessionId/{sessionId}/present/{present}/reasonOfAbsence/{reasonOfAbsence}")
    public String createAttendanceTable(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("sessionId") final int sessionId,
            @PathParam("present") final String present,@PathParam("reasonOfAbsence")final String reasonOfAbsence ) throws IOException, NotFoundException,JSONException{

        attendanceTableDAOImpl.createAttendanceTable(weekId,playerId,sessionId,present,reasonOfAbsence);
        return "createAttendanceTable";

    }


}
