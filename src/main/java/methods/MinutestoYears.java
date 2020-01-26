package methods;

public class MinutestoYears {
    private static final long MINUTES_IN_YEAR=365*24*60;
    private static final long MINUTES_IN_DAY=24*60;
    private static final long MINUTES_IN_HOUR=60;

    public static void main(String[] args){
        minutesInYears(3456665);
        minutesInYears(4643);
        minutesInYears(956755);

}
public static void minutesInYears(long minutes){
        long years, days, hour, leftMinutes;
        if(minutes < 0L) {
            System.out.println("Invalid entry minutes value:" + minutes);
        } else {
            years = minutes / MINUTES_IN_YEAR;
            if(years < 0L)
                years = 0L;

            days = (minutes - years * MINUTES_IN_YEAR) / MINUTES_IN_DAY;
            if (days < 0L)
                days = 0L;

            hour = (minutes - years * MINUTES_IN_YEAR - days * MINUTES_IN_DAY) / MINUTES_IN_HOUR;
            if(hour < 0L)
                hour = 0L;

            leftMinutes = (minutes - years * MINUTES_IN_YEAR - days * MINUTES_IN_DAY - hour *MINUTES_IN_HOUR);
            if (leftMinutes < 0L)
                leftMinutes = 0L;
            System.out.println(minutes + "min = " + years + "y " + days + "d " + hour + "h " + leftMinutes + "min ");
        }
}

}


