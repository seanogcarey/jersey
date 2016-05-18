package dcu.DAO;

import dcu.datamodel.Week;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 06/04/2016.
 */
public interface WeekDAO {

    public List<Week> getAllWeeks() throws IOException, NotFoundException;
    public List<Week> getWeekById(final int weekId);
    public List<Week> getWeekByTeamId(final int teamId);
    public void createWeek(final int teamId,final int weekNum,final String startDateString,final String endDateString);
}
