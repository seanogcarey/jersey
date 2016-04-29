package dcu.DAO;


import dcu.datamodel.Player;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 30/03/2016.
 */
public interface PlayerDAO {

    public List<Player> getAllPlayers() throws IOException, NotFoundException;
    public List<Player> getPlayerById(final int managerId);
    public List<Player> getPlayerByTeamId(final int teamId);
    public void createPlayer(final String firstName,final String lastName, final int teamId, final String phoneNumber,final String email);
}


