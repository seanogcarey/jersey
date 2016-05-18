package test;

import dcu.datamodel.Manager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sean on 17/05/2016.
 */
public class ManagerTest {


    @Test
    public void getManagerIdTest() {

        Manager manager = new Manager();
        manager.setManagerId(3);

        assertNotNull( manager.getManagerId());
        assertEquals(manager.getManagerId(),3);
    }

    @Test
    public void getFirstNameTest() {

        Manager manager = new Manager();
        manager.setFirstName("John");

        assertNotNull( manager.getFirstName());
        assertEquals(manager.getFirstName(),"John");
    }

    @Test
    public void getLastNameTest() {

        Manager manager = new Manager();
        manager.setLastName("Murphy");

        assertNotNull( manager.getLastName());
        assertEquals(manager.getLastName(),"Murphy");
    }

    @Test
    public void getPhoneNumberTest() {

        Manager manager = new Manager();
        manager.setPhoneNumber("087244901");

        assertNotNull( manager.getPhoneNumber());
        assertEquals(manager.getPhoneNumber(),"087244901");
    }

    @Test
    public void getEmailTest() {

        Manager manager = new Manager();
        manager.setEmail("seanogcarey@email.com");

        assertNotNull(manager.getEmail());
        assertEquals(manager.getEmail(),"seanogcarey@email.com");
    }

    @Test
    public void getTeamIdTest() {

        Integer id = 22;
        Manager manager = new Manager();
        manager.setTeamId(id);
        assertNotNull( manager.getTeamId());
        assertEquals(manager.getTeamId(),id);
    }
    
    
}
