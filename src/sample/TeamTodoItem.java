package sample;

import java.util.Date;

public class TeamTodoItem extends Item {
    int priority;
    Date due;
    public TeamTodoItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        due = new Date(year,month,date,hrs,min);
        priority = p;

    }

    public void printContent(){
        if (isCompleted())  System.out.println("Done - " + getContent() + "      Priority: " + priority);
        else System.out.println( "    - " + getContent() + "      Priority: " + priority);
    }
}
