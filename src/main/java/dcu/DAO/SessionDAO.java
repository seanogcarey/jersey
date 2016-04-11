package dcu.DAO;

import dcu.datamodel.Session;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public interface SessionDAO {

    public List<Session> getAllSessions() throws IOException, NotFoundException;
    public List<Session> getSessionById(final int sessionId);
    public List<Session> getSessionByWeekId(final int weekId);
    public void createSession(final int weekId,final String sessionType);
}
