package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatDates {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        Month_Day_Year(now);
        Year_Month_Day(now);
        System.out.println(WholenameOfMonth_Day_Year(now));
        WeekDay_Month_Day_Year_CurrentTime(now);
        currentTime_on_Day_Month_Year(now);
    }
// First type to get Today's day first month/day/year
    static void Month_Day_Year(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        System.out.println(now.format(format1));
    }
// Second type to get Today's day first year-month-day
    static void Year_Month_Day(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(format2));
    }
//Full name of month day, year and return current day as a string

    static String WholenameOfMonth_Day_Year(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return format3.format(now);

    }
//Shows day of week, month day, year  current time
    static void WeekDay_Month_Day_Year_CurrentTime(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("eeee, MMM dd, yyyy  hh:mm a");
        System.out.println(format5.format(now)  + " \u00DF display in GMT time");
    }
//Shows current time on day-month-year
    static void currentTime_on_Day_Month_Year(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm a 'on' dd-MMM-yyyy");
        System.out.println(format6.format(now) + " \u00DF display in your local time zone");
    }
}
