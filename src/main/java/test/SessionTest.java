package test;

import dcu.datamodel.Session;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 17/05/2016.
 */
public class SessionTest {

    @Test
    public void getSessionIdTest() {

        Session session= new Session();
        session.setSessionId(122);

        assertNotNull(session.getSessionId());
        assertEquals(session.getSessionId(),122);
    }

    @Test
    public void getSessionTypeTest() {

        Session session= new Session();
        session.setSessionType("Training");

        assertNotNull(session.getSessionType());
        assertEquals(session.getSessionType(),"Training");
    }


    @Test
    public void getWeekIdTest() {

        Session session= new Session();
        session.setWeekId(22);

        assertNotNull(session.getWeekId());
        assertEquals(session.getWeekId(),22);
    }


    @Test
    public void getSessionStringTest(){

        Session session = new Session();
        session.setSessionDateString("17.05.2016");

        assertNotNull(session.getSessionDateString());
        assertEquals(session.getSessionDateString(),"17.05.2016");
    }


}
