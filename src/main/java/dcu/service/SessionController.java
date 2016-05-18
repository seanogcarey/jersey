package dcu.service;

/**
 * Created by Sean on 07/04/2016.
 */

import com.google.gson.Gson;
import dcu.DAO.AttendanceTableDAOImpl;
import dcu.DAO.SessionDAOImpl;
import dcu.datamodel.AttendanceTable;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Path("session")
public class SessionController {

    SessionDAOImpl sessionDAOImpl = new SessionDAOImpl();
    AttendanceTableDAOImpl attendanceTableDAOImpl = new AttendanceTableDAOImpl();

    @GET
    @Path("/getAllSessions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSessions()throws IOException, NotFoundException, JSONException {

        // TODO: 07/04/2016 rename Session if have time - not a crucial problem

        List<dcu.datamodel.Session> sessionList = sessionDAOImpl.getAllSessions();

        if (sessionList == null) {
            throw new NotFoundException("sessions do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("session",sessionList);

        Gson gson = new Gson();
        String sessions = gson.toJson(jsonObj);

        return sessions;

    }

    @GET
    @Path("/getSessionById/{sessionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSessionById(@PathParam("sessionId") final int sessionId) throws IOException, NotFoundException,JSONException{
        List<dcu.datamodel.Session> sessionList = sessionDAOImpl.getSessionById(sessionId);

        if (sessionList == null) {
            throw new NotFoundException("session does not exist");
        }

        List<AttendanceTable> attendanceTableList = attendanceTableDAOImpl.getAllAttendanceTableBySessionId(sessionId);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("session",sessionList);
        jsonObj.put("attendanceTableList",attendanceTableList);

        Gson gson = new Gson();
        String session = gson.toJson(jsonObj);

        return session;

    }

    @GET

    @Path("/getSessionByWeekId/{weekId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSessionByWeekId(@PathParam("weekId") final int weekId) throws IOException, NotFoundException,JSONException{
        List<dcu.datamodel.Session> sessionList = sessionDAOImpl.getSessionByWeekId(weekId);

        if (sessionList == null) {
            throw new NotFoundException("sessions do not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("session",sessionList);

        Gson gson = new Gson();
        String sessions = gson.toJson(jsonObj);

        return sessions;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createSession/weekId/{weekId}/sessionType/{sessionType}/sessionDateString/{sessionDateString}")
    public String createWeek(@PathParam("weekId") final int weekId,@PathParam("sessionType") final String sessionType,@PathParam("sessionDateString") final String sessionDateString) throws IOException, NotFoundException,JSONException{

        sessionDAOImpl.createSession(weekId,sessionType,sessionDateString);
        return "createSession";

    }


}
