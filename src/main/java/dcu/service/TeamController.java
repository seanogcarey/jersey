package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.PlayerDAOImpl;
import dcu.DAO.TeamDAOImpl;
import dcu.datamodel.Player;
import dcu.datamodel.Team;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



@Path("teams")
public class TeamController {


    TeamDAOImpl teamDAOImpl = new TeamDAOImpl() ;
    PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();


    @GET
    @Path("/getAllTeams")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllTeams()throws IOException, NotFoundException, JSONException {

        List<Team> teamList = teamDAOImpl.getAllTeams();

        if (teamList == null) {
            throw new NotFoundException("teams do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("team",teamList);

        Gson gson = new Gson();
        String teams = gson.toJson(jsonObj);

        return teams;

    }

    @GET
    @Path("/getTeam/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeamById(@PathParam("teamId") final int teamId) throws IOException, NotFoundException,JSONException{
        List<Team> teamList = teamDAOImpl.getTeamById(teamId);

        if (teamList == null) {
            throw new NotFoundException("team does not exist");
        }

        List<Player> playerList = playerDAOImpl.getPlayerByTeamId(teamId);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("team",teamList);
        jsonObj.put("player",playerList);

        Gson gson = new Gson();
        String team = gson.toJson(jsonObj);

        return team;
    }


    @GET
    @Path("/getTeamByClub/{clubId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeamByClubId(@PathParam("clubId") final int clubId) throws IOException, NotFoundException,JSONException{
        List<Team> teamList = teamDAOImpl.getTeamByClubId(clubId);

        if (teamList == null) {
            throw new NotFoundException("team does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("team",teamList);

        Gson gson = new Gson();
        String team = gson.toJson(jsonObj);

        return team;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createTeam/clubId/{clubId}/teamName/{teamName}")
    public String createTeam(@PathParam("teamName") final String teamName,@PathParam("clubId") final int clubId) throws IOException, NotFoundException,JSONException{

        teamDAOImpl.createTeam(teamName,clubId);
        return "createTeam";

    }

}
