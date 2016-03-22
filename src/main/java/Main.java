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


        ClaimsController claimsController = new ClaimsController();

        String claims = claimsController.getClaims();
        System.out.println("Claim List: " + claims);

    }
}
