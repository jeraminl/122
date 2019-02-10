package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem extends Item implements ItemMutable, ItemPeekable{
    int priority;
    Date due;

    public TodoItem(String i) {
        super(i);
    }
    public TodoItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        priority = p;
        due = new Date(year,month,date,hrs,min);
    }
    public void printContent(){
        if (isCompleted())  System.out.println("Done - " + getContent()+ "  |Priority: " + priority + " |deadline: " + getDeadline());
        else System.out.println( "    - " + getContent()+ "  |Priority: " + priority + " |deadline: " + getDeadline());
    }

    public String getDeadline(){
        if (due != null) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            return dateFormat.format(due);
        }
        else {
            return "no deadline";
        }
    }

    public void setPriority(int n){
        priority = n;
    }

    public int getPriority(){
        return priority;
    }

    public void setDue(Date d){
        due = d;
    }
}
