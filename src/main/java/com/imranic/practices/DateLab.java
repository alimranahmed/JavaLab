package com.imranic.practices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateLab{
    public static void main(String[] args) {
        DateTimeFormatter isoFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("d MMM, yyyy");

        try {
            LocalDate dob = LocalDate.parse("1992-08-31", isoFormat);

            dob = dob.plusDays(31);
            System.out.println("Leap year? " + (dob.isLeapYear() ? "Yes" : "No"));

            System.out.println(dob.format(myFormat));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        LocalDate date = LocalDate.now();
        System.out.print("Current date is " + date.format(DateTimeFormatter.ofPattern("yyyy dd MMM")));
    }
}
