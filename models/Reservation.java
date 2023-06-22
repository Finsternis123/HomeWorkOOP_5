package ru.geekbrains.lesson5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 9000;
    private final int id;
    private final int Newid;

    private Date date;
    private String name;

    public int getId() {
        return id;
    }
    public int getNewid() {
        return Newid;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    {
        id = ++counter;
        Newid = ++counter;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}
