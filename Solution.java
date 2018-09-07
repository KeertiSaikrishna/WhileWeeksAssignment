import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Solution {
    public int solution(int Y, String A, String B, String W) {
        final short vacationStartMonth = (short) (Month.valueOf(A.toUpperCase()).ordinal()+1);
        final short vacationEndMonth = (short) (Month.valueOf(B.toUpperCase()).ordinal()+1);


        boolean leapYear = Y % 4 == 0 ? true:false;
                            //checking if the year is a leap year
        final short vacationLastDayDate = (short) (Month.valueOf(B.toUpperCase()).length(leapYear));
                            //finding last day of vacation

        if (vacationStartMonth == -1 || vacationEndMonth == -1 || vacationLastDayDate == -1) {
            System.out.println("invalid input");
            return -1;
        }

        LocalDate startDate = LocalDate.of(Y, vacationStartMonth, 1);
        LocalDate endDate = LocalDate.of(Y, vacationEndMonth, vacationLastDayDate);
        LocalDate startingMondayDate;

        if (startDate.getDayOfWeek().toString() != "MONDAY") {
            int daysTillMonday = (7 - (startDate.getDayOfWeek().ordinal()));
                                                //finding number of days to next monday
            startingMondayDate = startDate.plusDays(daysTillMonday);
        } else {
            startingMondayDate = startDate;
        }
                    //Finding the first monday of the vacation

        long noOfWeeks = ChronoUnit.WEEKS.between(startingMondayDate, endDate);
                    //Finding the number of weeks of vacation
        return ((int) noOfWeeks);
    }
}
