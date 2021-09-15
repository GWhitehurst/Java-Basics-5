package com.gw.sse;

import java.time.*;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        monthLengths(Year.of(2021));

        mondays(Month.of(2));
        mondays(Month.of(5));

        System.out.println(isFridayThirteenth(MonthDay.of(8,13)));
        System.out.println(isFridayThirteenth(MonthDay.of(4, 12)));
    }

    public static void monthLengths(Year yyyy){
        int y = yyyy.getValue();
        for(int i = 1; i < 13; i++){
            YearMonth ym = YearMonth.of(y, i);
            if(ym.isValidDay(31)){
                System.out.println(ym.getMonth() + " # of days: 31");
            }
            else if(ym.isValidDay(30)){
                System.out.println(ym.getMonth() + " # of days: 30");
            }
            else if(ym.isValidDay(29)){
                System.out.println(ym.getMonth() + " # of days: 29");
            }
            else if(ym.isValidDay(28)){
                System.out.println(ym.getMonth() + " # of days: 28");
            }
        }
    }

    public static void mondays(Month m){
        int y = Year.now().getValue();
        LocalDate testDate;
        for(int i = 1; i < 32; i++){
            if(YearMonth.of(y,m).isValidDay(i)){
                testDate = LocalDate.of(y,m,i);
                if(testDate.getDayOfWeek() == DayOfWeek.MONDAY){
                    System.out.println(m + " " + i);
                }
            }
        }
    }

    public static boolean isFridayThirteenth(MonthDay md){
        int y = Year.now().getValue();
        LocalDate testDate = LocalDate.of(y, md.getMonthValue(), md.getDayOfMonth());
        if(md.getDayOfMonth() == 13 && testDate.getDayOfWeek() == DayOfWeek.FRIDAY){
            return true;
        }
        return false;
    }
}


////Text Answers ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. LocalDateTime
//2. One would use the DayOfWeek enum, and compare how many days back last Tuesday was.
//3. ZoneID represents a specific time zone, such as PST, and ZoneOffset gives the offset of a specific time zone from UTC
//4. A ZonedDateTime comes from combining an Instant and ZoneID with instant.atZone()
//   An Instant comes from reversing that, using toInstant()