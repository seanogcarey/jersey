package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.ManagerDAOImpl;
import dcu.DAO.TeamDAOImpl;
import dcu.datamodel.Manager;
import dcu.datamodel.Team;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



@Path("managers")
public class ManagerController {


    ManagerDAOImpl managerDAOImpl = new ManagerDAOImpl() ;


    @GET
    @Path("/getAllManagers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllManagers()throws IOException, NotFoundException, JSONException {

        List<Manager> managerList = managerDAOImpl.getAllManagers();

        if (managerList == null) {
            throw new NotFoundException("managers do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("team",managerList);

        Gson gson = new Gson();
        String managers = gson.toJson(jsonObj);

        return managers;

    }

    @GET
    @Path("/getManager/{managerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getManagerById(@PathParam("managerId") final int managerId) throws IOException, NotFoundException,JSONException{
        List<Manager> managerList = managerDAOImpl.getManagerById(managerId);

        if (managerList == null) {
            throw new NotFoundException("manager does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("manager",managerList);

        Gson gson = new Gson();
        String manager = gson.toJson(jsonObj);

        return manager;
    }


    @GET
    @Path("/getManagerByTeamId/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getManagerByTeamId(@PathParam("teamId") final int teamId) throws IOException, NotFoundException,JSONException{
        List<Manager> mangerList = managerDAOImpl.getManagerByTeamId(teamId);

        if (mangerList == null) {
            throw new NotFoundException("manager does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("manager",mangerList);

        Gson gson = new Gson();
        String manager = gson.toJson(jsonObj);

        return manager;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createManager/teamId/{teamId}/FirstName/{firstName}/SecondName/{secondName}")
    public String createManager(@PathParam("teamId") final int teamId,@PathParam("firstName") final String firstName,@PathParam("secondName") final String secondName) throws IOException, NotFoundException,JSONException{

        managerDAOImpl.createManager(firstName,secondName,teamId);
        return "createManager";

    }

}
