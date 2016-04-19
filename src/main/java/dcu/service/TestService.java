package dcu.service;

import javassist.NotFoundException;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Sean on 19/04/2016.
 */
public class TestService {


    ClubController clubController = new ClubController();


    public String returnClubs() throws IOException, NotFoundException, JSONException {

        String clubs;
        clubs = clubController.getAllClubs();

        //System.out.println(clubs);
        return clubs;
    }




}
