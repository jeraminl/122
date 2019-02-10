package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GoalItem extends Item implements ItemMutable, ItemPeekable{
    int priority;
    Date due;
    ArrayList<Item> subGoalItems;


    public GoalItem(String i) {
        super(i);
        subGoalItems = new ArrayList<Item>();
    }

    public GoalItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        priority = p;
        due = new Date(year,month,date,hrs,min);
        subGoalItems = new ArrayList<Item>();
    }

    public void printContent(){
        if (isCompleted())  System.out.println("Done - " + getContent()+ "  |Priority: " + priority + " |deadline: " + getDeadline());
        else System.out.println( "    - " + getContent()+ "  |Priority: " + priority + " |deadline: " + getDeadline());
    }

    public void showItems(){
        System.out.println("---------" +getContent() + "'s sub items-----------");
        int i = 0;
        for (Item item : getSubGoalItems()){
            System.out.print(i + ": ");
            item.printContent();
            if (((GoalItem) item).getSubGoalItems().size() > 0){
                ((GoalItem) item).showItems();
            }
        }
        System.out.println("--------------------");

    }

    public ArrayList<Item> getSubGoalItems(){
        return subGoalItems;
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



    public void addItem(String n){
        GoalItem toAdd = null;
        ItemCreator iCreator = new GoalItemCreator();
        toAdd = (GoalItem)iCreator.create(n);
        getSubGoalItems().add(toAdd);
    }

    public void addItem(String i, int year, int month, int date, int hrs, int min, int p){
        GoalItem toAdd = null;
        ItemCreator iCreator = new GoalItemCreator();
        toAdd = (GoalItem)iCreator.create(i,year,month,date,hrs,min,p);
        getSubGoalItems().add(toAdd);
    }

    public void completeItem(int i){
        subGoalItems.get(i).complete();

        CompletedCleaner cleaner = CompletedCleaner.getInstance();
        cleaner.clean(subGoalItems, subGoalItems.get(i));
    }

}
