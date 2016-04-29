package dcu.DAO;

/**
 * Created by Sean on 29/03/2016.
 */
import dcu.datamodel.Claim;
import dcu.datamodel.Club;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 08/03/2016.
 */
public interface ClubDAO {


    public List<Club> getAllClubs() throws IOException, NotFoundException;
    public List<Club> getClubById(final int clubId);
    public void createClub(final String clubName,final String email,final String address,final String sport,final String clubContactNumber);
    public void updateClub(final int clubId, final String clubName);

}
