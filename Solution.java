import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution {
    public int solution(int Y, String A, String B, String W) {
        final short vacationStartMonth = findMonth(A);
        final short vacationEndMonth = findMonth(B);
        final short vacationLastDayDate = findLastDay(B, Y);

        if (vacationStartMonth == -1 || vacationEndMonth == -1 || vacationLastDayDate == -1) {
            System.out.println("invalid input");
            return -1;
        }

        LocalDate startDate = LocalDate.of(Y, vacationStartMonth, 1);
        LocalDate endDate = LocalDate.of(Y, vacationEndMonth, vacationLastDayDate);
        LocalDate startingMondayDate;

        if (startDate.getDayOfWeek().toString() != "MONDAY") {
            int daysTillMonday = findDaystoMonday(startDate.getDayOfWeek().toString());
            startingMondayDate = startDate.plusDays(daysTillMonday);
        } else {
            startingMondayDate = startDate;
        }

        long noOfWeeks = ChronoUnit.WEEKS.between(startingMondayDate, endDate);

        return ((int) noOfWeeks);
    }

    static short findMonth(String Month) {
        switch (Month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
        }
        return -1;
    }

    static short findLastDay(String Month, int Year) {
        switch (Month) {
            case "January":
                return 31;
            case "February":
                if (Year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            case "March":
                return 31;
            case "April":
                return 30;
            case "May":
                return 31;
            case "June":
                return 30;
            case "July":
                return 31;
            case "August":
                return 31;
            case "September":
                return 30;
            case "October":
                return 31;
            case "November":
                return 30;
            case "December":
                return 31;
        }
        return -1;
    }

    static int findDaystoMonday(String day) {
        switch (day) {
            case "TUESDAY":
                return 6;
            case "WEDNESDAY":
                return 5;
            case "THURSDAY":
                return 4;
            case "FRIDAY":
                return 3;
            case "SATURDAY":
                return 2;
            case "SUNDAY":
                return 1;
        }
        return -1;
    }
}