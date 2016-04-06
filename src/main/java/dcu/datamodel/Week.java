package dcu.datamodel;

import java.sql.Date;

/**
 * Created by Sean on 06/04/2016.
 */
public class Week {
    private int weekId;
    private Date startDate;
    private Date endDate;
    private Integer weekNum;

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Week week = (Week) o;

        if (weekId != week.weekId) return false;
        if (startDate != null ? !startDate.equals(week.startDate) : week.startDate != null) return false;
        if (endDate != null ? !endDate.equals(week.endDate) : week.endDate != null) return false;
        if (weekNum != null ? !weekNum.equals(week.weekNum) : week.weekNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weekId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (weekNum != null ? weekNum.hashCode() : 0);
        return result;
    }
}
