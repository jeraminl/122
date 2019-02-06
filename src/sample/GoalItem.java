package sample;

import java.util.Date;

public class GoalItem extends Item {
    int priority;
    Date due;
    public GoalItem(String i) {
        super(i);
    }

    public GoalItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        priority = p;
        due = new Date(year,month,date,hrs,min);
    }
}
