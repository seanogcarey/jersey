package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.ClubDAOImpl;
import dcu.DAO.TeamDAOImpl;
import dcu.datamodel.Club;
import dcu.datamodel.Manager;
import dcu.datamodel.Team;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



@Path("clubs")
public class ClubController {


    ClubDAOImpl clubDAOImpl = new ClubDAOImpl() ;
    TeamDAOImpl teamDAOImpl = new TeamDAOImpl();


    @GET
    @Path("/getClub/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllClubs()throws IOException, NotFoundException, JSONException {

        List<Club> clubList = clubDAOImpl.getAllClubs();

        if (clubList == null) {
            throw new NotFoundException("clubs do not exist");
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("club",clubList);


        Gson gson = new Gson();
        String clubs = gson.toJson(jsonObj);


        return clubs;

    }

    @GET
    @Path("/getClub/{clubId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClubById(@PathParam("clubId") final int clubId) throws IOException, NotFoundException,JSONException{
        List<Club> clubList = clubDAOImpl.getClubById(clubId);


        if (clubList == null) {
            throw new NotFoundException("club does not exist");
        }

        List<Team> teamList = teamDAOImpl.getTeamByClubId(clubId);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("club",clubList);
        jsonObj.put("team",teamList);

        Gson gson = new Gson();
        String club = gson.toJson(jsonObj);

        return club;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createClub/{clubName}/email/{email}/address/{address}/sport/{sport}/clubContactNumber/{clubContactNumber}")
    public String createClub(@PathParam("clubName") final String clubName,@PathParam("email") final String email,@PathParam("address") final String address,
                             @PathParam("sport") final String sport,@PathParam("clubContactNumber") final String clubContactNumber) throws IOException, NotFoundException,JSONException{

        clubDAOImpl.createClub(clubName,email,address,sport,clubContactNumber);
        return "createClub";

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateClub/club/{clubId}/clubName/{clubName}")
    public String updateClub(@PathParam("clubId") final int clubId,@PathParam("clubName") final String clubName)throws IOException, NotFoundException,JSONException{


        List<Club> clubList = clubDAOImpl.getClubById(clubId);

        if (clubList == null) {
            throw new NotFoundException("club does not exist");
        }

        clubDAOImpl.updateClub(clubId,clubName);

        return "updatedClub";
    }

}
