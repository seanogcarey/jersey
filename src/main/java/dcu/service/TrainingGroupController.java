package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.TrainingGroupDAOImpl;
import dcu.datamodel.TrainingGroup;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 21/04/2016.
 */

@Path("trainingGroups")
public class TrainingGroupController {

    TrainingGroupDAOImpl trainingGroupDAOImpl = new TrainingGroupDAOImpl();


    @GET
    @Path("/getAllTrainingGroups")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllTrainingGroups()throws IOException, NotFoundException, JSONException {

        List<TrainingGroup> trainingGroupList= trainingGroupDAOImpl.getAllTrainingGroups();

        if(trainingGroupList == null){

            throw new NotFoundException("training groups do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("trainingGroup",trainingGroupList);

        Gson gson = new Gson();
        String trainingGroups = gson.toJson(jsonObj);

        return trainingGroups;

    }


    @GET
    @Path("/getTrainingGroup/{trainingGroupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTrainingGroupById(@PathParam("trainingGroupId") final int trainingGroupId) throws IOException, NotFoundException,JSONException{
        List<TrainingGroup> trainingGroupList = trainingGroupDAOImpl.getTrainingGroupById(trainingGroupId);

        if (trainingGroupList == null) {
            throw new NotFoundException("training group does not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("trainingGroup",trainingGroupList);

        Gson gson = new Gson();
        String trainingGroup = gson.toJson(jsonObj);

        return trainingGroup;
    }


    @GET
    @Path("/getTrainingGroupByPlayerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTrainingGroupByPlayerId(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{
        List<TrainingGroup> trainingGroupList = trainingGroupDAOImpl.getTrainingGroupByPlayerId(playerId);

        if (trainingGroupList == null) {
            throw new NotFoundException("training group does not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("trainingGroup",trainingGroupList);

        Gson gson = new Gson();
        String trainingGroup = gson.toJson(jsonObj);

        return trainingGroup;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createTrainingGroup/playerId/{playerId}/fitnessId/{fitnessId}/fitnessGroup/{fitnessGroup}/strengthGroup/{strengthGroup}/speedGroup/{speedGroup}")
    public String createTrainingGroup(@PathParam("playerId") final int playerId,@PathParam("fitnessId") final int fintessId,@PathParam("fitnessGroup") final String fintessGroup,
                                      @PathParam("strengthGroup") final String strengthGroup, @PathParam("strengthGroup") final String speedGroup)
                                     throws IOException, NotFoundException,JSONException{

        trainingGroupDAOImpl.createTrainingGroup(playerId,fintessId,fintessGroup,strengthGroup,speedGroup);
        return "createTrainingGroup";

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateTrainingGroup/trainingGroupId/{trainingGroupId}/fitnessGroup/{fitnessGroup}/strengthGroup/{strengthGroup}/speedGroup/{speedGroup}")
    public String updateTrainingGroup(@PathParam("trainingGroupId") final int trainingGroupId,@PathParam("fitnessGroup") final String fintessGroup,
                             @PathParam("strengthGroup") final String strengthGroup, @PathParam("speedGroup") final String speedGroup)
            throws IOException, NotFoundException,JSONException{


        //todo find out if player id and fitness id are needed
        /*
        List<Updat> clubList = clubDAOImpl.getClubById(clubId);

        if (clubList == null) {
            throw new NotFoundException("club does not exist");
        }
        */
        trainingGroupDAOImpl.updateTrainingGroup(trainingGroupId, fintessGroup,strengthGroup,speedGroup);

        return "updatedClub";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateTrainingGroupByPlayerId/playerId/{playerId}/fitnessGroup/{fitnessGroup}/strengthGroup/{strengthGroup}/speedGroup/{speedGroup}")
    public String updateTrainingGroupByPlayerId(@PathParam("playerId") final int playerId,@PathParam("fitnessGroup") final String fintessGroup,
                             @PathParam("strengthGroup") final String strengthGroup, @PathParam("speedGroup") final String speedGroup)
            throws IOException, NotFoundException,JSONException{


        trainingGroupDAOImpl.updateTrainingGroupByPlayerId(playerId, fintessGroup,strengthGroup,speedGroup);

        return "updatedClub";
    }






}
