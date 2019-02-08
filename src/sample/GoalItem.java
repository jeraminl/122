package sample;

import java.util.ArrayList;
import java.util.Date;

public class GoalItem extends Item {
    int priority;
    Date due;
    ArrayList<GoalItem> subGoalItems;


    public GoalItem(String i) {
        super(i);
        subGoalItems = new ArrayList<GoalItem>();
    }

    public GoalItem(String i, int year, int month, int date, int hrs, int min, int p) {
        super(i);
        priority = p;
        due = new Date(year,month,date,hrs,min);
        subGoalItems = new ArrayList<GoalItem>();
    }

    public void showItems(){
        System.out.println("--------------------");

        for (GoalItem item : getSubGoalItems()){
            item.printContent();
            if (item.getSubGoalItems().size() > 0){
                item.showItems();
            }
        }
        System.out.println("--------------------");

    }
    public void addSubItems(GoalItem g){
        getSubGoalItems().add(g);

    }
    public ArrayList<GoalItem> getSubGoalItems(){
        return subGoalItems;
    }


}
