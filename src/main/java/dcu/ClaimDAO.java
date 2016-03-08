package dcu;

import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 08/03/2016.
 */
public interface ClaimDAO {

    public void printmsg();
    public List<Claim> getAllClaims() throws IOException, NotFoundException;
    public Claim getClaimByRef(final String claimReference);


}