package dcu.DAO;

import dcu.datamodel.TrainingGroup;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 21/04/2016.
 */
public interface TrainingGroupDAO {


    public List<TrainingGroup> getAllTrainingGroups() throws IOException, NotFoundException;
    public List<TrainingGroup> getTrainingGroupById(final int trainingGroupId);
    List<TrainingGroup> getTrainingGroupByPlayerId(final int playerId);
    List<TrainingGroup> getTrainingGroupByFitnessId(final int fitnessId);
    public List<TrainingGroup> getTrainingGroupByPlayerIdFitnessId(final int playerId,final int fitnessId);
    public void createTrainingGroup(final int playerId,final int fitnessId,final String fitnessGroup,final String strengthGroup,final String speedGroup);
    public void updateTrainingGroup(final int trainingGroupId,final String fitnessGroup,final String strengthGroup,final String speedGroup);



    }
