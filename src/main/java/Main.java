import com.google.gson.Gson;
import dcu.Claim;
import dcu.ClaimsController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 08/03/2016.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
        System.out.println("Hello World");

        /*
        ClaimsController claimsController = new ClaimsController();

        List<Claim> list = claimsController.getClaims();
        //ist<Claim> claimList = claimTest.getAllClaims();
        System.out.println("Claim List: " + list);
        */
        Claim claim = new Claim();
        claim.setClaimId(4);
        claim.setClaimReference("jersey ref");

        List<Claim> claimList = new ArrayList<>();
        claimList.add(claim);


        Gson gson = new Gson();

        String json = gson.toJson(claim);

        System.out.println(json);

    }
}
