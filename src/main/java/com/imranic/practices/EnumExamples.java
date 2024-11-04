package com.imranic.practices;

public class EnumExamples {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
        // These are enum constants
        // public static and final
        // since its final you can not create child enums
        // Type is Week
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
        System.out.println(week);
        System.out.println(Week.valueOf("Friday"));
        for (Week day: Week.values()) {
            System.out.println(day);
        }
    }
}
