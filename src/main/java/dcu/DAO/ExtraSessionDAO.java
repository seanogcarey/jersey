package dcu.DAO;

import dcu.datamodel.ExtraSession;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public interface ExtraSessionDAO {
    public List<ExtraSession> getAllExtraSessions() throws IOException, NotFoundException;
    public List<ExtraSession> getExtraSessionById(final int extraSessionId);
    public List<ExtraSession> getExtraSessionByWeekId(final int weekId);
    public List<ExtraSession> getExtraSessionByPlayerId(final int playerId);
    public List<ExtraSession> getExtraSessionByWeekIdPlayerId(final int playerId,final int weekId);

    public void createExtraSession(final int weekId, final int playerId, final String sessionType1);
}

