package test;

import dcu.datamodel.ExtraSession;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 18/05/2016.
 */
public class ExtraSessionTest {



    @Test
    public void getExtraSessionIdTest() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setExtraSessionId(22);

        assertNotNull(extraSession.getExtraSessionId());
        assertEquals(extraSession.getExtraSessionId(),22);
    }


    @Test
    public void getPlayerIdTest() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setPlayerId(22);

        assertNotNull(extraSession.getPlayerId());
        assertEquals(extraSession.getPlayerId(),22);
    }


    @Test
    public void getWeekIdTest() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setWeekId(22);

        assertNotNull(extraSession.getWeekId());
        assertEquals(extraSession.getWeekId(),22);
    }

    @Test
    public void getSessionType1Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType1("College Training");

        assertNotNull(extraSession.getSessionType1());
        assertEquals(extraSession.getSessionType1(),"College Training");
    }

    @Test
    public void getSessionType2Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType2("College Training");

        assertNotNull(extraSession.getSessionType2());
        assertEquals(extraSession.getSessionType2(),"College Training");
    }


    @Test
    public void getSessionType3Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType3("College Training");

        assertNotNull(extraSession.getSessionType3());
        assertEquals(extraSession.getSessionType3(),"College Training");
    }

    @Test
    public void getSessionType4Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType4("College Training");

        assertNotNull(extraSession.getSessionType4());
        assertEquals(extraSession.getSessionType4(),"College Training");
    }


    @Test
    public void getSessionType5Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType5("College Training");

        assertNotNull(extraSession.getSessionType5());
        assertEquals(extraSession.getSessionType5(),"College Training");
    }


    @Test
    public void getSessionType6Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType6("College Training");

        assertNotNull(extraSession.getSessionType6());
        assertEquals(extraSession.getSessionType6(),"College Training");
    }

    @Test
    public void getSessionType7Test() {

        ExtraSession extraSession= new ExtraSession();
        extraSession.setSessionType7("College Training");

        assertNotNull(extraSession.getSessionType7());
        assertEquals(extraSession.getSessionType7(),"College Training");
    }
}
