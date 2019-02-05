package sample;

import java.util.Date;

public class TodoItem extends Item {
    Date due;
    int priority;

    public TodoItem(String i) {
        super(i);
    }
    public TodoItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        due = new Date(year,month,date,hrs,min);
        priority = p;
    }
}
