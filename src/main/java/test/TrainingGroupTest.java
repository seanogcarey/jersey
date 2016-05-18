package test;

import dcu.datamodel.TrainingGroup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 17/05/2016.
 */
public class TrainingGroupTest {


    @Test
    public void getTrainingGroupIdTest() {

        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setTrainingGroupId(12);

        assertNotNull(trainingGroup.getTrainingGroupId());
        assertEquals(trainingGroup.getTrainingGroupId(),12);
    }

    @Test
    public void getPlayerIdTest() {

        Integer id = 12;
        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setPlayerId(id);

        assertNotNull(trainingGroup.getPlayerId());
        assertEquals(trainingGroup.getPlayerId(),id);
    }

    @Test
    public void getFitnessTestIdTest() {

        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setFitnessId(12);

        assertNotNull(trainingGroup.getFitnessId());
        assertEquals(trainingGroup.getFitnessId(),12);
    }

    @Test
    public void getFitnessGroupIdTest() {

        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setFitnessGroup("Low");

        assertNotNull(trainingGroup.getFitnessGroup());
        assertEquals(trainingGroup.getFitnessGroup(),"Low");
    }

    @Test
    public void getStrengthGroupIdTest() {

        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setStrengthGroup("Low");

        assertNotNull(trainingGroup.getStrengthGroup());
        assertEquals(trainingGroup.getStrengthGroup(),"Low");
    }

    @Test
    public void getSpeedGroupIdTest() {

        TrainingGroup trainingGroup= new TrainingGroup();
        trainingGroup.setSpeedGroup("Low");

        assertNotNull(trainingGroup.getSpeedGroup());
        assertEquals(trainingGroup.getSpeedGroup(),"Low");
    }


}
