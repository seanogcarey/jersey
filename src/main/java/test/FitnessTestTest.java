package test;

import dcu.datamodel.FitnessTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 18/05/2016.
 */
public class FitnessTestTest {


    @Test
    public void getFitnessIdTest() {

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setFitnessId(22);

        assertNotNull(fitnessTest.getFitnessId());
        assertEquals(fitnessTest.getFitnessId(),22);
    }

    @Test
    public void getPlayerIdTest() {

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setPlayerId(22);

        assertNotNull(fitnessTest.getPlayerId());
        assertEquals(fitnessTest.getPlayerId(),22);
    }

    @Test
    public void getChinUpsTest() {

        Integer num = 2;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setChinUps(num);

        assertNotNull(fitnessTest.getChinUps());
        assertEquals(fitnessTest.getChinUps(),num);
    }

    @Test
    public void getPushUpsTest() {

        Integer num = 2;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setPushUps(num);

        assertNotNull(fitnessTest.getPushUps());
        assertEquals(fitnessTest.getPushUps(),num);
    }

    @Test
    public void getSprintTest() {

        Integer num = 2;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setSprint(num);

        assertNotNull(fitnessTest.getSprint());
        assertEquals(fitnessTest.getSprint(),num);
    }

    @Test
    public void getKmRunTest() {

        Integer num = 2;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setKmRun(num);

        assertNotNull(fitnessTest.getKmRun());
        assertEquals(fitnessTest.getKmRun(),num);
    }

    @Test
    public void getAgilityTest() {

        Integer num = 2;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setAgility(num);

        assertNotNull(fitnessTest.getAgility());
        assertEquals(fitnessTest.getAgility(),num);
    }


    @Test
    public void getWorkLifestyleTest() {

        Integer num = 5;

        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setWorkLifestyle(num);

        assertNotNull(fitnessTest.getWorkLifestyle());
        assertEquals(fitnessTest.getWorkLifestyle(),num);
    }

    @Test
    public void getWeeklyAverageTrainingCountTest() {


        Double num = 3.6555;
        FitnessTest fitnessTest= new FitnessTest();
        fitnessTest.setWeeklyAverageTrainingCount(num);

        assertNotNull(fitnessTest.getWeeklyAverageTrainingCount());
        assertEquals(fitnessTest.getWeeklyAverageTrainingCount(),num);


    }

}
