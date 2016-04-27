package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.ExtraSessionDAOImpl;
import dcu.datamodel.ExtraSession;
import dcu.datamodel.Session;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 08/04/2016.
 */
@Path("extraSession")
public class ExtraSessionController {

    ExtraSessionDAOImpl extraSessionDAOImpl = new ExtraSessionDAOImpl();

    @GET
    @Path("/getAllExtraSessions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllExtraSessions()throws IOException, NotFoundException, JSONException {

        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getAllExtraSessions();

        if (extraSessionList == null) {
            throw new NotFoundException("extra sessions do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("extraSession",extraSessionList);

        Gson gson = new Gson();
        String extraSessions = gson.toJson(jsonObj);

        return extraSessions;

    }

    @GET
    @Path("/getExtraSessionById/{extraSessionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExtraSessionById(@PathParam("extraSessionId") final int extraSessionId) throws IOException, NotFoundException,JSONException{
        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionById(extraSessionId);

        if (extraSessionList == null) {
            throw new NotFoundException("extra session does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("extraSession",extraSessionList);

        Gson gson = new Gson();
        String extraSession = gson.toJson(jsonObj);

        return extraSession;

    }

    @GET
    @Path("/getExtraSessionByWeekIdPlayerId/weekId/{weekId}/playerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExtraSessionByWeekIdPlayerId(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{
        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionByWeekIdPlayerId(weekId,playerId);

        if (extraSessionList == null) {
            throw new NotFoundException("extra sessions do not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("extraSession",extraSessionList);

        Gson gson = new Gson();
        String extraSessions = gson.toJson(jsonObj);

        return extraSessions;

    }

    @GET
    @Path("/getExtraSessionByPlayer/playerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExtraSessionPlayerId(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{
        List<ExtraSession> extraSessionList = extraSessionDAOImpl.getExtraSessionByPlayerId(playerId);

        if (extraSessionList == null) {
            throw new NotFoundException("extra sessions do not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("extraSessions",extraSessionList);

        Gson gson = new Gson();
        String extraSessions = gson.toJson(jsonObj);

        return extraSessions;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createExtraSession/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}")
    public String createExtraSession(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("sessionType1") final String sessionType1) throws IOException, NotFoundException,JSONException{

        extraSessionDAOImpl.createExtraSession(weekId,playerId,sessionType1);
        return "createExtraSession";

    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createExtraSession2/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}/sessionType2/{sessionType2}/sessionType3/{sessionType3}/sessionType4/{sessionType4}/sessionType5/{sessionType5}/sessionType6/{sessionType6}/sessionType7/{sessionType7}")
    public String createExtraSession2(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("sessionType1") final String sessionType1,@PathParam("sessionType2") final String sessionType2,@PathParam("sessionType3") final String sessionType3,@PathParam("sessionType4") final String sessionType4,@PathParam("sessionType5") final String sessionType5,@PathParam("sessionType6") final String sessionType6,@PathParam("sessionType7") final String sessionType7) throws IOException, NotFoundException,JSONException{

        extraSessionDAOImpl.createExtraSession2(weekId,playerId,sessionType1,sessionType2,sessionType3,sessionType4,sessionType5,sessionType6,sessionType7);
        return "createExtraSession";

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateExtraSession/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}")
    public String updateExraSession(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("sessionType1") final String sessionType1)throws IOException, NotFoundException,JSONException{


        extraSessionDAOImpl.updateExtraSession(weekId,playerId,sessionType1);

        //todo other puts here
        return "updatedExtraSession";
    }
    //@Path("/createExtraSession2/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}/sessionType2/{sessionType2}/sessionType3/{sessionType3}/sessionType4/{sessionType4}/sessionType5/{sessionType5}/sessionType6/{sessionType6}/sessionType7/{sessionType7}")

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateExtraSession2/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}/sessionType2/{sessionType2}/sessionType3/{sessionType3}/sessionType4/{sessionType4}/sessionType5/{sessionType5}/sessionType6/{sessionType6}/sessionType7/{sessionType7}")
    public String updateExtraSession2(@PathParam("weekId") final int weekId,@PathParam("playerId") final int playerId,@PathParam("sessionType1") final String sessionType1,@PathParam("sessionType2") final String sessionType2,@PathParam("sessionType3") final String sessionType3,@PathParam("sessionType4") final String sessionType4,@PathParam("sessionType5") final String sessionType5,@PathParam("sessionType6") final String sessionType6,@PathParam("sessionType7") final String sessionType7)throws IOException, NotFoundException,JSONException{


        extraSessionDAOImpl.updateExtraSession2(weekId,playerId,sessionType1,sessionType2,sessionType3,sessionType4,sessionType5,sessionType6,sessionType7);
        return "updatedExtraSession";
    }


}
