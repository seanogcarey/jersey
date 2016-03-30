package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.ClubDAOImpl;
import dcu.datamodel.Club;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



@Path("clubs")
public class ClubController {


    ClubDAOImpl clubDAOImpl = new ClubDAOImpl() ;


    @GET
    @Path("/getAllClubs")
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

        System.out.println("I Have the claimID " + clubId);
        if (clubList == null) {
            throw new NotFoundException("club does not exist");
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("club",clubList);

        Gson gson = new Gson();
        String club = gson.toJson(jsonObj);

        return club;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createClub/{clubName}")
    public String createClub(@PathParam("clubName") final String clubName) throws IOException, NotFoundException,JSONException{

        clubDAOImpl.createClub(clubName);
        //todo St John's GAA club-> ' gives weird result
        return "createClub";

    }

}
