package dcu;

import com.google.gson.Gson;
import javassist.NotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;




@Path("claims")
public class ClaimsController {


    ClaimDAOImpl claimDAOImpl = new ClaimDAOImpl() ;


    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaims()throws IOException, NotFoundException {

        List<Claim> claimList = claimDAOImpl.getAllClaims();

        if (claimList == null) {
            throw new NotFoundException("claim does not exist");
        }
        Gson gson = new Gson();
        String json = gson.toJson(claimList);

        return json;

    }

    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaim()throws IOException, NotFoundException, JsonMappingException{
        List<Claim> claim = claimDAOImpl.getOneClaim();

        if (claim == null) {
            throw new NotFoundException("claim does not exist");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(claim);

        return jsonInString;

    }


}
