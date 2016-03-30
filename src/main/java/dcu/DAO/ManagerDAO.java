package dcu.DAO;

import dcu.datamodel.Manager;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */
public interface ManagerDAO {

    public List<Manager> getAllManagers() throws IOException, NotFoundException;
    public List<Manager> getManagerById(final int managerId);
    public List<Manager> getManagerByTeamId(final int teamId);
    public void createManager(final String firstName,final String lastName, final int teamId);
}