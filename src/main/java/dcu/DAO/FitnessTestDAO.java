package dcu.DAO;

import dcu.datamodel.Claim;
import dcu.datamodel.FitnessTest;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */
public interface FitnessTestDAO {

    public List<FitnessTest> getAllFitnessTests() throws IOException, NotFoundException;
    public List<FitnessTest> getFintessTestById(final int fitnessId);
    public List<FitnessTest> getFintessTestByTeamId(final int playerId);
    public void createFitnessTest(final int playerId, final int bodyFat);
}
