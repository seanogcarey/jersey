package dcu.service;

import com.google.gson.Gson;
import dcu.DAO.ClaimDAOImpl;
import dcu.datamodel.Claim;
import javassist.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



@Path("claims")
public class ClaimsController {


    ClaimDAOImpl claimDAOImpl = new ClaimDAOImpl() ;


    @GET
    @Path("/getAllClaims")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaims()throws IOException, NotFoundException, JSONException {

        List<Claim> claimsList = claimDAOImpl.getAllClaims();

        if (claimsList == null) {
            throw new NotFoundException("claims do not exist");
        }

        //test data:

        /*
        Claim claim1 = new Claim();
        claim1.setClaimId(4);
        claim1.setClaimReference("Test 4");
        Claim claim2 = new Claim();
        claim2.setClaimId(5);
        claim2.setClaimReference("Test 5");

        ArrayList<Claim> mylist = new ArrayList<Claim> ();
        mylist.add(claim1);
        mylist.add(claim2);

        JSONObject obj = new JSONObject();
        obj.put("claim", mylist);
        String json3 = new Gson().toJson(obj);
        System.out.println("HERE " + json3);


        JSONObject obj2 = new JSONObject();
        obj2.put("claim", claim1);
        String json4= new Gson().toJson(obj2);
        System.out.println("Claim on its own " + json4);

        String json2 = new Gson().toJson(mylist);
        System.out.println("THE CLAIMS ARRAY : " + json2);
        */


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("claim",claimsList);

        Gson gson = new Gson();
        String claims = gson.toJson(jsonObj);

        return claims;

    }

    @GET
    @Path("/getClaim/{claimId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaim(@PathParam("claimId") final int claimId) throws IOException, NotFoundException,JSONException{
        List<Claim> claimList = claimDAOImpl.getOneClaim(claimId);

        System.out.println("I Have the claimID " + claimId);
        if (claimList == null) {
            throw new NotFoundException("claim does not exist");
        }

        /*
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(claim);
        */


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("claim",claimList);

        Gson gson = new Gson();
        String claim = gson.toJson(jsonObj);

        return claim;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createClaim/{claimReference}")
     public String createClaim(@PathParam("claimReference") final String claimReference) throws IOException, NotFoundException,JSONException{

        claimDAOImpl.createClaim(claimReference);
        return "createClaim";

    }

}
