package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.FitnessTestDAOImpl;
import dcu.DAO.ManagerDAOImpl;
import dcu.DAO.TeamDAOImpl;
import dcu.datamodel.FitnessTest;
import dcu.datamodel.Manager;
import dcu.datamodel.Team;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



@Path("fitnessTest")
public class FitnessTestController {


    FitnessTestDAOImpl fitnessTestDAOImpl = new FitnessTestDAOImpl();


    @GET
    @Path("/getAllFitnessTests")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFitnessTests()throws IOException, NotFoundException, JSONException {

        List<FitnessTest> fitnessTestList = fitnessTestDAOImpl.getAllFitnessTests();

        if (fitnessTestList == null) {
            throw new NotFoundException("fitness tests do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("fitnessTest",fitnessTestList);

        Gson gson = new Gson();
        String fitnessTests = gson.toJson(jsonObj);

        return fitnessTests;

    }

    @GET
    @Path("/getFitnessTest/{fitnessTestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getManagerById(@PathParam("fitnessTestId") final int fitnessTestId) throws IOException, NotFoundException,JSONException{
        List<FitnessTest> fitnessTestList = fitnessTestDAOImpl.getFintessTestById(fitnessTestId);

        if (fitnessTestList == null) {
            throw new NotFoundException("fintessTest does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("fitnessTest",fitnessTestList);

        Gson gson = new Gson();
        String fitnessTest = gson.toJson(jsonObj);

        return fitnessTest;
    }


    @GET
    @Path("/getFitnessTestByPlayerId/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFitnessTestByPlayerId(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{
        List<FitnessTest> fitnessTestList = fitnessTestDAOImpl.getFintessTestByPlayerId(playerId);

        if (fitnessTestList == null) {
            throw new NotFoundException("player does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("fitnessTest",fitnessTestList);

        Gson gson = new Gson();
        String fitnessTest = gson.toJson(jsonObj);

        return fitnessTest;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createFitnessTest/playerId/{playerId}/bodyFat/{bodyFat}")
    public String createFitnessTest(@PathParam("playerId") final int playerId,@PathParam("bodyFat") final int bodyFat) throws IOException, NotFoundException,JSONException{

        fitnessTestDAOImpl.createFitnessTest(playerId,bodyFat);
        return "createFitnesstest";

    }

}
