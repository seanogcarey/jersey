package dcu.service;

/**
 * Created by Sean on 07/04/2016.
 */

import com.google.gson.Gson;
import dcu.DAO.SessionDAOImpl;
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

    @GET
    @Path("/getAllSessions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSessions()throws IOException, NotFoundException, JSONException {

        //nameing of "Session" giving this problem
        //// TODO: 07/04/2016 rename Session if have time
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
            throw new NotFoundException("week does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("session",sessionList);

        Gson gson = new Gson();
        String session = gson.toJson(jsonObj);

        return session;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createSession/weekId/{weekId}/sessionDate/{sessionDate}/sessionType/{sessionType}")
    public String createWeek(@PathParam("weekId") final int weekId,@PathParam("sessionDate") final Date sessionDate,@PathParam("sessionType") final String sessionType) throws IOException, NotFoundException,JSONException{

        sessionDAOImpl.createSession(weekId,sessionDate,sessionType);
        return "createSession";

    }

}
