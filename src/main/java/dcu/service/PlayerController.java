package dcu.service;

import antlr.StringUtils;
import com.google.gson.Gson;
import dcu.DAO.ManagerDAOImpl;
import dcu.DAO.PlayerDAOImpl;
import dcu.datamodel.Manager;
import dcu.datamodel.Player;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */

@Path("players")
public class PlayerController {


    PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl() ;
    int count = 0;


    @GET
    @Path("/getAllPlayers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPlayers()throws IOException, NotFoundException, JSONException {

        List<Player> playerList = playerDAOImpl.getAllPlayers();

        if (playerList == null) {
            throw new NotFoundException("players do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("player",playerList);

        Gson gson = new Gson();
        String players = gson.toJson(jsonObj);

        return players;

    }

    @GET
    @Path("/getPlayer/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getManagerById(@PathParam("playerId") final int playerId) throws IOException, NotFoundException,JSONException{
        List<Player> playerList = playerDAOImpl.getPlayerById(playerId);

        if (playerList == null) {
            throw new NotFoundException("player does not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("player",playerList);

        Gson gson = new Gson();
        String player = gson.toJson(jsonObj);

        System.out.println("Player is : " + player);

        return player;
    }


    @GET
    @Path("/getPlayerByTeamId/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlayerByTeamId(@PathParam("teamId") final int teamId) throws IOException, NotFoundException,JSONException{
        List<Player> playerList = playerDAOImpl.getPlayerByTeamId(teamId);

        if (playerList == null) {
            throw new NotFoundException("players do not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("player",playerList);

        Gson gson = new Gson();
        String player = gson.toJson(jsonObj);

        return player;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createPlayer/teamId/{teamId}/FirstName/{firstName}/SecondName/{secondName}")
    public String createPlayer(@PathParam("teamId") final int teamId,@PathParam("firstName") final String firstName,@PathParam("secondName") final String secondName) throws IOException, NotFoundException,JSONException{

        playerDAOImpl.createPlayer(firstName,secondName,teamId);
        return "createPlayer";

    }

}
