package dcu;

import com.google.gson.Gson;
import javassist.NotFoundException;
import org.codehaus.jackson.map.ObjectMapper;

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

        Claim claim = new Claim();

        if (claimList == null) {
            throw new NotFoundException("claim does not exist");
        }

        claimList.add(claim);

        Gson gson = new Gson();
        String json = gson.toJson(claim);

        System.out.println("--------THIS IS THE JSON----------" + json);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(claimList);

        return json;

    }
    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaim()throws IOException, NotFoundException {
        List<Claim> claim = claimDAOImpl.getOneClaim();

        if (claim == null) {
            throw new NotFoundException("claim does not exist");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(claim);

        return jsonInString;

    }


}
