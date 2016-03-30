package dcu.DAO;

import dcu.datamodel.Team;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 29/03/2016.
 */
public interface TeamDAO {

    public List<Team> getAllTeams() throws IOException, NotFoundException;
    public Team getTeamById(final int teamId);
    public void createTeam(final String teamName,final int clubId);
}
